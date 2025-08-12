import java.io.*;
import java.util.*;

public class Main {
    static int T; //테스트 케이스의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            //입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int time[] = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) time[j] = Integer.parseInt(st.nextToken());
            List<List<Integer>> graph = new ArrayList<>();
            for(int j=0; j<=N; j++) graph.add(new ArrayList<>());

            int[] fIn = new int[N+1];
            for(int j=1; j<=K; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                fIn[end]++;
            }
            int destination = Integer.parseInt(br.readLine());

            int totalTime[] = new int[N+1];
            Queue<Integer> q = new LinkedList<>();
            for(int j=1; j<=N; j++) {
                if(fIn[j]==0) {
                    q.add(j);
                    totalTime[j]=time[j];
                }
            }

            while(!q.isEmpty()){
                int cur = q.poll();
                for(int k : graph.get(cur)){
                    fIn[k]--;
                    totalTime[k] = Math.max(totalTime[k],time[k]+totalTime[cur]);
                    if(fIn[k]==0){
                        q.add(k);
                    }
                }
            }
            System.out.println(totalTime[destination]);
        }
    }
}
