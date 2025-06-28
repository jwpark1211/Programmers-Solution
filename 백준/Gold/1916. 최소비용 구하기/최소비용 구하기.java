import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M; //N=도시의 개수, M=버스의 개수
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int start, end;
    static class Node{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e,v));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int dist[] = new int[N+1];
        for(int i=1; i<=N; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        //PQ 순회 (다익스트라)
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.cost,b.cost));
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.idx == end) break;
            for(Node node : graph.get(cur.idx)){
                int costSum = cur.cost + node.cost;
                if(dist[node.idx] > costSum){
                    dist[node.idx] = costSum;
                    pq.offer(new Node(node.idx,costSum));
                }
            }
        }
        System.out.println(dist[end]);
    }

}