import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 반 학생 수
        String[][] list = new String[N][4];


        for (int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            list[i][0] = st[0];  // 반 학생의 이름
            list[i][1] = st[1];  // 학생의 국어 성적
            list[i][2] = st[2];  // 학생의 영어 성적
            list[i][3] = st[3];  // 학생의 수학 성적
        }

        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[1].equals(o2[1])) {
                    if (o1[2].equals(o2[2])) {
                        if (o1[3].equals(o2[3])) {
                            // 모든 점수가 같을 때 -> 이름이 사전순으로 증가
                            return o1[0].compareTo(o2[0]);
                        } else {
                            // 국어, 영어 점수가 같을 때 -> 수학 점수가 감소하는 순서로
                            return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                        }
                    } else {
                        // 국어 점수가 같을 때 -> 영어 점수가 증가하는 순서로
                        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                    }
                } else {
                    // 모든 점수가 다를 때 -> 국어 점수가 감소하는 순서로
                    return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                }
            }
        });

        for (int i=0; i<N; i++)
            System.out.println(list[i][0]);

    }
}