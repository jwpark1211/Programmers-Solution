import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        long answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(arr);

        int low = 0;
        int high = arr[N-1];
        while(low<=high){
            int mid = (low+high)/2;
            //System.out.println("mid = " + mid);

            long sum = 0;
            for(int i=N-1; i>=0; i--){
                //System.out.println("mid = " + mid);
               if(arr[i]<=mid) break;
               sum += arr[i] - mid;
            }
            //System.out.println("sum = " + sum);

            if(sum<M){
                high = mid - 1;
            }else {
                answer = mid;
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
