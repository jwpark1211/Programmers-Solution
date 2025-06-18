import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, K;
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=N; i++){
            if(N%i==0){
                K--;
            }
            if(K==0){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}