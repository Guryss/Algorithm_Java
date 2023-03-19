import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DC_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);  // 배열 A의 크기
        int M = Integer.parseInt(st[1]);  // 배열 B의 크기
        int[] Sum = new int[M+N];
        int index = 0;

        String[] Ast = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            Sum[index++] = Integer.parseInt(Ast[i]);
        }

        String[] Bst = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            Sum[index++] = Integer.parseInt(Bst[i]);
        }
        Arrays.sort(Sum);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Sum.length; i++)
            sb.append(Sum[i]+" ");

        System.out.println(sb);
    }
}
