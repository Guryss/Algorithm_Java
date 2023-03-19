import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BS_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 상근이의 숫자카드 개수
        int[] card = new int[N];  /// 상근이의 숫자카드에 적힌 숫자 배열
        String[] st = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(card);  // card를 크기순으로 정렬

        int M = Integer.parseInt(br.readLine());
        int[] num = new int[M];
        String[] stt = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            num[i] = Integer.parseInt(stt[i]);
        }
        int[] result = new int[M];

        for(int i=0; i<M; i++) {
            int mindex = 0;
            int maxdex = N-1;
            while(mindex <= maxdex) {
                int middex = (mindex + maxdex)/2;
                int mid = card[middex];
                if(num[i]>mid) mindex = middex +1;
                else if(num[i] <mid) maxdex = middex-1;
                else {
                    result[i] = 1;
                    break;
                };
            }
        }
        for(int i=0; i<M; i++)
            System.out.println(result[i]);
    }
}
