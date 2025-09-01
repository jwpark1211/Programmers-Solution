#include <bits/stdc++.h>
using namespace std;

const int MOD = 1000000007;

int solution(int n) {
    if (n % 2 == 1) return 0;           // 홀수는 불가
    if (n == 0) return 1;               // 정의상 1
    vector<long long> dp(n + 1, 0);
    dp[0] = 1;
    dp[2] = 3;

    long long sumEven = dp[0];          // dp[0]부터 dp[i-4]까지의 짝수 인덱스 누적합
    for (int i = 4; i <= n; i += 2) {
        dp[i] = (3LL * dp[i - 2] + 2LL * sumEven) % MOD;
        sumEven = (sumEven + dp[i - 2]) % MOD;  // 다음 i에서 사용할 누적합 갱신
    }
    return (int)dp[n];
}
