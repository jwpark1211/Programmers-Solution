import java.io.*;
import java.util.*;

public class Main {
    static int N, K, W, V; //물건 수, 최대 배낭 무게, 물건 무게, 물건 가치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int dp[] = new int[K+1];
        int w[] = new int[N];
        int v[] = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=K; j>=w[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
