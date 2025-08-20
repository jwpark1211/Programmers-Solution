import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int total; //전체 객차 수
    static int[] people;
    static int max; //한 소형 기관차가 끌 수 있는 객차 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[total+1];
        for(int i=1; i<=total; i++) people[i] = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(br.readLine());

        int[] sum = new int[total+1];
        for(int i=1; i<=total; i++) sum[i]=sum[i-1]+people[i];

        int dp[][] = new int[4][total+1];
        for(int i=1; i<=3; i++){
            for(int j=max*i; j<=total; j++){
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-max]+(sum[j]-sum[j-max]));
            }
        }
        System.out.println(dp[3][total]);
    }
}
