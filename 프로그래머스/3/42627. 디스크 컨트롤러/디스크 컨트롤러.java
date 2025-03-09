import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));
        
        for (int[] job : jobs) {
            pQ.offer(new int[]{job[0], job[1]});
        }

        int time = 0;
        List<int[]> execJob = new ArrayList<>();
        while (!pQ.isEmpty() || !execJob.isEmpty()) {
            
            while(!pQ.isEmpty() && pQ.peek()[0]<=time){
                execJob.add(pQ.poll());
            }
            
            if(!execJob.isEmpty()){
                Collections.sort(execJob, Comparator.comparingInt(a->a[1]));
                int[] job = execJob.remove(0);
                if(time < job[0]) time = job[0];
                time += job[1];
                answer += (time - job[0]); 
            }else if(!pQ.isEmpty()){
                time = pQ.peek()[0];
            }
        }
        
        return answer/jobs.length;
    }
}
