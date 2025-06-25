import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static int N;
    public static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) dp[i] = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.println(ans);
    }
}