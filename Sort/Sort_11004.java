import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        int[] list = new int[N];
        String[] st = br.readLine().split(" ");

        for (int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st[i]);
        }

        Arrays.sort(list);
        System.out.println(list[K-1]);
    }
}
