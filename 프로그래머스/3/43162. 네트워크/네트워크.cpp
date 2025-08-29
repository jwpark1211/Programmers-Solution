#include <string>
#include <queue>
#include <vector>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    vector<bool> visited(n); //컴퓨터가 0~n-1
    
    queue<int> q;
    for(int i=0; i<n; i++){
        if(!visited[i]){
            q.push(i);
            while(!q.empty()){
                int cur = q.front();
                q.pop();
                
                for(int j=0; j<n; j++){
                    if(computers[cur][j]==1 && !visited[j]){
                        visited[j]=true;
                        q.push(j);
                    }
                }
            }
            answer++;
        }
    }
    
    return answer;
}