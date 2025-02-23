import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        //Stack에 '('은 저장, ')'은 '('가 있는 경우 pop
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') 
                stack.push(s.charAt(i));
            else{
                //')'는 있는데 스택이 비어있으면 올바른 괄호 X
                if(stack.empty()) return false;
                else stack.pop();
            }
        }
        
        //Stack이 비어있으면 올바른 괄호 X 
        if(!stack.empty()) return false;

        return answer;
    }
}