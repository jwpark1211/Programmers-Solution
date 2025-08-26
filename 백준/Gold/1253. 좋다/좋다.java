import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] num;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new long[N];
        for(int i=0; i<N; i++) num[i] = Long.parseLong(st.nextToken());
        Arrays.sort(num);

        for(int i=0; i<N; i++){
            int left = 0;
            int right = N-1;
            while(left<right){
                long val = num[left]+num[right];
                if(left!=i && right!=i && val==num[i]){
                    ans++;
                    break;
                }
                if(left==i) left++;
                else if(right==i) right--;
                else if(val<num[i]) left++;
                else right--;
            }
        }
        System.out.println(ans);
    }
}
