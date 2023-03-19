import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Graph_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int K = Integer.parseInt(st[0]);  // 랜선의 개수
        int N = Integer.parseInt(st[1]);  // 필요한 랜선의 개수
        int arr[] = new int[K];

        long max = 0;
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i])
                max = arr[i];  // max = 802
        }
        max++;

        long min = 0;
        long mid = 0;

        while (min<max) {
            mid = (max+min)/2;

            long count = 0;
            for(int i=0; i<arr.length; i++) {
                count = count + arr[i] / mid;  // count개수(2+1+1+1=5)를 생각
            }

            if(count<N) {
                max = mid;
            }
            else {
                min = mid+1;
            }
        }

        // 이미 한번 1이 더해졌기 때문에 1을 빼고 결과값 도출
        System.out.println(min-1);
    }
}
