import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] graph;
    static int answer = 0;
    static class Pipe{
       int x1; int y1;
       int x2; int y2;
       String dir; //H = 가로 방향, V = 세로 방향, D = 대각선 방향
       public Pipe(int x1, int y1, int x2, int y2, String dir){
           this.x1 = x1;
           this.y1 = y1;
           this.x2 = x2;
           this.y2 = y2;
           this.dir = dir;
       }
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        if(graph[N][N]==1) System.out.println(0);
        else {
            Queue<Pipe> q = new LinkedList<>();
            q.offer(new Pipe(1, 1, 1, 2, "H"));

            while (!q.isEmpty()) {
                Pipe cur = q.poll();

                if (cur.x2 == N && cur.y2 == N) {
                    answer++;
                    continue;
                }

                //가로 방향이었을 경우
                if (cur.dir.equals("H")) {
                    //가로 방향으로 이동하는 경우
                    if (cur.y2 < N && graph[cur.x2][cur.y2 + 1] == 0) {
                        q.offer(new Pipe(cur.x2, cur.y2, cur.x2, cur.y2 + 1, "H"));
                    }
                    //대각선 방향으로 이동하는 경우
                    if (cur.y2 < N && cur.x2 < N &&
                            graph[cur.x2][cur.y2 + 1] == 0 && graph[cur.x2 + 1][cur.y2 + 1] == 0 && graph[cur.x2 + 1][cur.y2] == 0) {
                        q.offer(new Pipe(cur.x2, cur.y2, cur.x2 + 1, cur.y2 + 1, "D"));
                    }
                }

                //세로 방향이었을 경우
                if (cur.dir.equals("V")) {
                    //세로 방향으로 이동하는 경우
                    if (cur.x2 < N && graph[cur.x2 + 1][cur.y2] == 0) {
                        q.offer(new Pipe(cur.x2, cur.y2, cur.x2 + 1, cur.y2, "V"));
                    }
                    //대각선 방향으로 이동하는 경우
                    if (cur.y2 < N && cur.x2 < N &&
                            graph[cur.x2][cur.y2 + 1] == 0 && graph[cur.x2 + 1][cur.y2 + 1] == 0 && graph[cur.x2 + 1][cur.y2] == 0) {
                        q.offer(new Pipe(cur.x2, cur.y2, cur.x2 + 1, cur.y2 + 1, "D"));
                    }
                }

                //대각선 방향이었을 경우
                if (cur.dir.equals("D")) {
                    //가로 방향으로 이동하는 경우
                    if (cur.y2 < N && graph[cur.x2][cur.y2 + 1] == 0) {
                        q.offer(new Pipe(cur.x2, cur.y2, cur.x2, cur.y2 + 1, "H"));
                    }
                    //세로 방향으로 이동하는 경우
                    if (cur.x2 < N && graph[cur.x2 + 1][cur.y2] == 0) {
                        q.offer(new Pipe(cur.x2, cur.y2, cur.x2 + 1, cur.y2, "V"));
                    }
                    //대각선 방향으로 이동하는 경우
                    if (cur.y2 < N && cur.x2 < N &&
                            graph[cur.x2][cur.y2 + 1] == 0 && graph[cur.x2 + 1][cur.y2 + 1] == 0 && graph[cur.x2 + 1][cur.y2] == 0) {
                        q.offer(new Pipe(cur.x2, cur.y2, cur.x2 + 1, cur.y2 + 1, "D"));
                    }
                }
            }
            System.out.println(answer);
        }
    }

}
