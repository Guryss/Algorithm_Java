public class SychoiMember {
    private String mName;  //회원 이름
    private int mNum; //자원봉사 참여 횟수
    private int mtotalPrice;  //기부 총액

    public SychoiMember (String name){
        mName = name;
        mNum=0;
        mtotalPrice=0;
    }

    @Override
    public String toString() {
        String str = "회원이름 : "+mName+"\n";
        str += "자원봉사 참여 횟수 : "+mNum+"회\n";
        str += "기부 총액 : "+mtotalPrice+"원\n";
        return str;
    }

    public String getmName() {
        return mName;
    }

    public int getMtotalPrice() {
        return mtotalPrice;
    }

    public void increaseNum(){
        mNum +=1;
    }

    public void totalPrice(int money){
        mtotalPrice += money;
    }

}
