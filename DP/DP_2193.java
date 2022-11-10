import java.util.Scanner;

public class DP_2193 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();  //N자리수 (1<=N<=90)

        long[][] dp = new long[2][N+1];
        // row : 각 자리수마다 가능한 이친수의 개수
        // col : 이친수의 마지막 숫자가 0, 1인 경우

        dp[0][0] = dp[1][0] = dp[0][1] = 0;
        dp[1][1] = 1;  // 1

        for (int i=2; i<N+1; i++) {
            dp[0][i] = dp[0][i-1] + dp[1][i-1];
            dp[1][i] = dp[0][i-1];
        }

        long result = dp[0][N] + dp[1][N];

        System.out.println(result);
    }
}