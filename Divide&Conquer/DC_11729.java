import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 하노이 실행 횟수 : 2^N-1
        sb.append((int)(Math.pow(2, N)-1)+"\n");

        hanoi(N, 1, 2, 3);
        System.out.println(sb);

    }

    public static void hanoi(int n, int A, int B, int C) {
        //원반의 수가 1개일 때의 처리
        if(n == 1) {
            sb.append(A + " " + C + "\n");
            return;
        }
        // 1개를 A에서 C로 이동시킴.
        hanoi(n-1, A, C, B);
        sb.append(A + " " + C + "\n");

        // n-1개를 B에서 C로 이동시킴.
        hanoi(n-1, B, A, C);
        // N == 1일때 sb에 입력되기 때문에 여기서 입력할 필요 없다.
        //sb.append(B + " " + C + "\n");
    }
}
