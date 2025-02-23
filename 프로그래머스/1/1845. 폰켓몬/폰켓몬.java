import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        //가질 수 있는 최대 폰켓몬 개수는 nums / 2 
        int nd2 = nums.length / 2;
        
        //Set 써도 될 것 같긴 한데, 해시맵 문제라 HashMap 사용
        //HashMap을 폰켓몬 종류 개수 저장하는 용도로 씀 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0));
        }
        
        //만약 폰켓몬 종류의 개수가 nums/2보다 큰 경우엔 최댓값(nums/2) Return 
        //그렇지 않은 경우 폰켓몬 종류의 개수 그대로 Return 
        if(map.size()>nd2) answer = nd2;
        else answer = map.size();
        
        return answer;
    }
}