import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1;i++){
            String prefix = phone_book[i];
            String phoneNumber = phone_book[i+1];
            
            boolean flag = true;
            for(int j=0; j<prefix.length(); j++){
                if(prefix.charAt(j)!=phoneNumber.charAt(j)){
                    flag = false; 
                    break;
                }
            }
            if(flag) return false;
        }
        
        return answer;
    }
}