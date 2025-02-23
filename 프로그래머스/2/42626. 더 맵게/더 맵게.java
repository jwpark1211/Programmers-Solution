import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //가장 작은 값부터 우선적으로 반환되는 PriorityQueue 사용
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) q.offer(scoville[i]);
        
        //큐의 가장 작은 값이 K보다 커질 때까지 fir+sec*2 과정 반복 
        while(!q.isEmpty()){
            int fir = q.poll();
            //만약 큐에 값 하나만 있는데 그 값이 K보다 작은 경우 
            //절대 조건을 만족할 수 없다고 판단, -1 반환 
            if(q.isEmpty() && fir < K) return -1;
            if(fir>=K) break;
            answer ++;
            int sec = q.poll();
            q.offer(fir+sec*2);
        }
        
        return answer;
    }
}