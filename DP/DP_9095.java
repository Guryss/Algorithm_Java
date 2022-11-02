import java.util.Scanner;

public class DP_9095 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();  // number of test case

        int[] dp = new int[1000];

        dp[0] = 1;  //input값이 0일때는 경우의 수를 1로 처리...
        dp[1] = 1;
        dp[2] = 2;

        //dp[3]부터는 공식으로 계산 가능

        for (int i=0; i<T; i++){
            int n = scan.nextInt();

            for (int j=3; j<n+1; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }

    }

}
