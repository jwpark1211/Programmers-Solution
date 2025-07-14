import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        //정렬 
        Arrays.sort(times);
        long answer = (long)n * times[times.length-1]; //가능한 최댓값 
        
        long left = 0; long right = answer;
        while(left <= right){
            long mid = (left+right)/2;
            
            long cnt = 0;
            for(int t : times){
                cnt += mid/t;
            }

            if(cnt<n){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}