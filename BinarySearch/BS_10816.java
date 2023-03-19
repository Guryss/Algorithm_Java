import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;

public class BS_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        HashMap<Integer, Integer> card = new HashMap<>();
        for(int i=0; i<N; i++) {
            int key = Integer.parseInt(st[i]);
            //카운팅 처리
            if(card.containsKey(key))
                card.put(key, card.get(key)+1);
            else card.put(key, 1);
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        String[] stt = br.readLine().split(" ");
        int[] num = new int[M];
        for(int i=0; i<M; i++) {
            num[i] = Integer.parseInt(stt[i]);
            Integer count = card.get(num[i]);
            if(count!=null) sb.append(count+" ");
            else sb.append(0+" ");
        }
        System.out.println(sb);
    }
}
