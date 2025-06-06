import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String A;
    public static String B;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        arr = new int[A.length()+1][B.length()+1];
        //초기화
        if(A.charAt(0)==B.charAt(0)) arr[0][0] = 1; else arr[0][0] = 0;
        for(int i=1; i<B.length(); i++){
            if(A.charAt(0)==B.charAt(i)) arr[0][i] = 1;
            else arr[0][i] = arr[0][i-1];
        }
        for(int i=1; i<A.length(); i++){
            if(B.charAt(0)==A.charAt(i)) arr[i][0] = 1;
            else arr[i][0] = arr[i-1][0];
        }
        //DP
        for(int i=1; i<A.length(); i++){
            for(int j=1; j<B.length(); j++){
                if(A.charAt(i)==B.charAt(j)) arr[i][j] = arr[i-1][j-1] + 1;
                else arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
            }
        }
        System.out.println(arr[A.length()-1][B.length()-1]);
    }
}
