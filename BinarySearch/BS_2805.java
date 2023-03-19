import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BS_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        int[] tree = new int[N];  // 나무들의 길이를 저장한 배열

        int max = 0;
        int min = 0;

        String[] stt = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(stt[i]);

            if(max < tree[i])
                max = tree[i];  // 나무 길이들 중 최댓값
        }

        while(min < max) {
            long treeSum = 0;  // 잘린 나무들 길이 합
           int mid = (min+max)/2;  // 잘린 위치에 대해 mid값 부여

           for(int i=0; i<N; i++) {
               if(tree[i]-mid > 0)
                   treeSum += tree[i]-mid;
            }

           if(treeSum < M)
               max = mid;  // 나무가 덜 잘렸으므로 max값이 작아져아한다.
            else min = mid+1;  // treeSum과 M이 같을때에도 +1이 되므로 최종결과값은 -1해줘야함.
        }

        System.out.println(min-1);

    }
}
