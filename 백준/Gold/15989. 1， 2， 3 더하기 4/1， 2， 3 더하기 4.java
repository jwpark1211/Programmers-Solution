import java.io.*;
import java.util.Arrays;

public class Main {
    public static int N;
    public static int arr[];
    public static int max = 0;
    public static int dp[];

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            max = Math.max(a, max);
        }

        //dp 초기화
        dp = new int[max+1];
        Arrays.fill(dp,1);
        for(int i=2; i<max+1; i++){
            dp[i] += dp[i-2];
        }
        for(int i=3; i<max+1; i++){
            dp[i] += dp[i-3];
        }

        //결과 출력
        for(int i=0; i<arr.length; i++){
            System.out.println(dp[arr[i]]);
        }
    }

}