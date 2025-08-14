import java.io.*;
import java.util.*;

public class Main {
    static String parent;
    static String pattern;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parent = br.readLine();
        pattern = br.readLine();
        Stack<Character> stack = new Stack<>();
        int patternSize = pattern.length();

        for(char c : parent.toCharArray()){
            stack.push(c);

            if(stack.size()>=patternSize){
                boolean flag = true;
                for(int i=0; i<patternSize; i++){
                    if(stack.get(stack.size()-(patternSize-i))!=pattern.charAt(i)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int i=0; i<patternSize; i++) stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        for(char c : stack) sb.append(c);
        System.out.println((sb.length()==0)?"FRULA":sb.toString());
    }

}
