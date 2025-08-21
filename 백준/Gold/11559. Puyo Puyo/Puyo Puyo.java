import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static final int H = 12, W = 6;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[H][W];
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) board[i][j] = line.charAt(j);
        }

        while (true) {
            boolean[][] visited = new boolean[H][W];
            boolean[][] toClear = new boolean[H][W];
            boolean poppedThisTurn = false;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (board[i][j] == '.' || visited[i][j]) continue;

                    char color = board[i][j];
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    ArrayList<int[]> comp = new ArrayList<>();
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                    comp.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                            if (!visited[nx][ny] && board[nx][ny] == color) {
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                                comp.add(new int[]{nx, ny});
                            }
                        }
                    }

                    if (comp.size() >= 4) {
                        poppedThisTurn = true;
                        for (int[] c : comp) toClear[c[0]][c[1]] = true;
                    }
                }
            }

            if (!poppedThisTurn) break; // 더 이상 터질 게 없으면 종료

            // 동시에 제거
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (toClear[i][j]) board[i][j] = '.';
                }
            }

            // 중력
            fall(board);

            ans++; // 한 턴(=연쇄) 증가
        }

        System.out.println(ans);
    }

    static void fall(char[][] board) {
        for (int col = 0; col < W; col++) {
            int write = H - 1; // 아래부터 채움
            for (int row = H - 1; row >= 0; row--) {
                if (board[row][col] != '.') {
                    char tmp = board[row][col];
                    board[row][col] = '.';
                    board[write][col] = tmp;
                    write--;
                }
            }
        }
    }
}
