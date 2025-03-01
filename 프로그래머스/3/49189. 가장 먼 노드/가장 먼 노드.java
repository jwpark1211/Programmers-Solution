import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        
        //그래프 생성(2차원 배열로 풀었으나 8,9 메모리초과 -> hashmap형태로 변경)
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edge){
            graph.putIfAbsent(e[0], new ArrayList<>()); 
            graph.putIfAbsent(e[1], new ArrayList<>());

            graph.get(e[0]).add(e[1]); 
            graph.get(e[1]).add(e[0]);
        }
        
        //큐 초기화
        for(int i : graph.get(1)){
            q.offer(i);
            visited[i] = 1;
        }
        
        //그래프 순회 
        int max = 0;
        while(!q.isEmpty()){
            int fir = q.poll();
            for(int i : graph.get(fir)){
                if(i!=1 && visited[i]==0){
                    visited[i] = visited[fir] + 1;
                    max = Math.max(max, visited[i]);
                    q.offer(i);
                }
            }
        }
        
        //가장 멀리 떨어진 노드 개수 계산 
        for(int i=1; i<=n; i++){
            if(visited[i]==max) answer++;
            //System.out.println("visited["+i+"]="+visited[i]);
        }
        
        return answer;
    }
}