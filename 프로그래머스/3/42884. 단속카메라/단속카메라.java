import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // route[1] 기준으로 정렬 (오름차순)
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1],b[1]));
        
        int end = -30000;
        // 반복문 돌면서 Greedy로 개수 세기 
        for(int [] route : routes){
            if(route[0]<=end) continue;
            end = route[1];
            answer++;
        }
        
        return answer;
    }
}