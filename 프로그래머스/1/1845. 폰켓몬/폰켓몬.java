import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int nd2 = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
        }
        
        if(map.size()>nd2) answer = nd2;
        else answer = map.size();
        
        return answer;
    }
}