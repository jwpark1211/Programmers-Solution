import java.util.*;

public class Main {
    //고민 1... BFS + Brute-force ? 일단 N과 M 크기가 크지 않고, 시간 제한이 2초임
    //고민 2... 좌표 3개를 어떻게 고르지
    static int answer = 0;
    public static void main(String[] args) {
        //초기화
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] board = new int[N][M];

        for(int i=0; i<N; i++){
            scanner.nextLine();
            for(int j=0; j<M; j++){
                board[i][j] = scanner.nextInt();
            }
        }

        List<int[]> b0List = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==0) b0List.add(new int[]{i,j});
            }
        }

        int[][] tempBoard = new int[N][M];
        for(int i = 0; i < N; i++) {
            tempBoard[i] = board[i].clone();
        }

        wall(0, 0, b0List, tempBoard, N, M);
        System.out.println(answer);
    }

    static void wall(int cnt, int idx, List<int[]> b0List, int[][] board, int N, int M){
        if(cnt == 3){
            int cntSafe = safePlace(board, N, M);
            answer = Math.max(answer,cntSafe);
            return;
        }
        for(int i=idx; i<b0List.size(); i++){
            board[b0List.get(i)[0]][b0List.get(i)[1]] = 1;
            wall(cnt+1, i+1, b0List, board, N, M);
            board[b0List.get(i)[0]][b0List.get(i)[1]] = 0;
        }
    }

    static int safePlace(int board[][], int N, int M){
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};

        int[][] tempBoard = new int[N][M];
        for(int i = 0; i < N; i++) {
            tempBoard[i] = board[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];

        //바이러스 풀기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tempBoard[i][j]==2 && !visited[i][j]){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] xy = q.poll();
                        for(int k=0; k<4; k++){
                            int nx = xy[0] + dx[k];
                            int ny = xy[1] + dy[k];
                            if(nx>=0 && nx<N && ny>=0 && ny<M && tempBoard[nx][ny]==0 && !visited[nx][ny]){
                                tempBoard[nx][ny] = 2;
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        //safe한 영역 개수 찾기
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tempBoard[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}