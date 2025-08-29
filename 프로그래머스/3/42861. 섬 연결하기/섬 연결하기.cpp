#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> parent;

struct Node{
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
    if(a>b) parent[a]=b;
    else parent[b]=a;
}
bool findParent(int a, int b){
    return getParent(a)==getParent(b);
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    
    priority_queue<Node> pq;
    for(int i=0; i<costs.size(); i++){
        pq.push({costs[i][0],costs[i][1],costs[i][2]});
    }
    for(int i=0; i<n; i++) parent.push_back(i);
    
    while(!pq.empty()){
        Node node = pq.top();
        pq.pop();
        
        if(!findParent(node.start, node.end)){
            unionParent(node.start, node.end);
            answer += node.cost;
        }
    }
    
    return answer;
}