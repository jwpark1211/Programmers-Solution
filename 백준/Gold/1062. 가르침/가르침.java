import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static int ans = 0;
    public static String[] arr;
    public static void dfs(int bef, boolean[] alphabet, int cnt){
        if(cnt == K-5){
            int a = 0; //예비 정답
            for(int i=0; i<N; i++){
                String str = arr[i];
                boolean flag = true;
                for(int j=0; j<str.length(); j++){
                    if(alphabet[(int)str.charAt(j)-'a']==false){
                        flag = false; break;
                    }
                }
                if(flag) a++;
            }
            ans = Math.max(ans, a);
        }
        for(int i=bef; i<26; i++){
            if(!alphabet[i] && cnt<K-5) {
                alphabet[i] = true;
                dfs(i, alphabet, cnt+1);
                alphabet[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            str.replace("anta", "");
            str.replace("tica", "");
            arr[i] = str;
        }

        boolean[] alphabet = new boolean[26];
        alphabet['a'-'a'] = true;
        alphabet['c'-'a'] = true;
        alphabet['n'-'a'] = true;
        alphabet['i'-'a'] = true;
        alphabet['t'-'a'] = true;

        if(K<5) System.out.println(0);
        else if(K==26) System.out.println(N);
        else{
            dfs(0,alphabet,0);
            System.out.println(ans);
        }
    }
}