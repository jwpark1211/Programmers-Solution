import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int dp[][] = new int[5001][5001];
        dp[2][1] = 1;
        for(int i=4; i<=5000; i+=2){
            for(int j=i/2; j>0; j--){
                dp[i][j]= (dp[i][j+1]+dp[i-2][j-1])%1000000007;
            }
        }

        /*for(int i=0; i<=10; i++){
            for(int j=0; j<=10; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int i=0; i<T; i++) {
            int key = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int j = 0; j <= key/2+1; j++) sum = (sum + dp[key][j])%1000000007;
            System.out.println(sum);
        }
    }
}
