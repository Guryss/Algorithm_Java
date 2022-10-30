import java.util.Scanner;

public class DP_1463 {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        int num = scan.nextInt();
        int dp[] = new int [num+1];

        dp[0] = dp[1]=0;

        for(int i=2; i<num+1; i++){
            dp[i] = dp[i-1]+1;

            if(i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        System.out.println(dp[num]);
    }
}
