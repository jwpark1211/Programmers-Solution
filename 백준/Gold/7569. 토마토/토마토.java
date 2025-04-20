import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] board;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로
        H = sc.nextInt(); // 높이

        board = new int[H][N][M]; // z, y, x 순서

        Queue<Point> q = new LinkedList<>();

        // 입력 받기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    board[h][n][m] = sc.nextInt();
                    if (board[h][n][m] == 1) {
                        q.offer(new Point(m, n, h)); // x, y, z
                    }
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) continue;

                if (board[nz][ny][nx] == 0) {
                    board[nz][ny][nx] = board[cur.z][cur.y][cur.x] + 1;
                    q.offer(new Point(nx, ny, nz));
                }
            }
        }

        int day = 0;
        boolean allRipe = true;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (board[h][n][m] == 0) {
                        allRipe = false;
                    }
                    day = Math.max(day, board[h][n][m]);
                }
            }
        }
        if(allRipe) System.out.println(day -1);
        else System.out.println(-1);
    }
    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
