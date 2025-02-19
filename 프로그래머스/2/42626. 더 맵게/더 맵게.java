import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        //초기화
        for(int i=0; i<scoville.length; i++) q.offer(scoville[i]);
        
        while(!q.isEmpty()){
            int fir = q.poll();
            if(q.isEmpty() && fir < K) return -1;
            if(fir>=K) break;
            answer ++;
            int sec = q.poll();
            q.offer(fir+sec*2);
        }
        
        return answer;
    }
}