import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String a;
    public static String b;
    public static int answer = 0;

    public static void dfs(String cur) {
        if (cur.length() < a.length()) return;
        if (cur.equals(a)) {
            answer = 1;
            return;
        }
        // 끝이 A인 경우 → A 제거
        if (cur.charAt(cur.length() - 1) == 'A') {
            dfs(cur.substring(0, cur.length() - 1));
        }
        // 끝이 B인 경우 → B 제거 후 reverse
        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur);
            sb.reverse();
            if (sb.charAt(sb.length() - 1) == 'B') {
                dfs(sb.substring(0, sb.length() - 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        dfs(b);
        System.out.println(answer);
    }
}
