import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N; //Pn
    public static int M; //문자열의 길이
    public static String S; //문자열
    public static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int cnt = 0, ans = 0;
        for(int i=1; i<M-1; ) {
            if(S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                cnt++;
                if(cnt == N) {
                    if(S.charAt(i-(cnt*2-1)) == 'I')
                        ans++;
                    cnt--;
                }
                i += 2;
            }
            else {
                cnt = 0;
                i++;
            }
        }
        System.out.println(ans);
    }
}
