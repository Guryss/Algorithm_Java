public class SychoiVolunteerManager {
    private String mName;  //봉사단체명
    private SychoiVolunteer[] volunteers;  //봉사단체에 저장할 수 있는 저장구조
    private final int CAP =3;  //저장할 수 있는 봉사활동 개수 3개로 고정
    private int count =0;  //현재 저장된 봉사활동 개수
    public SychoiVolunteerManager(String name){
        mName=name;
        volunteers = new SychoiVolunteer[this.CAP];
    }

    @Override
    public String toString() {
       String str = "봉사단체명 : "+mName+"\n";
       str += "등록된 봉사활동 : "+count+"\n";
       str += "------ 봉사활동 현황 리스트 ------\n";
       if(count==0){
           str+= "등록된 봉사활동이 없습니다.\n";
       }
       else{
           changeRank();
           for(SychoiVolunteer vlr : volunteers){
               str += "참여자 순위 : "+vlr.rank+"등\n";
               str += vlr.toString();
               str += "-----------------------------\n";
           }
       }

       return str;
    }

    public void addVolunteer(SychoiVolunteer sv){
        //중복 제거 알고리즘!! -> boolean 변수 이용해서 처리했음 .. 생각보다 간단함
        boolean flag = false;
        for(int i=0; i<count; i++) {
            if (volunteers[i].vName.equals(sv.vName)) {
                flag = true;
                System.out.println("같은 봉사활동은 중복저장할 수 없습니다.");
                //System.out.println(count);
            }
        }
        if(this.count < this.CAP){
            if(!flag){
                this.volunteers[this.count++]=sv;
                System.out.println("등록이 잘 되었습니다.");
                //업캐스팅:부모클래스의 참조변수로 자식클래스의 객체 참조
                //부모클래스 변수 = 자식클래스타입 (자동타입변환)
            }
        }
        else {
            System.out.println("더이상 추가할 수 없습니다.");
        }
    }

    public SychoiVolunteer findVolunteer(String vname) {
       for(SychoiVolunteer vlr : volunteers){
           if(vlr==null) break;
           if(vname.equals(vlr.vName)){
               return vlr;
               //break: 해당 if문만 종료시킴.
               //return: if문을 포함한 메소드 자체를 종료시킴.
           }
       }
        System.out.println("해당하는 봉사활동을 찾을 수 없습니다.");
        return null;
    }

    public void changeRank(){
        for(int i=0; i<this.count; i++){
            for(int j=0; j<this.count; j++){
                if(this.volunteers[i].now<this.volunteers[j].now){
                    this.volunteers[i].rank++;
                }
            }
        }
    }


}
