import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int up[] = new int[N]; //up dp
        int down[] = new int[N]; //down dp
        for (int i = 0; i < N; i++) {
            up[i] = 1;
            down[i] = 1;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i])
                    up[i] = Math.max(up[i],up[j]+1);
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(arr[j]<arr[i])
                    down[i] = Math.max(down[i],down[j]+1);
            }
        }
        for(int i=0; i<N; i++) ans = Math.max(ans, up[i]+down[i]-1);

        System.out.println(ans);
    }
}