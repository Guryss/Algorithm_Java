import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] arr;
    static int countMinus=0;
    static int countZero=0;
    static int countOne=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        checkCount(0, 0, N);

        System.out.println(countMinus);
        System.out.println(countZero);
        System.out.println(countOne);
    }
    // 같은 숫자를 가진 종이가 있는지 검사하는 함수
    // -> 있으면 true 반환, 아니면 false 반환
    public static boolean checkPaper(int row, int col, int size) {
        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(arr[row][col] != arr[i][j])  // 최상단좌측값과 다르면 false
                    return false;
            }
        }
        return true;
    }

    // 각 숫자에 대한 카운트를 해주는 함수
    public static void checkCount(int row, int col, int size) {
        if(checkPaper(row, col, size)) {
            int temp = arr[row][col];
            if(temp == -1) countMinus++;
            else if(temp == 0) countZero++;
            else if(temp == 1) countOne++;
            return;  // ruturn의 중요성! -> if문을 종료시키고 자신을 호출한 곳으로 다시 되돌아간다.
        }

        int newSize = size / 3;
        for(int i=row; i<row+size; i+=newSize) {
            for(int j=col; j<col+size; j+=newSize) {
                checkCount(i, j, newSize);
            }
        }
    }

}