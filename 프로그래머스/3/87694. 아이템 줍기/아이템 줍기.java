import java.util.*;

//해결책만 얻어오고 직접 구현(Scale 2배 아이디어..)
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 123456789;
        int[][] board = new int[101][101];
        int[][] visited = new int[101][101];
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        //Scale 2배
        characterX*=2; characterY*=2; itemX*=2; itemY*=2;
        
        //board 초기화 (일단 내부까지)
        for(int[] rec : rectangle){
            int lx = rec[0]*2; int ly = rec[1]*2; //좌측 하단 x,y
            int rx = rec[2]*2; int ry = rec[3]*2; //우측 상단 x,y
            for(int i=lx; i<=rx; i++){
                for(int j=ly; j<=ry; j++)
                    board[i][j] = 1;
            }
        }
        
        //내부 제거 
        for(int[] rec : rectangle){
            int lx = rec[0]*2; int ly = rec[1]*2; //좌측 하단 x,y
            int rx = rec[2]*2; int ry = rec[3]*2; //우측 상단 x,y
            for(int i=lx+1; i<rx; i++){
                for(int j=ly+1; j<ry; j++)
                    board[i][j] = 0;
            }
        }
        
        
        //큐 순회 
        Queue<Dot> q = new LinkedList<>();
        q.offer(new Dot(characterX,characterY,0));
        visited[characterX][characterY] = 1;
        
        while(!q.isEmpty()){
            Dot dot = q.poll();
            //만약 dot의 위치가 item의 위치와 같다면 정답 갱신 
            if(dot.x==itemX && dot.y==itemY){
                return dot.dist/2;
            }else{ //다르다면 동서남북으로 이동~ 큐에 추가~
                for(int i=0; i<4; i++){
                    int nx = dot.x+dx[i];
                    int ny = dot.y+dy[i];
                    if(nx>=0 && nx<=100 && ny>=0 && ny<=100){
                        if(board[nx][ny]==1 && visited[nx][ny]==0){
                            visited[nx][ny] = 1;
                            q.offer(new Dot(nx,ny,dot.dist+1));
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    static class Dot{
        int x;
        int y;
        int dist;
        public Dot(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
}