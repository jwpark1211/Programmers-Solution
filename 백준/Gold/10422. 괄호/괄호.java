import java.io.*;

public class Main{
    static int mod = 1_000_000_007;
    static int T;
    static int L[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        L = new int[T];
        for(int i=0; i<T; i++) L[i] = Integer.parseInt(br.readLine());

        long dp[] = new long[5001];
        dp[0]=1; dp[2]=1;

        for(int i=4; i<=5000; i+=2){
            for(int j=0; j<i; j+=2){
                dp[i]+=(dp[j]*dp[i-j-2])%mod;
                dp[i]%=mod;
            }
        }
        for(int l : L) System.out.println(dp[l]);
    }
}
