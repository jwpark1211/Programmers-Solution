import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            List<Integer> arr = new ArrayList<>();
            while(N>1){
                arr.add(N%2);
                N/=2;
            }
            arr.add(1);
            for(int j=0; j<arr.size(); j++){
                if(arr.get(j)==1) System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}