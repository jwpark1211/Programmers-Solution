import java.util.*;

class Solution {
    ArrayList<String> dict = new ArrayList<>();
    String std = "AEIOU";
    
    public void dfs(int num, int cnt, String cmd) {
        if(num == cnt) {
            dict.add(cmd);
            return;
        }
        
        for(int i = 0; i < 5; i++){
            dfs(num, cnt + 1, cmd + Character.toString(std.charAt(i)));
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        
        for(int i = 1; i <= 5; i++) {
            dfs(i, 0, "");
        }
        
        Collections.sort(dict);
        
        int idx = 1;
        for(String s: dict) {
            if(s.equals(word)){
                answer = idx;
                return answer;
            }
            idx++;
        }
        
        return answer;
    }
}