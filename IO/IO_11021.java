import java.util.Scanner;

public class IO_11021 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();  //테스트 케이스의 개수 T
        int[] result = new int[T];

        for(int i=0; i<T; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            result[i] = a+b;
        }

        for(int i=0; i<T; i++) {
            System.out.println("Case #" + (i+1) +": "+result[i]);
        }
    }
}
