import java.io.*;
import java.util.*;


public class Main {
    public static int start, end; //출발 도시, 도착 도시
    public static int N; //도시의 개수
    public static int M; //버스의 개수
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static class Node{
        int idx;
        int value;
        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e,v));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        //다익스트라 초기화
        int dist[] = new int[N+1];
        for(int i=0; i<N+1; i++) dist[i] = Integer.MAX_VALUE;

        //큐 순회
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {return Integer.compare(o1.value,o2.value);});
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            List<Node> adjList = graph.get(cur.idx);

            if(cur.idx == end) break;
            if(dist[cur.idx]<cur.value) continue;

            for(Node node : adjList){
                if(dist[node.idx]>cur.value+node.value){
                    dist[node.idx] = cur.value + node.value;
                    pq.offer(new Node(node.idx, dist[node.idx]));
                }
            }
        }

        System.out.println(dist[end]);

    }
}