import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int sum = 0;
        int[]  numArr = new int[10];  // 0~9 숫자의 개수를 담는 배열
        int[] temp = new int[st.length()];
        for (int i=0; i<temp.length; i++) {
            temp[i] = Integer.parseInt(st.substring(i, i+1));
            sum += temp[i];
            numArr[temp[i]] += 1;
        }
        StringBuilder sb = new StringBuilder();

        if (!st.contains("0")) System.out.println("-1");  // 숫자에 0이 없을 때
        else if (sum % 3 != 0) System.out.println("-1");  // 자릿수합이 3의배수가 아닐때
        // 위 조건을 모두 만족하지 않는 수는 30의 배수이다.
        else {
            // 가장 큰 수를 구하기 위해 역방향 for문 수행
            for (int i = 9; i>=0; i--) {
                while(numArr[i] > 0) {
                    sb.append(i);
                    numArr[i]--;
                }
            }
            System.out.println(sb);
        }

    }
}