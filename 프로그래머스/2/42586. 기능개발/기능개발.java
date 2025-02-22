import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) day++;
            days.offer(day);
        }
        
        while(!days.isEmpty()){
            int cnt = 1;
            int fir = days.poll(); 
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