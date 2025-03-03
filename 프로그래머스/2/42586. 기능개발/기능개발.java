import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();
        
        //각 작업 당 며칠이 걸리는지 계산 후 큐 초기화 (큐 = days)
        for(int i=0; i<progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) day++;
            days.offer(day);
        }
        
        while(!days.isEmpty()){
            int cnt = 1;
            int fir = days.poll(); 
            //앞에 있는 작업이 완료되었을 때, 그 후에 몇 개의 작업이 같이 배포되는지 계산
            while(!days.isEmpty()){
                if(days.peek()<=fir){
                    cnt++; days.poll();
                }else break;
            }
            answers.add(cnt);
        }
        
        int[] answer = new int[answers.size()];
        for(int i=0; i<answers.size(); i++) 
            answer[i] = answers.get(i);
        
        return answer;
    }
}