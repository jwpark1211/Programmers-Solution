#include <string>
#include <vector>
#include <queue>

using namespace std;

struct Node{
    int idx;
    int sum;
};

int solution(vector<int> numbers, int target) {
    int answer = 0;
    queue<Node> q;
    
    q.push({0,0});
    while(!q.empty()){
        //큐에서 가장 앞에 애를 꺼냄 
        Node cur = q.front();
        q.pop();
        
        if(cur.idx==numbers.size()){
            if(cur.sum==target) answer++;
            continue;
        }
        
        q.push({cur.idx+1, cur.sum+numbers[cur.idx]});
        q.push({cur.idx+1, cur.sum-numbers[cur.idx]});
    }
    
    return answer;
}