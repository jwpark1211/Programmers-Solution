class Solution {
    static int answer = 60;
    int[] visited = new int[51]; 
    
    public void dfs(String before, String target, int cnt, String[] words){
        if(before.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(isConvertible(before, words[i]) && visited[i]==0){
                visited[i] = 1;
                dfs(words[i], target, cnt+1, words);
                visited[i] = 0;
            }
        }
        
    }
    
    public boolean isConvertible(String word, String target) {
        int len = word.length();
        
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(word.charAt(i)==target.charAt(i)) cnt++;
        }
        
        if(cnt == len-1) return true;
        return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, 0, words);
        
        if(answer == 60) return 0;
        return answer;
    }
}