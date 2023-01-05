import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Sort_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 수의 개수
        int[] arr = new int[N];
        int[] counting = new int[10001];
        int[] sort = new int[N];

        //Counting Sort 사용해보자!!
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            counting[arr[i]]++;
        }

        for (int i=1; i<counting.length; i++)
            counting[i] += counting[i-1];  // 누적 합

        // 뒤에서부터 result 배열에 집어넣는다..
        for (int i=arr.length-1; i>=0; i--) {
            int temp = arr[i];
            counting[temp]--;
            sort[counting[temp]]=temp;
        }

        for(int i=0; i<sort.length; i++)
            System.out.println(sort[i]);

    }
}
