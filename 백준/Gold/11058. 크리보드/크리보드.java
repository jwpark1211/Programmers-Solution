import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long dp[] = new long[N+1];
        for(int i=0; i<=N; i++) dp[i] = i;

        for(int i=5; i<=N; i++){
            dp[i] = Math.max(dp[i], dp[i-3]*2);
            dp[i] = Math.max(dp[i], dp[i-4]*3);
            dp[i] = Math.max(dp[i], dp[i-5]*4);
        }

        System.out.println(dp[N]);
    }
}
