import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0; int max = 0;
        for(int i=1; i<=10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sum -= Integer.parseInt(st.nextToken()); sum+= Integer.parseInt(st.nextToken());
            if(sum>max) max = sum;
        }
        System.out.println(max);
    }
}