import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int H, W, N;
    static int answer = 0;
    static List<Sticker> stickerList = new ArrayList<>();
    private static void DFS(int cnt, int idx1, int idx2){
        if(cnt == 2){
            Sticker sticker1 = stickerList.get(idx1);
            Sticker sticker2 = stickerList.get(idx2);
            /*System.out.println("sticker1.r = " + sticker1.r);
            System.out.println("sticker1.c = " + sticker1.c);
            System.out.println("sticker2.r = " + sticker2.r);
            System.out.println("sticker2.c = " + sticker2.c);
            System.out.println();*/
            if((sticker1.r<=H && sticker2.r<=H && sticker1.c+sticker2.c<=W) ||
                    (sticker1.r<=W && sticker2.r<=W && sticker1.c+sticker2.c<=H) ||
                    (sticker1.r+sticker2.c<=H && sticker1.c<=W && sticker2.r<=W) ||
                    (sticker2.r+sticker1.c<=H && sticker2.c<=W && sticker1.r<=W) ||
                    (sticker1.r+sticker2.r<=H && sticker1.c<=W && sticker2.c<=W)){
                answer = Math.max(answer, sticker1.r * sticker1.c + sticker2.r * sticker2.c);
            }
            return;
        }
        if(idx1 == -1){
            for(int i=0; i<N; i++){
                idx1 = i;
                DFS(1, idx1, -1);
            }
        }else if(idx2 == -1){
            for(int i=idx1+1; i<N; i++){
                idx2 = i;
                DFS(2, idx1, idx2);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        if (H < W) {
            int tmp = H;
            H = W;
            W = tmp;
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stickerList.add(new Sticker(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        DFS(0,-1, -1);
        System.out.println(answer);
    }
    static class Sticker{
        int r;
        int c;
        public Sticker(int r, int c){
            this.r = Math.max(r,c);
            this.c = Math.min(r,c);
        }
    }
}