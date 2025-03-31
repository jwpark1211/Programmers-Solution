import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //사람들 몸무게 오름차순 정렬 
        Arrays.sort(people);
        int left = 0; int right = people.length - 1;
       
        while(left<=right){
            if(people[right]+people[left]<=limit){
                answer ++;
                left ++; right --;
            }else{
                answer++;
                right --;
            }
        }
        
        return answer;
    }
}