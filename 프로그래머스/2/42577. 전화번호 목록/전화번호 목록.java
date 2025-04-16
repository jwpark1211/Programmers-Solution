import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            boolean flag = true;
            for(int j=0; j<phone_book[i].length(); j++){
                if(phone_book[i].charAt(j)!=phone_book[i+1].charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) return false;
        }
        
        return answer;
    }
}