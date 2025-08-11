import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final static int mod = 1_000_000_007;
    static int A,B,C,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int dp[][][][] = new int[N+1][A+1][B+1][C+1];
        dp[0][0][0][0] = 1;
        for(int n=1; n<=N; n++){
            for(int a=0; a<=A; a++){
                for(int b=0; b<=B; b++){
                    for(int c=0; c<=C; c++){
                        if(a!=0) dp[n][a][b][c] = (dp[n-1][a-1][b][c] + dp[n][a][b][c])%mod;
                        if(b!=0) dp[n][a][b][c] = (dp[n-1][a][b-1][c] + dp[n][a][b][c])%mod;
                        if(c!=0) dp[n][a][b][c] = (dp[n-1][a][b][c-1] + dp[n][a][b][c])%mod;
                        if(a!=0 && b!=0) dp[n][a][b][c] = (dp[n-1][a-1][b-1][c] + dp[n][a][b][c])%mod;
                        if(b!=0 && c!=0) dp[n][a][b][c] = (dp[n-1][a][b-1][c-1] + dp[n][a][b][c])%mod;
                        if(a!=0 && c!=0) dp[n][a][b][c] = (dp[n-1][a-1][b][c-1] + dp[n][a][b][c])%mod;
                        if(a!=0 && b!=0 && c!=0) dp[n][a][b][c] = (dp[n-1][a-1][b-1][c-1] + dp[n][a][b][c])%mod;
                    }
                }
            }
        }
        System.out.println(dp[N][A][B][C]);
    }
}
