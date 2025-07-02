import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        left.offer(Integer.parseInt(br.readLine()));
        System.out.println(left.peek());
        for(int i=1; i<N; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur<=left.peek()) left.offer(cur);
            else right.offer(cur);

            if(left.size()>right.size()+1) right.offer(left.poll());
            else if(left.size()<right.size()) left.offer(right.poll());

            System.out.println(left.peek());
        }
    }
}