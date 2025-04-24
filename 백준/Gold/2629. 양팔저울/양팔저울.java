import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr1;
    static int[] arr2;
    static boolean[] isPossible = new boolean[40001];
    static boolean[][] isVisited = new boolean[31][40001];
    private static void dfs(int idx, int sum){
        if(isVisited[idx][sum]) return;
        isVisited[idx][sum] = true;
        if(idx == N){
            isPossible[sum] = true;
            return;
        }

        /*이 부분은 GPT와 함께.. ㅎㅎ */
        /*추가 왼쪽에 올라간 경우와 추가 오른쪽에 올라간 경우를 같이 생각해야 함 따라서 2갈래가 아닌 3갈래로 분기 3갈래로 분기
        * 기존 코드
        *  dfs(idx + 1, sum);
        *  dfs(idx + 1, sum + arr1[idx]);
        */
        dfs(idx + 1, sum); // 사용 안 함
        dfs(idx + 1, sum + arr1[idx]); // 왼쪽에 추가 올림
        dfs(idx + 1, Math.abs(sum - arr1[idx])); // 오른쪽에 추가 올림
    }

    public static void main(String[] args) throws IOException {
        //입력 받는 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr1 = new int[N]; //추를 담을 arr
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr1[i] = (Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr2 = new int[M];
        for(int i=0; i<M; i++) arr2[i] = (Integer.parseInt(st.nextToken()));
        isPossible[0] = true;
        dfs(0, 0);

        for(int num : arr2){
            if(isPossible[num]) System.out.print("Y ");
            else System.out.print("N ");
        }
    }
}