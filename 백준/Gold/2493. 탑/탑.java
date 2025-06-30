import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] tops;
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tops = new int[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) tops[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && tops[stack.peek()]<tops[i]){ stack.pop(); }
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            else {
                answer[i] = stack.peek()+1;
                stack.push(i);
            }
        }

        for(int i=0; i<N; i++) System.out.print(answer[i]+" ");

    }
}