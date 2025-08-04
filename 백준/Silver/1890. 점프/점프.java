import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[][];
    static long dp[][];

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                int jump = arr[x][y];
                if(jump==0) continue;
                //우측
                if(y+jump<N){
                    //if(x==N-1 && y+jump == N-1) System.out.println("x="+x+",y="+y);
                    dp[x][y+jump]+=dp[x][y];
                }
                //하측
                if(x+jump<N){
                    //if(x+jump==N-1 && y == N-1) System.out.println("x="+x+",y="+y);
                    dp[x+jump][y]+=dp[x][y];
                }
            }
        }

        //for(int i=0; i<N; i++) System.out.println(Arrays.toString(dp[i]));
        System.out.println(dp[N-1][N-1]);
    }
}
