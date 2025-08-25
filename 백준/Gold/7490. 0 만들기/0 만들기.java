import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {
    static int T;
    static int[] N;
    static ArrayList<String> answers = new ArrayList<>();
    public static void dfs(int nIdx, int idx, String str){
        if(idx>nIdx+1) return;
        if(idx==nIdx+1){
            String res = str.replace(" ","");
            res="+"+res;
            int ans = 0;
            //System.out.println("res = " + res);
            for(int i=0; i<res.length(); i++){
                if(res.charAt(i)=='+' || res.charAt(i)=='-'){
                    String tmp = "";
                    int j=i+1;
                    while(j<res.length() && res.charAt(j)!='+' && res.charAt(j)!='-'){
                        tmp+=res.charAt(j++);
                    }
                    if(res.charAt(i)=='+') ans+=Integer.parseInt(tmp);
                    if(res.charAt(i)=='-') ans-=Integer.parseInt(tmp);
                    i=j-1;
                }
            }
            if(ans==0) answers.add(str);
        }else {
            dfs(nIdx, idx + 1, str + "+" + String.valueOf(idx));
            dfs(nIdx, idx + 1, str + "-" + String.valueOf(idx));
            dfs(nIdx, idx + 1, str + " " +String.valueOf(idx));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(br.readLine());
        }
        for(int n : N){
            dfs(n,2,"1");
            Collections.sort(answers);
            for(String s : answers) System.out.println(s);
            answers = new ArrayList<>();
            System.out.println();
        }
    }
}
