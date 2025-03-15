import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        int cnt = 0;
        for(char c : number.toCharArray()){
            while(cnt<k && !stack.isEmpty() && stack.peek() < c){
                stack.pop();
                cnt++;
            }
            stack.push(c);
        }
        
        while(cnt < k && !stack.isEmpty()){
            stack.pop();
            cnt++;
        }
        
        LinkedList<Character> list = new LinkedList<>();
        while(!stack.isEmpty()) list.addFirst(stack.pop());
        
        StringBuffer sb = new StringBuffer();
        for(Character c : list) sb.append(c);
        
        
        return sb.toString();
    }
}