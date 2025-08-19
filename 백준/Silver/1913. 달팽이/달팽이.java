import java.io.*;

public class Main {
    static int dx[] = {-1,0,1,0}; //상우하좌
    static int dy[] = {0,1,0,-1}; //상우하좌
    static int dir = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int memo[][] = new int[N+1][N+1];

        //memo 먼저 채우기..
        int x = N/2+1; int y = N/2+1;
        int num = 1;
        int dist = 1;
        memo[x][y] = num;
        for(int i=1; i<N; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<dist; k++) {
                    x += dx[dir];
                    y += dy[dir];
                    memo[x][y] = ++num;
                }
                dir = (dir + 1) % 4;
            }
            if(i==N-1){
                for(int k=0; k<dist; k++) {
                    x += dx[dir];
                    y += dy[dir];
                    memo[x][y] = ++num;
                }
            }
            dist++;
        }

        //정답 출력
        int nx=0; int ny=0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.print(memo[i][j]+" ");
                if(memo[i][j]==M){
                    nx = i; ny = j;
                }
            }
            System.out.println();
        }
        System.out.println(nx+" "+ny);
    }
}
