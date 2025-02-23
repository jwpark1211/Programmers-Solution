import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        int idx = 0;
        for(int i=0; i<words.length-1; i++){
            char fir = words[i].charAt(words[i].length()-1);
            char sec = words[i+1].charAt(0);
            
            if(list.contains(words[i+1])){
                idx = i+2;
                break;
            }else{
                list.add(words[i+1]);
            }
            
            if(fir!=sec){
                idx = i+2;
                break;
            }
        }

        if(idx == 0){
            answer[0] = 0; 
            answer[1] = 0; 
        }else{ 
            answer[1] = (idx-1)/n+1; 
            answer[0] = idx-(answer[1]-1)*n; 
        }
        
        return answer;
    }
}