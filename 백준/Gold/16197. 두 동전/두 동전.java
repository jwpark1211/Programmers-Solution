import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0}; //상 좌 하 우
    static int dy[] = {0, -1, 0, 1};
    static int N, M;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean wall[][] = new boolean[N+2][M+2]; //벽 정보 , default = false, 벽 있는 경우 true
        Queue<Integer> coinIdx = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                //만약 벽이라면
                if(tmp.charAt(j-1)=='#') wall[i][j] = true;
                if(tmp.charAt(j-1)=='o'){
                    coinIdx.add(i);
                    coinIdx.add(j);
                }
            }
        }

        Queue<Coin> q = new LinkedList<>();
        int x1 = coinIdx.poll();
        int y1 = coinIdx.poll();
        int x2 = coinIdx.poll();
        int y2 = coinIdx.poll();
        q.add(new Coin(x1,y1,x2,y2,0));

        boolean isFind = false;
        boolean isVisited[][][][] = new boolean[N+2][M+2][N+2][M+2];
        isVisited[x1][y1][x2][y2] = true;

        while(!q.isEmpty()){
            Coin cur = q.poll();

            for(int i=0; i<4; i++){
                int nx1 = cur.coinx1 + dx[i];
                int ny1 = cur.coiny1 + dy[i];
                int nx2 = cur.coinx2 + dx[i];
                int ny2 = cur.coiny2 + dy[i];

                //벽 여부를 검증
                if(wall[nx1][ny1]==true && wall[nx2][ny2]==true) continue;
                else if(wall[nx1][ny1]==true){
                    nx1 = cur.coinx1;
                    ny1 = cur.coiny1;
                }else if(wall[nx2][ny2]==true){
                    nx2 = cur.coinx2;
                    ny2 = cur.coiny2;
                }

                //몇 개가 땅에 떨어지는지를 확인
                if((nx1==0 || ny1==0 || nx1>N || ny1>M) && (nx2==0 || ny2==0 || nx2>N || ny2>M)) continue;
                else if((nx1==0 || ny1==0 || nx1>N || ny1>M) || (nx2==0 || ny2==0 || nx2>N || ny2>M)) {
                    isFind = true;
                    System.out.println(cur.count+1);
                    break;
                }else{
                    if(cur.count<9 && !isVisited[nx1][ny1][nx2][ny2])
                        q.offer(new Coin(nx1, ny1, nx2, ny2, cur.count+1));
                }
            }
            if(isFind) break;
        }
        if(!isFind) System.out.println(-1);
    }

    static class Coin{
        int coinx1;
        int coiny1;
        int coinx2;
        int coiny2;
        int count;
        public Coin(int coinx1, int coiny1, int coinx2, int coiny2, int count){
            this.coinx1 = coinx1;
            this.coiny1 = coiny1;
            this.coinx2 = coinx2;
            this.coiny2 = coiny2;
            this.count = count;
        }
    }
}
