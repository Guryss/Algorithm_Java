import java.util.Scanner;

public abstract class SychoiVolunteer {
    public static Scanner scan = new Scanner(System.in);
    protected String vName;  //자원봉사명
    protected int capacity;  //참여가능인원
    protected int now;  //현재 참여인원
    protected SychoiMember[] member;  //자원봉사에 참여한 인원 정보 저장하는 배열
    protected int rank = 1;  //참여자 순위

    public SychoiVolunteer(String vname, int cap){
        vName = vname;
        capacity = cap;
        member = new SychoiMember[capacity];
    }

    @Override
    public String toString() {
       String str = "자원봉사명 : "+vName+"\n";
       str += "참여가능 인원 : "+capacity+"명\n";
       str += "현재 참여인원 : "+now+"명";
       return str;
    }

    public String getvName() {
        return vName;
    }

    public abstract void join(SychoiMember sm);
    //물적봉사, 재능봉사의 두가지 경우에 대해 오버라이딩 필요

    }


