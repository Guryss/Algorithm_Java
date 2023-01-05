import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 점의 개수
        int [][] list = new int[N][2];  // 점의 x,y를 저장하는 2차원 배열

        for(int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(st[0]);  // x좌표 저장
            list[i][1] = Integer.parseInt(st[1]);  // y좌표 저장
        }

        // x좌표가 같을 때의 처리 -> Comparator 사용
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];  // x좌표 같을 시 y좌표로 오름차순 비교
                else {
                    return o1[0] - o2[0];  // x좌표 다를 시 x좌표로 오름차순 비교
                }
            }
        });

        for(int i=0; i<N; i++)
            System.out.println(list[i][0] + " " + list[i][1]);

    }
}
