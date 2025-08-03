import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static List<Integer> answer = new ArrayList<>();
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        //=== 입력 ===//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = tmp.charAt(j);
            }
        }

        //=== BFS ===//
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && graph[i][j]=='1'){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    int cnt = 1;
                    while(!q.isEmpty()){
                        Point cur = q.poll();

                        for(int k=0; k<4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                            if(graph[nx][ny]=='0') continue;
                            if(visited[nx][ny]) continue;

                            visited[nx][ny] = true;
                            cnt ++;
                            q.add(new Point(nx, ny));
                        }
                    }
                    answer.add(cnt);
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for(int a : answer) System.out.println(a);
    }
}
