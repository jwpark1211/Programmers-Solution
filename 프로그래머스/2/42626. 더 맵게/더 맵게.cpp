#include <string>
#include <vector>
#include <queue>
#include <functional>
#include <iostream>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<long long, vector<long long>,greater<long long>> pq;
    for(int i=0; i<scoville.size(); i++) pq.push(scoville[i]);
    
    while(true){
        //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우 
        if(pq.size()==1 && pq.top()<K){
            answer = -1;
            break;
        }
        //가장 앞에 있는 수가 K가 넘으면 return 
        if(pq.top()>=K) break;
        
        //default
        long long tmp = pq.top();
        pq.pop();
        tmp+= pq.top()*2;
        pq.pop();
        pq.push(tmp);
        answer++;
    }
    
    return answer;
}