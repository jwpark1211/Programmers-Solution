import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int names[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        names = new int[n+1];
        for(int i=1; i<=n; i++) names[i] = Integer.parseInt(br.readLine());

        int sumLen[] = new int[n+1];
        sumLen[1] = names[1];
        for(int i=2; i<=n; i++) sumLen[i] = sumLen[i-1]+names[i];
        //System.out.println(Arrays.toString(sumLen));

        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                int len = sumLen[i]-sumLen[j]+(i-j-1);
                if(len<=m){
                    if(i==n) dp[i] = Math.min(dp[i],dp[j]);
                    else dp[i] = Math.min(dp[i], dp[j]+(m-len)*(m-len));
                }
            }
        }
        System.out.println(dp[n]);
    }
}
