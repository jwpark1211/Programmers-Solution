#include <string>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int solution(vector<int> scoville, int K) {
    int ans = 0; //섞은 횟수 
    
    priority_queue<long long, vector<long long>, greater<long long>> pq;
    for(int s : scoville) pq.push(s);
    
    while(pq.size()!=1){
        if(pq.top()>=K) break; //가장 작은 게 K보다 크면 반복문 out
        long long front = pq.top(); pq.pop();
        long long second = pq.top(); pq.pop();
        pq.push(front + second*2);
        ans++;
    }
    
    if(pq.size()==1 && pq.top()<K) return -1;
    return ans;
}