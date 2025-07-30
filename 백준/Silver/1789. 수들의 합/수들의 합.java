import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static long S; //구해야할값
    static int N = 0; //정답
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        long sum = 0;
        for(int i=1; i<S+1; i++){
            long tmp = sum+i;
            if(tmp == S){
                //System.out.println("i = " + i);
                System.out.println(N+1);
                break;
            }
            if(tmp<S && S-tmp<i+1){
                System.out.println(N+1);
                break;
            }
            sum = tmp;
            N++;

        }
    }

}
