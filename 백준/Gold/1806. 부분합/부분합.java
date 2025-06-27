import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int S;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int left = 0; int right = 0;
        long sum = arr[left];
        while(left<=right){
            if(sum<S && right == N-1) break;
            if(sum>=S) {
                ans = Math.min(ans, right-left+1);
                sum -= arr[left++];
            }
            else {
                if (right < N - 1) sum += arr[++right];
            }
        }

        if(ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}