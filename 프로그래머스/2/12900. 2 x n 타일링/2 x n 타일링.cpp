#include <string>
#include <vector>

using namespace std;
int mod = 1000000007;

int solution(int n) {
    vector<int> dp(n+1);
    dp[1]=1; dp[2]=2; dp[3]=3;
    for(int i=4; i<=n; i++){ 
        dp[i]=(dp[i]+dp[i-2])%mod; //2를 더해 만들 수 있는 숫자 
        dp[i]=(dp[i]+dp[i-1])%mod; //1을 더해 만들 수 있는 숫자 
    }
    return dp[n];
}