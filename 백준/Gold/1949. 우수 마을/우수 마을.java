import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] people;
    public static int[][] dp;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        people = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            people[i+1] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dp = new int[n+1][2];
        dfs(1); //임의로 시작 루트를 1로 잡아둠 -> 굳이 1로 잡을 필요 없음 
        System.out.println(Math.max(dp[1][0],dp[1][1]));
    }
    public static void dfs(int x){
        visited[x] = true;
        dp[x][1] = people[x];
        for(Integer i : graph.get(x)){
            if(!visited[i]){
                dfs(i); //가장 하단의 리프노드부터 차례로 함을 암시
                //만약 자기 자신을 사용하지 않는다면 자식 노드들 중 (자식 노드 사용 유무는 상관 없) 
                //가장 큰 애를 위로 올려 
                dp[x][0] += Math.max(dp[i][0],dp[i][1]);
                //만약 자기 자신을 사용한다면 자식 노드들 중 자신을 사용하ㄴ지 안흔 애들 중에서 가장 큰 걸 올려 
                dp[x][1] += dp[i][0];
            }
        }
    }
}
