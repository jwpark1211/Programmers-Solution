#include <string>
#include <queue>
#include <climits>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Node{
    int idx;
    int value;
};
int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    
    vector<vector<int>> graph;
    for(int i=0; i<=n; i++) graph.push_back({});
    for(int i=0; i<edge.size(); i++){
        graph[edge[i][0]].push_back(edge[i][1]);
        graph[edge[i][1]].push_back(edge[i][0]);
    }
    
    queue<Node> q;
    q.push({1,0});
    
    vector<int> dist(n+1);
    for(int i=2; i<=n; i++) dist[i]=123456789;
    
    while(!q.empty()){
        Node cur = q.front();
        q.pop();
        
        if(cur.idx!=1 && cur.value>=dist[cur.idx]) continue;
        
        dist[cur.idx] = cur.value;
        for(int j : graph[cur.idx]){
            if(j==1) continue;
            q.push({j, cur.value+1});
        }
    }
    
    int m = *max_element(dist.begin(), dist.end());
    
    for(int i=1; i<=n; i++) if(dist[i]==m) answer++;
    
    return answer;
}