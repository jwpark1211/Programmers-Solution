import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static int H;
    public static int W;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[W];
        for(int i=0; i<W; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<W-1; i++){
            int left = 0; int right = 0;
            for(int j=0; j<i; j++) if(left<arr[j]) left = arr[j];
            for(int j=i+1; j<W;j++) if(right<arr[j]) right = arr[j];
            if(left>arr[i] && right>arr[i]){
                int smaller = Math.min(left, right);
                ans += smaller - arr[i];
            }
        }

        System.out.println(ans);
    }
}