import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int fIn[] = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            fIn[e]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(fIn[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur+" ");

            for(int i : graph.get(cur)){
                fIn[i]--;
                if(fIn[i]==0){
                    q.offer(i);
                }
            }
        }
    }
}
