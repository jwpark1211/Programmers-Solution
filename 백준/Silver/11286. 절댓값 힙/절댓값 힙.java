import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>(); //양수 Q
        PriorityQueue<Integer> mQ = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if( x == 0){ //입력값이 0인 경우
                if(pQ.isEmpty() && mQ.isEmpty()) System.out.println("0");
                else if(mQ.isEmpty()) System.out.println(pQ.poll());
                else if(pQ.isEmpty()) System.out.println(mQ.poll());
                else {
                    if(Math.abs(mQ.peek())==pQ.peek() || Math.abs(mQ.peek())<pQ.peek()) System.out.println(mQ.poll());
                    else System.out.println(pQ.poll());
                }
            }else if(x > 0){ //입력값이 양수인 경우
                pQ.offer(x);
            }else { //입력값이 음수인 경우
                mQ.offer(x);
            }
        }

    }
}
