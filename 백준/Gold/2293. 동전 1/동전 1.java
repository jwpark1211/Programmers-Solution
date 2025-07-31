import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, k;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) list.add(Integer.parseInt(br.readLine()));

        int dp[] = new int[k+1];
        dp[0] = 1;
        for(int coin : list){
            for(int i=coin; i<=k; i++){
                dp[i] += dp[i-coin];
            }
        }

        System.out.println(dp[k]);
    }
}
