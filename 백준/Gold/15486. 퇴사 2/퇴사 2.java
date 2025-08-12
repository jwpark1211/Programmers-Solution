import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int time[] = new int[N+1];
        int profit[] = new int[N+1];
        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N+1];
        for(int i=1; i<=N; i++){
            dp[i] = Math.max(dp[i],dp[i-1]);
            if(i+time[i]-1<=N) {
                dp[i + time[i] - 1] = Math.max(dp[i + time[i] - 1], profit[i] + dp[i-1]);
            }
        }
        System.out.println(dp[N]);
    }
}
