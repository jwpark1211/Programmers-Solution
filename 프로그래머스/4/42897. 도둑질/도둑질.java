import java.util.*;
//1차 시도 : 1번 테케만 통과 못 함 -> 반례 : [10,2,2,100,2] => 기댓값 110 결과값 102
class Solution {
    public int solution(int[] money) {
        int dp1[] = new int[money.length + 1]; //1번째 집 포함 
        int dp2[] = new int[money.length + 1]; //마지막 집 포함
        
        for(int i=1; i<money.length; i++){
            dp1[i] = money[i];
            dp2[i] = money[i-1];
        }
        
        for(int i=2; i<money.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i]+dp1[i-2]);
            dp2[i] = Math.max(dp2[i-1], dp2[i]+dp2[i-2]);
        }
        
        return Math.max(dp1[money.length-1], dp2[money.length-1]);
    }
}