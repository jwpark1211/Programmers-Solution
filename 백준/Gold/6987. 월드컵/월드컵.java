import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int games[][] = new int[15][2];
    public static int map[][] = new int[6][3];
    public static boolean answer[] = new boolean[4];
    public static void main(String[] args) throws IOException {
        //games값 초기화
        int idx = 0;
        for(int i=0; i<6; i++){
            for(int j=i+1; j<6; j++){
                games[idx][0] = i;
                games[idx][1] = j;
                idx++;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int win = 0 ; int eq = 0; int lose = 0;
            for(int m=0; m<6; m++){
                map[m][0] = Integer.parseInt(st.nextToken());
                map[m][1] = Integer.parseInt(st.nextToken());
                map[m][2] = Integer.parseInt(st.nextToken());
                win+=map[m][0]; eq+=map[m][1]; lose+=map[m][2];
            }
            if(win!=lose || eq%2!=0) {
                answer[i] = false;
            }else{
                dfs(i, 0);
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<4; i++){
            if(answer[i]) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int caseNum, int idx){
        if(answer[caseNum]) return;
        if(idx==15){
            if(isCorrect(map)) answer[caseNum] = true;
            return;
        }else{
            int a = games[idx][0];
            int b = games[idx][1];

            if(map[a][0]>0 && map[b][2]>0){
                map[a][0]--; map[b][2]--;
                dfs(caseNum, idx+1);
                map[a][0]++; map[b][2]++;
            }
            if(map[a][1]>0 && map[b][1]>0){
                map[a][1]--; map[b][1]--;
                dfs(caseNum, idx+1);
                map[a][1]++; map[b][1]++;
            }
            if(map[a][2]>0 && map[b][0]>0){
                map[a][2]--; map[b][0]--;
                dfs(caseNum, idx+1);
                map[a][2]++; map[b][0]++;
            }
        }
    }
    public static boolean isCorrect(int map[][]){
        for(int i=0; i<6; i++){
            for(int j=0; j<3; j++){
                if(map[i][j]!=0) return false;
            }
        }
        return true;
    }
}
