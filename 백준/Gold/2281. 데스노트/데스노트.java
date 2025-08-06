import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int names[] = new int[1001];
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) names[i] = Integer.parseInt(br.readLine());

        int dp[] = new int[n+1];
        for(int i=1; i<=n; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] =0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                int lineCnt = canOneLine(j, i);
                if(lineCnt==-1) continue;
                if(i==n){
                    dp[i] = Math.min(dp[i], dp[j-1]);
                }else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + (m - lineCnt) * (m - lineCnt));
                }
            }
        }
        System.out.println(dp[n]);
    }

    public static int canOneLine(int startIdx, int endIdx){
        int cnt = 0;
        for(int i=startIdx; i<=endIdx; i++){
            cnt += names[i-1];
            if(i!=endIdx) cnt += 1;
        }
        if(cnt<=m) return cnt;
        return -1;
    }
}
