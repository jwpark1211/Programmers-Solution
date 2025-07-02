import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int S; //전체 문자열 길이
    static int P; //부분 문자열 길이
    static String str; //민호가 임의로 만든 DNA 문자열
    static int[] DNA = new int[4]; //차례로 A, C, G, T
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) DNA[i] = Integer.parseInt(st.nextToken());

        int left = 0; int right = P - 1;
        for(int i=left; i<=right; i++){
            DNA[matchDNA(str.charAt(i))]--;
        }
        if(isCorrect()) ans++;

        while(right<S-1){
            DNA[matchDNA(str.charAt(left++))]++;
            DNA[matchDNA(str.charAt(++right))]--;
            if(isCorrect()) ans++;
        }

        System.out.println(ans);
    }
    private static int matchDNA(char c){
        if(c=='A')      return 0;
        else if(c=='C') return 1;
        else if(c=='G') return 2;
        else return 3;
    }
    private static boolean isCorrect(){
        for(int i=0; i<4; i++){
            if(DNA[i]>0) return false;
        }
        return true;
    }
}