import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int low = 0; int high = distance;
        while(low<=high){
            int mid = (low+high)/2;
            int deleteCnt = 0;
            int prev = 0;
            
            for(int rock : rocks){
                if(rock - prev < mid){
                    deleteCnt ++;
                }else{
                    prev = rock;
                }
            }
            
            if (distance - prev < mid) {
                deleteCnt++;
            }
            
            if(deleteCnt>n){
                high = mid - 1;
            }else{
                low = mid + 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}