import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static int N;

    public static class Meet{
        int start;
        int end;
        public Meet(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Meet> pq = new PriorityQueue<>((a,b)->
        {
            if(a.end == b.end) return Integer.compare(a.start, b.start);
            else return Integer.compare(a.end, b.end);
        });
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int ans = 1;
        int e = pq.poll().end;
        while(!pq.isEmpty()){
            Meet m = pq.poll();
            if(m.start >= e) {
                ans ++;
                e = m.end;
            }
        }

        System.out.println(ans);
    }
}