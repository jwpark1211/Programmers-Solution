import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V,E; //V=정점의 개수, E=간선의 개수
    static int[] parent;
    static int distance = 0;
    static class Edge{
        int e1;
        int e2;
        int cost;
        public Edge(int e1, int e2, int cost){
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(e1,e2,cost));
        }

        for(int i=1; i<=V; i++) parent[i] = i;


        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(!findParent(cur.e1,cur.e2)){
                distance += cur.cost;
                unionParent(cur.e1, cur.e2);
            }
        }

        System.out.println(distance);

    }
    public static int getParent(int x){
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static boolean findParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        return a==b;
    }

}
