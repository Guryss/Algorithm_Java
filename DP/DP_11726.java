import java.util.Scanner;

public class DP_11726 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        //dp[n] = dp[n-1] + dp[n-2]

        int[] dp = new int[1002];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < N+1; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

        System.out.println(dp[N]);
    }
}
