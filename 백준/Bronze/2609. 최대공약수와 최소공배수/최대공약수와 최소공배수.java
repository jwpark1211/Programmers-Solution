import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int A,B;
    //최대 공약수
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    //최소 공배수
    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
        System.out.println(gcd(A,B));
        System.out.println(lcm(A,B));
    }
}