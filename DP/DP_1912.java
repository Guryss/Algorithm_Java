import java.util.Scanner;

public class DP_1912 {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);

       int n = scan.nextInt();
       int result = Integer.MIN_VALUE;

       int[] A = new int[n];
       int[] dp = new int[n];  //합을 저장하는 배열..

        for(int i=0; i<n; i++) {
            A[i] = scan.nextInt();
        }

        dp[0] = A[0];  //첫번째 항은 자기자신 뿐

        for(int i=1; i<n; i++)
            dp[i] = Math.max(Math.max(dp[i-1]+A[i], A[i]), A[i-1]+A[i]);

        for(int i=0; i<n; i++)
            result = Math.max(result, dp[i]);

        System.out.println(result);
    }
}
