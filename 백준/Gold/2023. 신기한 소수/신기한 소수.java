import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        PriorityQueue<String> answer = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node("2",1));
        q.add(new Node("3",1));
        q.add(new Node("5",1));
        q.add(new Node("7",1));

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.number.length()==N){
                answer.offer(node.number);
                continue;
            }

            for(int i=0; i<=9; i++){
                String tmp = node.number + String.valueOf(i);
                if(isPrime(tmp)) q.add(new Node(tmp,node.count+1));
            }
        }

        while(!answer.isEmpty()){
            System.out.println(answer.poll());
        }
    }
    static boolean isPrime(String n){
        int prime = Integer.parseInt(n);
        for(int i=2; i<prime; i++){
            if(prime%i==0) return false;
        }
        return true;
    }
    static class Node{
        String number; //어떤 숫자인고..
        int count; //몇 자리 수인고?
        public Node(String number, int count){
            this.number = number;
            this.count = count;
        }
    }

}
