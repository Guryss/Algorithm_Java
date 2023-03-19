import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BS_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);  // 집의 개수
        int C = Integer.parseInt(st[1]);  // 공유기의 개수
        int[] home = new int[N];

        for(int i=0; i<N; i++)
            home[i] = Integer.parseInt(br.readLine());
        Arrays.sort(home);  // 집을 위치순으로 정렬

        int min = 1;
        int max = home[N-1]-home[0];  // 집 간 최대거리
        int result = 0;

        while(min<=max) {
            int mid = (min+max)/2;
            int left = home[0];
            int cNum = 1;  // 맨 왼쪽집에 설치하고 시작하기 때문

            for(int i=1; i<N; i++) {
                if(home[i]-left >= mid){
                    cNum++;
                    left = home[i];  // 갱신
                }
            }
            if(cNum >= C){
                // 더 많이 설치됨 -> 오른쪽으로 이동해서 더 긴 간격 찾기
                result = mid;
                min = mid+1;
            }
            else {
                //더 적게 설치함 -> 왼쪽으로 이동해 더 짧은 간격을 찾기
                max = mid-1;
            }
        }
        System.out.println(result);
    }
}
