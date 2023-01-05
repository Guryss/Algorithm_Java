import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        String[] list = new String[S.length()];  // 문자열 S 길이 크기를 가진 배열 생성

        for(int i=0; i<S.length(); i++)
            list[i] = S.substring(i);

        Arrays.sort(list);

        for(int i=0; i<S.length(); i++)
            System.out.println(list[i]);
    }
}
