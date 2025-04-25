import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        //입력 받는 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> qq = new LinkedList<>();
        Queue<Integer> uq = new LinkedList<>();
        Queue<Integer> aq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        Queue<Integer> kq = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            switch (str.charAt(i)){
                case 'q' : qq.offer(i); break;
                case 'u' : uq.offer(i); break;
                case 'a' : aq.offer(i); break;
                case 'c' : cq.offer(i); break;
                case 'k' : kq.offer(i); break;
            }
        }

        boolean flag = true;
        while(!qq.isEmpty()){
            int bef = qq.poll();
            if(!pq.isEmpty()) if(bef>pq.peek()) pq.poll();
            if(!uq.isEmpty() && uq.peek()>bef){
                bef = uq.poll();
            } else {
                flag = false;
                break;
            }
            if(!aq.isEmpty() && aq.peek()>bef){
                bef = aq.poll();
            }else{
                flag = false;
                break;
            }
            if(!cq.isEmpty() && cq.peek()>bef){
                bef = cq.poll();
            }else{
                flag = false;
                break;
            }
            if(!kq.isEmpty() && kq.peek()>bef){
                bef = kq.poll();
            }else{
                flag = false;
                break;
            }
            pq.offer(bef);
        }

        if(!uq.isEmpty() || !aq.isEmpty() || !cq.isEmpty() || !kq.isEmpty()) flag = false;

        if(flag) System.out.println(pq.size());
        else System.out.println(-1);
    }
}
