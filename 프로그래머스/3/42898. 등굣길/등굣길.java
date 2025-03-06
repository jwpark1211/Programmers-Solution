import java.util.*;

//t1: BFS로 풀어봤는데 효율성 터져서 안 풀림 
class Solution {
    static int div = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int[n+1][m+1];
        dp[1][1] = 1;
        
        //t2: puddle이 (n,m) 이었음... 반대로 풀어서 헤맴
        for(int[] puddle : puddles) dp[puddle[1]][puddle[0]] = -1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j] == 0){
                    if(dp[i-1][j]!=-1) dp[i][j] = (dp[i][j]+dp[i-1][j])%div;
                    if(dp[i][j-1]!=-1) dp[i][j] = (dp[i][j]+dp[i][j-1])%div;
                }
            }
        }
        
        /*for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }*/
        
        return dp[n][m];
    }
}