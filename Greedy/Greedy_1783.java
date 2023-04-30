import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Greedy_1783 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);  // 세로 길이
        M = Integer.parseInt(st[1]);  // 가로 길이

        System.out.println(count());
    }
    static int count() {
        if (N == 1) return 1;
        if (N == 2) {
            // 이동 횟수 4번을 넘으면 이동방법 제한
            return Math.min((M+1)/2, 4);
        }
        // N이 3 이상일 때
        if(M<7) return Math.min(M, 4);
        else return M-2;
    }
}
