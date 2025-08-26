import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for(int i=0; i<N; i++) strings[i]=br.readLine();

        int maxLen = -1;
        String a = "";
        String b = "";

        for(int i=0; i<N-1; i++){
            String cur = strings[i];
            if(cur.length()<=maxLen) continue;
            for(int j=i+1; j<N; j++){
                String next = strings[j];
                if(next.length()<=maxLen) continue;
                int length = commonLength(cur, next);

                if(length>maxLen){
                    maxLen = length;
                    a = cur;
                    b = next;
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
    static int commonLength(String a, String b){
        int length = Math.min(a.length(), b.length());
        int idx= 0;
        while(idx<length && a.charAt(idx)==b.charAt(idx)) idx++;
        return idx;
    }
}
