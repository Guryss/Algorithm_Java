import java.util.InputMismatchException;

public class SychoiDonation extends SychoiVolunteer{
    private int totalPrice = 0;
    public SychoiDonation(String name, int cap){
        super(name, cap);
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "\n기부금 총액 : "+totalPrice+"원\n";
        str += "참여자 명단 (기부금액이 큰 순서)\n";
        str +="----------------------------------\n";
        if(this.now==0){
            str += "신청자가 없습니다.\n";
        }
        else{
            SychoiMember[] sortMember = sort();
            for(SychoiMember m : sortMember){
                str += m.toString()+"\n";
            }
        }
        return str;
    }

    @Override
    public void join(SychoiMember sm) {
        //같은 사람이 여러번 기부할 때에 대한 처리
        for(SychoiMember e : member){
            if(e==null) break;
            if(e.getmName().equals(sm.getmName())){
                donation(e);
                return;
            }
        }
        if(this.now<this.capacity){
            boolean temp = donation(sm);
            if(temp){
                this.member[now++]=sm;
            }
        }
        else
            System.out.println("참여 가능인원이 다 찼습니다.");
    }

    public boolean donation(SychoiMember m){
        int money = 0;
        do {
            try {
                System.out.print(m.getmName() + "님 기부할 금액을 입력해 주세요 : ");
                money = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("다시 입력해주세요.");
            } finally {
                scan.nextLine();
            }
        }while(true);

        if (money < 100) {
            System.out.println(m.getmName() + "님, 최소 기부금은 100원 이상이 되어야 합니다.");
            return false;

        } else {
            System.out.println(m.getmName() + "님 기부가 완료되었습니다. 감사합니다.");
            m.increaseNum();
            m.totalPrice(money);
            totalPrice += money;
            return true;
        }
    }

    public SychoiMember[] sort(){
        SychoiMember[] mem = this.member.clone();
        for(int i=0; i<this.now; i++){
            for(int j=i+1; j<this.now; j++){
                if(mem[i].getMtotalPrice() < mem[j].getMtotalPrice()){
                    SychoiMember temp = mem[i];
                    mem[i] = mem[j];
                    mem[j]=temp;
                }
            }
        }
        return mem;
    }
}
