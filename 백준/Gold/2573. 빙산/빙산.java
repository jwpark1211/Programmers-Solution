import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M; //N = 행 M = 열
    static int[][] map;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;
        while(true){
            if(allWater()){
                flag = true;
                break;
            }
            if(countIce()>=2) break;
            oneYearLater();
            ans ++;
        }
        
        if(flag) System.out.println(0);
        else System.out.println(ans);
    }
    //모두 다 물인지 확인
    static boolean allWater(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]!=0) return false;
            }
        }
        return true;
    }
    //1년 후 빙산의 변화를 나타내는 메서드
    static void oneYearLater(){
        boolean visited[][] = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]>0){
                    visited[i][j] = true;
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(map[i][j]==0) break;
                        if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                        if(!visited[nx][ny] && map[nx][ny]==0) map[i][j]--;
                    }
                }
            }
        }
    }

    //덩어리의 개수를 확인하는 메서드
    static int countIce(){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]!=0 && !visited[i][j]){
                    q.offer(new int[]{i,j});
                    cnt++;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int x = cur[0]; int y = cur[1];
                        for(int k=0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                            if(!visited[nx][ny] && map[nx][ny]!=0){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
