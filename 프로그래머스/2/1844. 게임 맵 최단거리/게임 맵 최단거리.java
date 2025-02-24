import java.util.*;

//너비 우선 탐색(BFS) 
class Solution {
    int dx[] = {1,-1,0,0}; 
    int dy[] = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int answer = 1;
        int n = maps.length; 
        int m = maps[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        
        //큐에 벽이 없는 곳 동서남북으로 찾아다니며 넣고 최단거리 계산 반복 
        while(!q.isEmpty()){
            int len = q.size();
            for(int j=0; j<len; j++){
                Pair pair = q.poll();
                //목적지 도착하면 값 리턴 
                if(pair.x==n-1 && pair.y==m-1) return answer;
                for(int i=0; i<4; i++){
                    int nx = pair.x + dx[i];
                    int ny = pair.y + dy[i];
                    if(nx>=0 && ny>=0 && nx<n && ny<m){
                        if(maps[nx][ny]==1){
                            maps[nx][ny] = 0;
                            q.offer(new Pair(nx,ny));
                        }
                    }
                }
            }
            answer++;
        }
       return -1;
    }
    
    public static class Pair{
        int x; int y; 
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}