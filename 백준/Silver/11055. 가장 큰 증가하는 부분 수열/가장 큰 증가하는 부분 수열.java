import java.util.*;

public class Main {
    public static void main(String[] args) {
        //초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();

        // DP 배열 초기화
        int[] dp = new int[N];
        for(int i=0; i<N; i++) dp[i] = arr[i];

        int answer = dp[0];
        //DP 돌리기
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]) dp[i] = Math.max(dp[i], arr[i]+dp[j]);
            }
            answer = Math.max (answer, dp[i]);
        }

        System.out.println(answer);
    }
}