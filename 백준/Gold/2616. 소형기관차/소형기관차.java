import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int trainNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person[] = new int[trainNum+1]; //35 40 50 10 30 45 60
        for(int i=1; i<=trainNum; i++) person[i] = Integer.parseInt(st.nextToken());
        //누적합 계산
        int sum[] = new int[trainNum+1];
        for(int i=1; i<=trainNum; i++) sum[i]=sum[i-1]+person[i];
        //한 소형차에 달릴 객차의 수
        int M = Integer.parseInt(br.readLine());

        int dp[][] = new int[4][trainNum+1];
        for(int i=1; i<4; i++){
            for(int j=M*i; j<=trainNum; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-M]+(sum[j]-sum[j-M]));
            }
        }

        System.out.println(dp[3][trainNum]);
    }
}
