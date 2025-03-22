import java.util.*;

class Solution {
    //재귀를 통해 
    public int dfs(int[][] graph,int[] visited, int network){
        visited[network] = 1; 
        int count = 1;
        for(int i=1; i<visited.length; i++){
            if(graph[network][i]==1 && visited[i]==0){
                count += dfs(graph, visited, i);
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        int visited[] = new int[n+1];
        int graph[][] = new int[n+1][n+1];
        
        //전력망을 2중 배열 그래프로 전환
        for(int i=0; i<wires.length; i++){
            int[] wire = wires[i];
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        //for문을 돌면서 전선을 하나씩 끊고 계산해봄 (완탐)
        for(int i=0; i<wires.length; i++){
            int[] wire = wires[i];
            for(int j=0; j<visited.length; j++) visited[j] = 0;
            //전선을 끊고
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;
            //양 쪽의 개수를 세고 Math.abs(cnt1-cnt2)를 갱신
            int cnt1 = dfs(graph, visited, wire[0]);
            int cnt2 = dfs(graph, visited, wire[1]);
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));  
            //다시 전선을 이어붙임 
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        return answer;
    }
}