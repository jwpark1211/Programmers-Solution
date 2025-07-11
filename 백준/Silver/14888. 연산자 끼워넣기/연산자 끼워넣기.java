import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] op = new int[4]; // 차례로 +, - , *, %
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void dfs(int idx, int sum){
        if(idx==N-1){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        if(op[0]>0) {
            op[0]--;
            dfs(idx+1,sum + num[idx+1]);
            op[0]++;
        }
        if(op[1]>0) {
            op[1]--;
            dfs(idx+1,sum - num[idx+1]);
            op[1]++;
        }if(op[2]>0) {
            op[2]--;
            dfs(idx+1,sum * num[idx+1]);
            op[2]++;
        }if(op[3]>0 && num[idx+1]!=0) {
            op[3]--;
            if(sum<0 && num[idx+1]>0) dfs(idx+1, (Math.abs(sum) / num[idx+1])*-1);
            else dfs(idx+1,sum / num[idx+1]);
            op[3]++;
        }
    }
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());

        //dfs
        dfs(0, num[0]);

        //결과
        System.out.println(max);
        System.out.println(min);
    }
}
