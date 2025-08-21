import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int num[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void dfs(int idx, int sum, int plus, int minus, int mul, int div) {
        if(idx==N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }else{
            if(plus>0){
                dfs(idx+1, sum+num[idx],plus-1, minus, mul, div);
            }
            if(minus>0){
                dfs(idx+1, sum-num[idx], plus, minus-1, mul, div);
            }
            if(mul>0){
                dfs(idx+1, sum*num[idx], plus, minus, mul-1, div);
            }
            if(div>0){
                if(sum<0){
                    dfs(idx+1, -1*((-1*sum)/num[idx]), plus, minus, mul,div-1);
                }else {
                    dfs(idx+1, sum/num[idx], plus, minus, mul, div-1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        dfs(1,num[0],plus,minus,mul,div);
        System.out.println(max);
        System.out.println(min);
    }
}
