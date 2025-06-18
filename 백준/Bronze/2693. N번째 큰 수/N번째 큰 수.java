import java.io.*;
import java.util.*;


public class Main {
    public static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();
            for(int j=0; j<10; j++) arr.add(Integer.parseInt(st.nextToken()));
            Collections.sort(arr, Collections.reverseOrder());
            System.out.println(arr.get(2));
        }
    }
}