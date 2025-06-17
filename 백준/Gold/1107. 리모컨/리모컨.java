import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int ans;
    public static boolean isBroken[] = new boolean[10]; //false = 정상 true = 고장남
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        if(M!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) isBroken[Integer.parseInt(st.nextToken())] = true;
        }

        //ans 초기화
        ans = Math.abs(N - 100);

        //Equal + UP 확인
        for(int i=0; i<=ans; i++){
            if(isValid(N+i)){
                ans = Math.min(ans, i + String.valueOf(N+i).length());
                break;
            }
        }

        //DOWN 확인
        for(int i=0; i<=ans && N-i>=0; i++){
            if(isValid(N-i)){
                ans = Math.min(ans, i + String.valueOf(N-i).length());
                break;
            }
        }

        System.out.println(ans);
    }
    public static boolean isValid (int num){
        if(num==0){
            if(isBroken[0]) return false;
            else return true;
        }

        while(num>0){
            if(isBroken[num%10]){
                return false;
            }
            num/=10;
        }
        return true;
    }
}