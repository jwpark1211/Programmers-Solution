import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Pair> queue = new LinkedList<>();
        int[] visited = new int[1000001];
        queue.offer(new Pair(x,0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int value = pair.value;
            int depth = pair.depth;
            
            if(value == y){
                answer = depth;
                break;
            }
            
            if(value*3<=y && visited[value*3]==0) {
                visited[value*3] = 1;
                queue.offer(new Pair(value*3,depth+1));
            }
            if(value*2<=y && visited[value*2]==0){
                visited[value*2] = 1;
                queue.offer(new Pair(value*2,depth+1));
            }
            if(value+n<=y && visited[value+n]==0){
                visited[value+n] = 1;
                queue.offer(new Pair(value+n,depth+1));
            }
        }
        
        return answer;
    }
    
    static class Pair{
        int value;
        int depth;
        Pair(int value, int depth){
            this.value = value;
            this.depth = depth;
        }
    }
}

