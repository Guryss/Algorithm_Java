import java.util.Scanner;

public class DP_11055 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int N = scan.nextInt();
        long result = 0;

        int[] A = new int[N];
        long[] dp = new long[N]; //합을 저장하는 수열

        for(int i=0; i<N; i++)
            A[i] = scan.nextInt();

        for(int i=0; i<N; i++) {
            dp[i] = A[i];  //해당하는 A배열의 값으로 초기화

            for(int j=0; j<i; j++) {
                if(A[i] > A[j])
                    dp[i] = Math.max(dp[i], dp[j]+A[i]);
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

    }
}
