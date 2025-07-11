import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //edge
    static class Edge{
        int n1;
        int n2;
        int value;
        public Edge(int n1, int n2, int value){
            this.n1 = n1;
            this.n2 = n2;
            this.value = value;
        }
    }
    static int V,E; //V = 정점의 개수, E= 간선의 개수
    static int[] parent ;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Queue<Edge> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1.value, o2.value));
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            q.offer(new Edge(n1,n2,val));
        }

        //union-find를 위한 parent 테이블 초기화
        parent = new int[V+1];
        for(int i=1; i<=V; i++) parent[i] = i;

        int cnt = 0;
        while(cnt<V && !q.isEmpty()){
            Edge cur = q.poll();
            if(findParent(cur.n1,cur.n2)) continue;
            unionParent(cur.n1, cur.n2);
            cnt ++;
            ans += cur.value;
        }

        System.out.println(ans);
    }
    //부모를 찾음
    static int getParent(int x){
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent[x]);
    }
    //두 노드의 부모를 합침
    static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    //같은 부모를 가지는지 확인
    static boolean findParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        return a==b;
    }
}
