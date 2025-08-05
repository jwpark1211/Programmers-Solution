import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String S;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = br.readLine();

        int dp[] = new int[N+1];
        for(int i=0; i<N+1; i++) dp[i] = 1000000;
        dp[0] = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(canJump(S.charAt(i), S.charAt(j))){
                    dp[j] = Math.min(dp[j], dp[i]+(j-i)*(j-i));
                }
            }
        }

        if(dp[N-1]==1000000) System.out.println(-1);
        else System.out.println(dp[N-1]);

    }
    public static boolean canJump(char c1, char c2){
        if(c2=='B' && c1=='J') return true;
        if(c2=='O' && c1=='B') return true;
        if(c2=='J' && c1=='O') return true;
        return false;
    }
}
