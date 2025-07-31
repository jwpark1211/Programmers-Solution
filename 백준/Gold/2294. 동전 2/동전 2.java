import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, k;
    static int answer = -1;
    static ArrayList<Integer> coins = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) coins.add(Integer.parseInt(br.readLine()));

        boolean visited[] = new boolean[k+1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0}); //count, sum
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[1] == k) {
                answer = cur[0];
                break;
            }
            for(int coin : coins){
                int tmp = cur[1]+coin;
                if(tmp<=k && !visited[tmp]){
                    visited[tmp] = true;
                    q.offer(new int[]{cur[0]+1, tmp});
                }
            }
        }

        System.out.println(answer);
    }
}
