import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H,W; //(1 ≤ H, W ≤ 500)
    static int[] block;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        block = new int[W];
        for(int i=0; i<W; i++) block[i] = Integer.parseInt(st.nextToken());

        //계산
        int left = block[0];
        for(int i=1; i<W; i++){
            //left max
            left = Math.max(left, block[i-1]);
            //right max
            int right = 0;
            for(int j=i+1; j<W; j++) right = Math.max(right, block[j]);

            int min = Math.min(left, right);
            if(block[i]<min) answer += (min - block[i]);
        }

        System.out.println(answer);
    }
}
