#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Node{
    int idx;
    int cost;
    bool operator<(const Node& other) const{
        return cost>other.cost;
    }
};
int solution(int N, vector<vector<int>> road, int K) {
    int answer = 0;
    vector<vector<Node>> graph(N+1);
    for(vector<int> r : road){
        graph[r[0]].push_back({r[1],r[2]});
        graph[r[1]].push_back({r[0],r[2]});
    }
    
    vector<int> dist (N+1, 123456789);
    dist[1] = 0;
    
    priority_queue<Node> pq;
    pq.push({1, 0}); //시작점 
    
    while(!pq.empty()){
        Node cur = pq.top();
        pq.pop();
        
        if(dist[cur.idx]<cur.cost) continue;
        
        for(Node nxt : graph[cur.idx]){
            if(dist[nxt.idx]>nxt.cost+dist[cur.idx]){
                dist[nxt.idx]=nxt.cost+dist[cur.idx];
                pq.push({nxt.idx, dist[nxt.idx]});
            }
        }
    }
    
    for(int i=1; i<=N; i++) if(dist[i]<=K) answer++;
    
    return answer;
}