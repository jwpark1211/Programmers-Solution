using namespace std;
#include <iostream>
#include <stdio.h>
#include <algorithm>

int N; //입력값  
int A[1001];
int dp[1001];
int answer = 0;

int main(void) {
	//입력 받기
	cin >> N;
	for (int i = 1; i <= N; i++)
		cin >> A[i];

	//dp 값 채우기
	for (int i = 1; i <= N; i++) {
		dp[i] = 1;
		for (int j = 1; j < i; j++) {
			if (A[i] > A[j])
				dp[i] = max(dp[i], dp[j] + 1);
		}
		answer = max(answer, dp[i]);
	}	

	//정답 출력
	cout << answer;
}