class Solution {
    int answer = -1;
    int visited[] = new int[8];
    public void dfs(int k, int cnt, int[][] dungeons){
        answer = Math.max(cnt, answer);
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]==0 && k>=dungeons[i][0]){
                visited[i] = 1;
                dfs(k-dungeons[i][1], cnt+1, dungeons);
                visited[i] = 0;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        dfs(k, 0, dungeons);
        return answer;
    }
}