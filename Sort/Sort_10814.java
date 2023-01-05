import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Sort_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int N = Integer.parseInt(br.readLine());  //온라인 회원 수
        String[][] list = new String[N][2];  //회원 정보를 저장

        for(int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            list[i][0] = st[0];  //회원 나이 저장
            list[i][1] = st[1];  //회원 이름 저장
        }

        // 나이가 같을 때의 처리 -> Comparator 사용
        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(Objects.equals(o1[0], o2[0]))
                    return 1;  // 먼저 들어온 순으로 정렬되어야 하기 때문이다..
                else {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            }
        });

        for (int i=0; i<N; i++) {
            System.out.println(list[i][0] + " " + list[i][1]);
        }
    }
}
