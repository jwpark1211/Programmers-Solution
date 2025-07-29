import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long S;
    static int[] array;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        array = new int[N];
        for(int i=0; i<N; i++) array[i] = Integer.parseInt(st.nextToken());

        long sum = array[0];
        int left = 0; int right = 0;
        while(right<N && left<=right){
            if(sum >= S){
                answer = Math.min(answer, right-left+1);
                sum -= array[left++];
            }else{
                if(right==N-1) break;
                sum += array[++right];
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
