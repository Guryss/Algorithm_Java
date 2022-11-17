import java.util.Scanner;

public class DP_11722 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int result = 0;

        int[] A = new int[N];
        int[] dp = new int[N]; //길이를 저장하는 수열

        for(int i=0; i<N; i++)
            A[i] = scan.nextInt();

        for(int i=0; i<N; i++) {
            dp[i] = 1;  //1로 초기화

            for(int j=0; j<i; j++) {
                if(A[i] < A[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
