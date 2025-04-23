import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static int answer = 0;
    private static void dfs(int idx, int sum){
        if(idx == N){
            if (sum==S) answer++;
            return;
        }
        dfs(idx+1, sum + arr[idx]);
        dfs(idx+1, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = (Integer.parseInt(st.nextToken()));
        dfs(0, 0);
        if(S==0) System.out.println(answer-1);
        else System.out.println(answer);
    }
}