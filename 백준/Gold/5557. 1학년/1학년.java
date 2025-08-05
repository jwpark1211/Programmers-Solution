import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] array; //Last 값 냄겨놔야해
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) array[i] = Integer.parseInt(st.nextToken());
        //   1 2 3 4 5 6 7 8 9 10 11
        // 0 8 3 2 4 8 7 2 4 0 8 8
        long dp[][] = new long[N+1][21];

        dp[1][array[1]] = 1;
        for(int i=2; i<N; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]>0){
                    if(j+array[i]<=20) dp[i][j+array[i]]+=dp[i-1][j];
                    if(j-array[i]>=0) dp[i][j-array[i]]+=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N-1][array[N]]);
    }

}
