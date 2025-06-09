import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static int M;
    public static int N;
    public static int x;
    public static int y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int year = x;
            boolean isFound = false;
            while(year <= M * N){
                if(year % N == (y % N)){
                    isFound = true;
                    break;
                }
                year += M;
            }
            if(!isFound) bw.write("-1\n");
            else bw.write(year + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

