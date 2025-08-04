import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,S,M; //N=곡의 개수, S=시작 볼륨, M=최대 볼륨
    static int V[];
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) V[i] = Integer.parseInt(st.nextToken());

        boolean dp[][] = new boolean[N+1][M+1];
        dp[0][S] = true;
        for(int i=1; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(dp[i-1][j]){
                    if(j+V[i]<=M && j+V[i]>=0) dp[i][j+V[i]] = true;
                    if(j-V[i]>=0 && j-V[i]<=M) dp[i][j-V[i]] = true;
                }
            }
        }

        int ans = -1;
        for(int i=M; i>=0; i--){
            if(dp[N][i]){
                ans = i; break;
            }
        }

        if(ans==-1) System.out.println(-1);
        else System.out.println(ans);
    }
}
