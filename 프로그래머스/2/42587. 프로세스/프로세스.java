import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
       
        //{idx, pri}를 담을 큐 
        Queue<Pair> q = new LinkedList<>(); 
        for(int i=0; i<priorities.length; i++) 
            q.offer(new Pair(i,priorities[i]));
        
        //정렬된 우선순위 값을 담을 큐 
        Queue<Integer> sortedQ = new LinkedList<>(); 
        Arrays.sort(priorities);
        for(int i=priorities.length-1; i>=0; i--)
            sortedQ.offer(priorities[i]);
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            if(pair.priority < sortedQ.peek()){
                q.offer(pair);
            }else{
                sortedQ.poll();
                answer++;
                if(pair.idx == location)
                    return answer;
            }
        }
        
        return answer;
    }
    static class Pair{
        int idx;
        int priority;
        public Pair(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
}