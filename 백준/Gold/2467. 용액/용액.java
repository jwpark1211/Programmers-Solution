import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long water[];
    static long ans = Long.MAX_VALUE;
    static long alkali = 0;
    static long acid = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) water[i]=Long.parseLong(st.nextToken());

        int left = 0;
        int right = N-1;
        while(left<right){
            long val = water[left]+water[right];
            if(ans>Math.abs(val) ){
                ans = Math.abs(val);
                alkali = water[left];
                acid = water[right];
            }

            if(val==0) break;
            else if(val<0) left++;
            else right--;
        }
        System.out.println(alkali+" "+acid);
    }
}
