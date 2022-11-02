import java.util.Scanner;

public class DP_10844 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        //길이가 N인 계단 수가 총 몇개인지 구하기

        int[][] dp = new int[N+1][10];

        for(int i=1; i<10; i++) {  //0은 고려안하므로 1부터 시작
            dp[1][i] = 1;  //자릿수가 1일때 초깃값 설정
        }

        for(int i=2; i<N+1; i++) {  //자릿수
            for (int j=0; j<10; j++) {  //마지막 숫자
                if( j == 0) {  //막숫자가 0일때는 1만 고려
                    dp[i][0] = dp[i-1][1] % 1000000000;
                }
                else if(j == 9){  //막숫자가 9일때는 8만 고려
                    dp[i][9] = dp[i-1][8] % 1000000000;
                }
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
                }
            }
        }
        long result = 0;  //타입은 long으로 설정!!
        for (int i=0; i<10; i++)
            result += dp[N][i];

        System.out.println(result % 1000000000);
    }
}
