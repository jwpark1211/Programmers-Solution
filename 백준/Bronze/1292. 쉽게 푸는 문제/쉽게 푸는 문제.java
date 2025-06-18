import java.io.*;
import java.util.*;


public class Main {
    public static int A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());

        int max = 1; int sum = 0;
        for(int i=1; i<=B; i++){
            for(int j=0; j<max; j++){
                if(i>B) break;
                if(i>=A && i<=B) sum+=max;
                i++;
            }
            max++; i--;
        }

        System.out.println(sum);
    }
}