import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] arr, res;

    public static void dfs(int start, int current, boolean[] visited) {
        for (int next = 0; next < N; next++) {
            if (arr[current][next] == 1 && !visited[next]) {
                visited[next] = true;
                res[start][next] = 1;
                dfs(start, next, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        res = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS 수행
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            dfs(i, i, visited);
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
