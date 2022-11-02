import java.util.Scanner;

public class DP_11057 {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int[][] dp = new int [N+1][10];  // --* 2차원 배열 생성

        for(int i=0; i<10; i++){
            dp[0][i] = 1;  //N=0일떄 값 초기화 (자릿수 1일때)
        }

        for(int i=1; i<N+1; i++){  //자릿수
            for(int j=0; j<10; j++) {  //마지막 자릿수의 숫자
                for(int k=j; k<10; k++) {
                    dp[i][j] += dp[i-1][k];  //이전 자릿수 값 더함
                    dp[i][j] %= 10007;  //틀린 이유!!!
                }
            }
        }
        System.out.println(dp[N][0]%10007);
    }
}
