import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix; // matrix[i] = {rows, cols}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());       // 1-based 사용
        matrix = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken()); // r_i
            matrix[i][1] = Integer.parseInt(st.nextToken()); // c_i
        }

        long[][] dp = new long[N + 1][N + 1];
        final long INF = Long.MAX_VALUE / 4;

        // 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) dp[i][j] = INF;
            dp[i][i] = 0;
        }

        // len = 구간 길이 (2..N)
        for (int len = 2; len <= N; len++) {
            for (int j = 1; j + len - 1 <= N; j++) {      // j = 시작
                int end = j + len - 1;                    // 끝 = j+len-1
                for (int k = j; k <= end - 1; k++) {      // 중간 분할점
                    long cost = dp[j][k] + dp[k + 1][end]
                             + 1L * matrix[j][0] * matrix[k][1] * matrix[end][1];
                    if (cost < dp[j][end]) dp[j][end] = cost;
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}
