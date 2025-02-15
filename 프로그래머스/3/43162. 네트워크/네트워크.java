class Solution {
    int [] visited = new int[201];

    public void dfs(int a, int n, int[][] computers){
        for(int i=0; i<n; i++){
            if(a!=i && computers[a][i]==1){
                if(visited[i]==0){
                    visited[i]=1;
                    dfs(i,n,computers);
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0; i<n; i++) visited[i] = 0;
        for(int i=0; i<n; i++) {
            if(visited[i]==0){
                answer++; dfs(i, n,computers);
            }
        }
        return answer;
    }
}