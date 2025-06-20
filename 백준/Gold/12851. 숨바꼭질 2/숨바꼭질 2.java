import java.io.*;
import java.util.*;


public class Main {
    public static int N, K;  // N -> K
    static class Dot{
        int loc;
        int time;
        public Dot(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int aT = Integer.MAX_VALUE;
        int aC = 0;

        Queue<Dot> queue = new LinkedList<>();
        queue.offer(new Dot(N,0));
        while(!queue.isEmpty()){
            Dot cur = queue.poll();
            if(cur.loc != K) visited[cur.loc] = true;
            else {
                if(cur.time > aT) break;
                else {
                    aT = cur.time; aC++;
                }
            }
            if(cur.loc*2<100001 && !visited[cur.loc*2]){
                queue.offer(new Dot(cur.loc*2, cur.time+1));
            }
            if(cur.loc+1<100001 && !visited[cur.loc+1]){
                queue.offer(new Dot(cur.loc+1, cur.time+1));
            }
            if( cur.loc-1>=0 && !visited[cur.loc-1]){
                queue.offer(new Dot(cur.loc-1, cur.time+1));
            }
        }
        System.out.println(aT);
        System.out.println(aC);
    }
}