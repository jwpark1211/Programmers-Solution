class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int [][] memory = new int[501][501];
        memory[0][0] = triangle[0][0];
        
        for(int i=0; i<triangle.length-1; i++){
            for(int j=0; j<=i; j++){
                int res = memory[i][j] + triangle[i+1][j];
                if(memory[i+1][j]<res) memory[i+1][j] = res;
                
                if(j!=i+1){
                    int res1 = memory[i][j] + triangle[i+1][j+1];
                    if(memory[i+1][j+1]<res) memory[i+1][j+1] = res1;
                }
            }
        }
        
        for(int i=0; i<=triangle.length; i++){
            for(int j=0; j<=i; j++){
               answer = memory[i][j] > answer ? memory[i][j] : answer ;
            }
        }
        
        return answer;
    }
}