import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);  // 여학생 수
        int M = Integer.parseInt(st[1]);  // 남학생 수
        int K = Integer.parseInt(st[2]);  // 인턴쉽에 참여해야하는 인원 수
        int maxTeam = 0;  // 만들 수 있는 팀의 최대 개수

        while(N+M >= K+3 && N>=2 && M>=1) {
            N -= 2;
            M -= 1;
            maxTeam++;
        }



        System.out.println(maxTeam);
    }

}