import java.util.*;

class Solution {
    public int solution(String[] arr) {
        int[] num = new int[arr.length / 2 + 1]; //숫자만 따로 저장하는 배열
        int[] op = new int[arr.length / 2];      //연산자(+는 0, -는 1)만 따로 저장하는 배열 
        int idx1 = 0;
        int idx2 = 0;

        // 문자열 배열에서 숫자와 연산자를 분리
        for (String str : arr) {
            if (str.equals("+")) 
                op[idx2++] = 0;
            else if (str.equals("-"))
                op[idx2++] = 1; 
            else 
                num[idx1++] = Integer.parseInt(str);
        }

        //dp[a][b][0] = a~b까지의 최소값
        //dp[a][b][1] = a~b까지의 최대값
        int n = num.length;
        int[][][] dp = new int[n][n][2]; 

        //같은 숫자끼리 비교할 경우, 최소/최대 모두 자기 자신을 저장함.
        for (int i = 0; i < n; i++) 
            dp[i][i][0] = dp[i][i][1] = num[i];

        // 길이 len의 구간에 대해 DP 돌리기
        for (int len = 1; len < n; len++) {
            for (int s = 0; s < n; s++) {
                int e = s + len; 
                if (e >= n) break;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                // 구간 [s, e]를 i 기준으로 나누어 계산
                for (int i = s; i < e; i++) {
                    if (op[i] == 0) { //더하기 연산일 때
                        max = Math.max(max, dp[s][i][1] + dp[i+1][e][1]); // 최대 + 최대
                        min = Math.min(min, dp[s][i][0] + dp[i+1][e][0]); // 최소 + 최소
                    } else { //빼기 연산일 때 
                        max = Math.max(max, dp[s][i][1] - dp[i+1][e][0]); // 최대 - 최소
                        min = Math.min(min, dp[s][i][0] - dp[i+1][e][1]); // 최소 - 최대
                    }
                }

                dp[s][e][0] = min; 
                dp[s][e][1] = max; 
            }
        }

        //전체 구간에서의 최댓값 반환
        return dp[0][n - 1][1];
    }
}
