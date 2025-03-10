class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow; //총 격자 수 
        
        for(int i=1; i<=sum/2; i++){
            if(sum%i==0){
                int max = Math.max(i, sum/i);
                int min = Math.min(i, sum/i);
                if(brown == max*2+(min-2)*2){
                    answer[0] = max;
                    answer[1] = min;
                    break;
                }
            }
        }
        
        return answer;
    }
}