import java.io.*;
import java.util.*;

public class Main {
    static int volume[];
    static int N,S,M; //곡 수, 시작 볼륨, 최대 볼륨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        volume = new int[N];
        for(int i=0; i<N; i++) volume[i] = Integer.parseInt(st.nextToken());

        boolean dp[][] = new boolean[N+1][M+1];
        dp[0][S] = true;
        for(int i=0; i<N; i++){
            for(int j=0; j<=M; j++){
                if(dp[i][j]){
                    if(j+volume[i]<=M) dp[i+1][j+volume[i]]=true;
                    if(j-volume[i]>=0) dp[i+1][j-volume[i]]=true;
                }
            }
        }
        int answer = -1;
        for(int i=M; i>=0; i--){
            if(dp[N][i]==true){
                answer = i; break;
            }
        }
        System.out.println(answer);
    }
}
