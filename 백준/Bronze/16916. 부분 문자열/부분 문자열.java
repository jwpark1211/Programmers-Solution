import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String parent, pattern;
    static int[] pi;
    static int flag = 0;
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parent = br.readLine();
        pattern = br.readLine();
        pi = new int[pattern.length()];

        //접두-접미 테이블 생성
        makePI(pattern);

        //KMP 계산
        KMP(parent, pattern);

        //결과 도출
        System.out.println(flag);

    }
    static void KMP(String parent, String pattern){
        int idx = 0;
        for(int i=0; i<parent.length(); i++){
            if(idx>0 && parent.charAt(i)!=pattern.charAt(idx)) idx = pi[idx-1];
            if(parent.charAt(i)==pattern.charAt(idx)){
                if(idx == pattern.length()-1) {
                    flag = 1;
                    break;
                }
                else idx++;
            }
        }
    }
    static void makePI(String pattern){
        int idx = 0;
        for(int i=1; i<pattern.length(); i++){
            if(idx>0 && pattern.charAt(idx)!=pattern.charAt(i)) idx = pi[idx-1];
            if(pattern.charAt(idx)==pattern.charAt(i)){
                idx ++;
                pi[i] = idx;
            }
        }
    }
}
