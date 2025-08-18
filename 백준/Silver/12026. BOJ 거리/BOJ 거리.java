import java.io.*;
import java.util.*;

public class Main {
    static int N; //링크의 집 위치
    static String S; //총 문장(??)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = br.readLine();

        long dp[] = new long[N+1];
        for(int i=2; i<=N; i++) dp[i] = Integer.MAX_VALUE;

        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){
                if(isBeforeWord(j, i)){
                    dp[i] = Math.min(dp[i], dp[j]+(i-j)*(i-j));
                }
            }
        }

        if(dp[N]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N]);
    }
    public static boolean isBeforeWord(int idx1, int idx2){
        int num1 = getNumber(S.charAt(idx1-1));
        int num2 = getNumber(S.charAt(idx2-1));
        return (num1+1)%3==num2;
    } 
    public static int getNumber(char c){
        if (c=='B') return 0;
        else if(c=='O') return 1;
        else return 2;
    }
}
