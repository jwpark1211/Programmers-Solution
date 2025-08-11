import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{arr[0],arr[1],arr[2],0});
        boolean visited[][][] = new boolean[61][61][61];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0]; int x2 = cur[1]; int x3 = cur[2];
            int count = cur[3];
            if(x1<=0 && x2<=0 && x3<=0){
                System.out.println(count);
                break;
            }

            int n1 = (x1-9<0)?0:x1-9;
            int n2 = (x2-3<0)?0:x2-3;
            int n3 = (x3-1<0)?0:x3-1;
            if(!visited[n1][n2][n3]){
                visited[n1][n2][n3] = true;
                q.add(new int[]{n1,n2,n3,count+1});
            }

            n1 = (x1-9<0)?0:x1-9;
            n2 = (x2-1<0)?0:x2-1;
            n3 = (x3-3<0)?0:x3-3;
            if(!visited[n1][n2][n3]){
                visited[n1][n2][n3] = true;
                q.add(new int[]{n1,n2,n3,count+1});
            }

            n1 = (x1-3<0)?0:x1-3;
            n2 = (x2-9<0)?0:x2-9;
            n3 = (x3-1<0)?0:x3-1;
            if(!visited[n1][n2][n3]){
                visited[n1][n2][n3] = true;
                q.add(new int[]{n1,n2,n3,count+1});
            }

            n1 = (x1-3<0)?0:x1-3;
            n2 = (x2-1<0)?0:x2-1;
            n3 = (x3-9<0)?0:x3-9;
            if(!visited[n1][n2][n3]){
                visited[n1][n2][n3] = true;
                q.add(new int[]{n1,n2,n3,count+1});
            }

            n1 = (x1-1<0)?0:x1-1;
            n2 = (x2-3<0)?0:x2-3;
            n3 = (x3-9<0)?0:x3-9;
            if(!visited[n1][n2][n3]){
                visited[n1][n2][n3] = true;
                q.add(new int[]{n1,n2,n3,count+1});
            }

            n1 = (x1-1<0)?0:x1-1;
            n2 = (x2-9<0)?0:x2-9;
            n3 = (x3-3<0)?0:x3-3;
            if(!visited[n1][n2][n3]){
                visited[n1][n2][n3] = true;
                q.add(new int[]{n1,n2,n3,count+1});
            }
        }
    }
}
