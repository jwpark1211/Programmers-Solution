import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,C;
    static long [] home;
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new long[N];
        for(int i=0; i<N; i++) home[i] = Long.parseLong(br.readLine());
        Arrays.sort(home);

        long left = 0; long right = home[home.length-1];
        while(left <= right){
            long mid = (left + right)/2;

            //무조건 첫 집에 공유기가 설치되어야 하네
            int cur = 0; int cnt = 1;
            for(int idx = cur; idx < home.length; idx++){
                if(home[idx]-home[cur]<mid) continue;
                cur = idx;
                cnt++;
            }

            if(cnt >= C){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
