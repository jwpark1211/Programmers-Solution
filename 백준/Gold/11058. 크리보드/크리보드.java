import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        long dp[] = new long[101];
        for(int i=0; i<=100; i++) dp[i] = i; //dp 초기화

        //dp 계산..
        for(int i=7; i<=100; i++){
            dp[i] = Math.max(dp[i], dp[i-3]*2);
            dp[i] = Math.max(dp[i], dp[i-4]*3);
            dp[i] = Math.max(dp[i], dp[i-5]*4);
        }

        System.out.println(dp[N]);
    }
}
