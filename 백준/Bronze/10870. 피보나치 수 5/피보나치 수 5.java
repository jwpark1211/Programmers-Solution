import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        if(n==0) System.out.println(0);
        else{
            dp[0] = 0; dp[1] = 1;
            for(int i=2; i<=n; i++){
                dp[i] = dp[i-1]+dp[i-2];
            }
            System.out.println(dp[n]);
        }

    }
}