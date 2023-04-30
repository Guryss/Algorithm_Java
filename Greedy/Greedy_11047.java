import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);  // 동전의 종류 수
        int K = Integer.parseInt(st[1]);  // 동전 가치의 합
        int minCount = 0;  // 필요한 동전 개수의 최솟값
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while(K>0) {
            for (int i=N-1; i>=0; i--) {
                if(arr[i]<=K) {
                    K = K - arr[i];
                    minCount++;
                    break;
                }
            }
        }
        System.out.println(minCount);

    }


}