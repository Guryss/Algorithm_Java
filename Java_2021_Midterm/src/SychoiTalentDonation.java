public class SychoiTalentDonation extends SychoiVolunteer{
    private String tName;  //봉사할 재능 정보

    public SychoiTalentDonation(String vname, int cap, String tname){
        super(vname, cap);
        tName=tname;
    }

    @Override
    public String toString() {
       String str = super.toString();
       str += "\n봉사할 재능 : "+tName+"\n";
       str += "참여자 명단\n";
       str += "----------------------------------\n";
       if(this.now==0){
           str += "신청자가 없습니다.\n";
       }
       else{
           for(SychoiMember m : member){
               str += m.toString()+"\n";
           }
       }
       return str;
    }

    @Override
    public void join(SychoiMember sm) {
        for (SychoiMember m : member){
            if(m==null) break;
            if(m.getmName().equals(sm.getmName())){
                System.out.println(sm.getmName()+"님 동일한 봉사활동에는 한번만 신청하실 수 있습니다.");
                return;
            }
        }
        String talent = "";
        System.out.print(sm.getmName()+"님 기부할 재능을 입력해 주세요 : ");
        talent = scan.nextLine();
        if(talent.equals(this.tName)){
            System.out.println(sm.getmName()+"님 신청이 완료되었습니다. 감사합니다.");
            sm.increaseNum();
            this.member[now++]=sm;
        }
        else{
            System.out.println("해당 봉사활동에서 필요로 하는 재능과 일치하지 않습니다. 다른 기부활동에 동참해 주세요.");
        }
    }
}
