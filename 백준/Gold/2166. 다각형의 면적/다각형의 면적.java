import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] xArr = new long[N+1];
        long[] yArr = new long[N+1];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            xArr[i] = Long.parseLong(st.nextToken());
            yArr[i] = Long.parseLong(st.nextToken());
        }
        xArr[N] = xArr[0];
        yArr[N] = yArr[0];

        //신발끈 계산
        long sum1 = 0; long sum2 = 0;
        for(int i=0; i<N; i++){
            sum1 += xArr[i]*yArr[i+1];
            sum2 += xArr[i+1]*yArr[i];
        }

        double res = 0.5 * Math.abs(sum1-sum2);
        System.out.printf("%.1f",res);
    }
}

