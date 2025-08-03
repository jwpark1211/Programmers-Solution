import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int dp[] ;
    static int Ti[];
    static int Pi[];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Ti = new int[N+1];
        Pi = new int[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            if(i+Ti[i]-1<=N){
                dp[i+Ti[i]-1] = Math.max(dp[i+Ti[i]-1],Pi[i]+dp[i-1]);
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
            answer = Math.max(dp[i], answer);
        }

        //결과 출력
        System.out.println(answer);
    }

}
