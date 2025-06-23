import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int T; //테케 수
    public static int N; //사람 수
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            int arr[] = new int[N+1];
            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int min = arr[1];
            int ans = 1;
            for(int j=2; j<=N; j++){
                if(min>arr[j]){
                    ans ++;
                    min = arr[j];
                }
            }
            System.out.println(ans);
        }
    }
}