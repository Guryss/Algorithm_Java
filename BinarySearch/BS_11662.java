import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BS_11662 {
    static double Ax, Ay, Bx, By;
    static double Cx, Cy, Dx, Dy;
    // 결과값은 Double형이어야 함.
    static int error = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        Ax = Double.parseDouble(st[0]);
        Ay = Double.parseDouble(st[1]);
        Bx = Double.parseDouble(st[2]);
        By = Double.parseDouble(st[3]);
        Cx = Double.parseDouble(st[4]);
        Cy = Double.parseDouble(st[5]);
        Dx = Double.parseDouble(st[6]);
        Dy = Double.parseDouble(st[7]);

        //10의 -6승까지 오차 허용
        // -> 거리를 백만으로 나누어서 for문으로 일일히 1씩 추가해 거리를 계산
        double Adx = (Bx-Ax) / error;
        double Ady = (By-Ay) / error;
        double Cdx = (Dx-Cx) / error;
        double Cdy = (Dy-Cy) / error;

        // 두 사람의 시작점으로 거리 계산 시작
        double minDistance = calDistance(Ax, Ay, Cx, Cy);

        for(int i=1; i<=error; i++) {
            double temp = calDistance(Ax+Adx*i, Ay+Ady*i, Cx+Cdx*i, Cy+Cdy*i);
            if(temp < minDistance)
                minDistance = temp;
        }

        System.out.println(minDistance);
    }

    public static double calDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }
}
