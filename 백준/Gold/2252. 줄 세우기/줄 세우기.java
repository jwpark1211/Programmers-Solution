import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M; //사람수, 간선수
    static List<ArrayList<Integer>> list = new ArrayList<>(); //그래프
    static int[] in; //진입차수
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        in = new int[N+1]; in[0] = -1;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            in[y]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) if(in[i]==0) q.add(i);
        while(!q.isEmpty()){
            int x = q.poll();
            ans.add(x);
            List<Integer> tmp = list.get(x);
            for(int i=0; i<tmp.size();i++){
                in[tmp.get(i)]--;
                if(in[tmp.get(i)]==0) q.add(tmp.get(i));
            }
        }
        for(int i : ans) System.out.print(i + " ");
    }
}
