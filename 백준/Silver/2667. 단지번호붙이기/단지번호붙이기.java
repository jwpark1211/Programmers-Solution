import java.util.*;

//BFS 너비우선탐색 문제인듯!
public class Main {
    public static void main(String[] args) {
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};

        List<Integer> answer = new ArrayList<>();
        //초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[][] = new int[N][N];
        boolean visited[][] = new boolean[N][N];
        sc.nextLine();

        for(int i=0; i<N; i++){
            String line = sc.nextLine();
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        Queue<Dot> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==false && arr[i][j]==1){
                    q.offer(new Dot(i, j));
                    visited[i][j] = true;
                    int cnt = 1;
                    while(!q.isEmpty()){
                        Dot dot = q.poll();
                        for(int k=0; k<4; k++){
                            int nx = dot.x+dx[k];
                            int ny = dot.y+dy[k];
                            if(nx>=0 && nx<N && ny>=0 && ny<N && arr[nx][ny]==1 && visited[nx][ny]==false){
                                visited[nx][ny] = true;
                                cnt ++;
                                q.offer(new Dot(nx, ny));
                            }
                        }
                    }
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int a : answer){
            System.out.println(a);
        }
    }

    static class Dot{
        int x;
        int y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}