import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int h=0; h<citations[citations.length-1]; h++){
            int cnt = 0;
            for(int i=0; i<citations.length; i++){
                if(citations[i]>=h) cnt++;
            }
            if(cnt>=h && citations.length-cnt<=h){
                answer = h;
            }
        }
        
        return answer;
    }
}