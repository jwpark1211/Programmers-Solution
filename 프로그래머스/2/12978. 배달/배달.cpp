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
int solution(int N, vector<vector<int> > road, int K) {
    int answer = 0;
    vector<vector<Node>> graph(N+1);
    
    for(int i=0; i<road.size(); i++){
        graph.at(road[i][0]).push_back({road[i][1],road[i][2]});
        graph.at(road[i][1]).push_back({road[i][0],road[i][2]});
    }
    
    vector<int> dist(N+1, 123456789);
    dist[1]=0;
    priority_queue<Node> q;
    q.push({1,0});
    
    while(!q.empty()){
        Node cur = q.top();
        q.pop();
        
        if(dist[cur.idx]<cur.cost) continue;
        
        for(Node newNode : graph.at(cur.idx)){
            if(newNode.idx!=1 && dist[newNode.idx]>cur.cost+newNode.cost){
                dist[newNode.idx]=cur.cost+newNode.cost;
                q.push({newNode.idx, dist[newNode.idx]});
            }
        }
    }
    
    for(int i=1; i<N+1; i++){
        if(dist[i]<=K) answer++;
    }
    for(int d : dist)
        cout<<"d:"<<d<<endl;

    return answer;
}