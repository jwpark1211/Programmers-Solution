import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static List<String> answer = new ArrayList<>();
    static void dfs(String str){

        for(int i=0; i<=9; i++){
            String Last = String.valueOf(str.charAt(str.length()-1));
            if(Integer.parseInt(Last)>i){
                String next = str + String.valueOf(i);
                answer.add(next);
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer.add("0");
        for(int i=1; i<=9; i++) {
            answer.add(String.valueOf(i));
            dfs(String.valueOf(i));
        }

        Collections.sort(answer, Comparator.comparingInt(String::length));
        if(N<answer.size()) System.out.println(answer.get(N));
        else System.out.println(-1);
    }

}
