import java.io.*;
import java.util.*;

public class Main {
    static int T; //테스트 케이스의 수
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            int K, M, P; //K=테스트 케이스 번호, M=노드의 수, P=간선의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            int fIn[] = new int[M+1];
            int priority[] = new int[M+1];
            List<List<Integer>> graph = new ArrayList<>();
            for(int j=0; j<=M; j++) graph.add(new ArrayList<>());

            for(int j=0; j<P; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                fIn[end]++;
                graph.get(start).add(end);
            }

            Queue<Integer> q = new LinkedList<>();
            for(int j=1; j<=M; j++){
                if(fIn[j]==0) {
                    priority[j] = 1;
                    q.add(j);
                }
            }

            List<List<Integer>> pList = new ArrayList<>();
            for(int j=0; j<=M; j++) pList.add(new ArrayList<>());

            while(!q.isEmpty()){
                int cur = q.poll();
                List<Integer> list = graph.get(cur);
                for(int k : list){
                    fIn[k]--;
                    pList.get(k).add(priority[cur]);
                    if(fIn[k]==0){
                        Collections.sort(pList.get(k),Collections.reverseOrder());
                        if(pList.get(k).size()==1) priority[k]=pList.get(k).get(0);
                        if(pList.get(k).size()>1){
                            if(pList.get(k).get(0)==pList.get(k).get(1)) priority[k]=pList.get(k).get(0)+1;
                            else priority[k]=pList.get(k).get(0);
                        }
                        q.add(k);
                    }
                }
            }
            System.out.println(K+" "+priority[M]);
        }
    }
}
