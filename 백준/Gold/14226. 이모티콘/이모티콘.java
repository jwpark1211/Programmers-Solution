import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        Queue<int[]> q = new LinkedList<>(); //화면, 클립보드
        q.add(new int[]{1,0,0}); //초기값

        boolean visited[][] = new boolean[1001][1001];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int screen = cur[0];
            int clipboard = cur[1];
            int time = cur[2];
            if(screen==S){
                System.out.println(time);
                break;
            }

            //1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if(!visited[screen][screen]){
                visited[screen][screen]=true;
                q.add(new int[]{screen, screen, time+1});
            }
            //2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if(clipboard!=0 && screen+clipboard<1001 && !visited[screen+clipboard][clipboard]){
                visited[screen+clipboard][clipboard]=true;
                q.add(new int[]{screen+clipboard, clipboard, time+1});
            }
            //3.화면에 있는 이모티콘 중 하나를 삭제한다.
            if(screen-1>0 && !visited[screen-1][clipboard]){
                visited[screen-1][clipboard]=true;
                q.add(new int[]{screen-1, clipboard, time+1});
            }
        }
    }
}
