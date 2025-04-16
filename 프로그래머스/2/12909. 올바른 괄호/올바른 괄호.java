import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')
                stack.push('(');
            else{
                if(!stack.isEmpty() && stack.peek()=='(')
                    stack.pop();
                else if(!stack.isEmpty() && stack.peek()==')')
                    return false;
                else if(stack.isEmpty()) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}