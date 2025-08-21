import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static int H,W;
    static int block[];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[W+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=W; i++) block[i]=Integer.parseInt(st.nextToken());
        //계산
        int left = block[1];
        int right = 0;
        for(int i=2; i<W; i++){
            left = Math.max(block[i-1],left);
            right = 0;
            for(int j=i+1; j<=W; j++) right=Math.max(right,block[j]);
            int b = Math.min(left,right);
            if(b>block[i]) answer += b-block[i];
        }
        System.out.println(answer);
    }
}
