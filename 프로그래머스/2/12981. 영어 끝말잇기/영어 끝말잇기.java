import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            if(list.contains(words[i])){
                answer[0] = (i)%n+1;
                answer[1] = (i)/n+1;
                break;
            }else{
                list.add(words[i]);
            }
            
            char fir = words[i-1].charAt(words[i-1].length()-1);
            char sec = words[i].charAt(0);
            if(fir!=sec){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
        }

        return answer;
    }
}