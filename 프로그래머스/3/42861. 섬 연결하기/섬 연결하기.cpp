#include <string>
#include <vector>
#include <queue>
 
//최소 신장 트리 : 크루스칼 

using namespace std;

vector<int> parent;
struct Node { 
    int start;
    int end;
    int cost;
    bool operator<(const Node& other) const{
        return cost>other.cost;
    }
};

int getParent(int x){
    if(x==parent[x]) return x;
    return parent[x] = getParent(parent[x]);
}
void unionParent(int a, int b){
    a = getParent(a);
    b = getParent(b);
    if(a>b) parent[a] = b;
    else parent[b] = a;
}
bool findParent(int a, int b){
    return getParent(a)==getParent(b);
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    priority_queue<Node> pq;
    
    for(int i=0; i<n; i++) parent.push_back(i);
    for(vector<int> cost : costs) pq.push({cost[0],cost[1],cost[2]});
    
    while(!pq.empty()){
        Node cur = pq.top();
        pq.pop();
        
        if(!findParent(cur.start, cur.end)){
            answer += cur.cost;
            unionParent(cur.start, cur.end);
        }
    }
    
    return answer;
}