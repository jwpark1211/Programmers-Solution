import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N1, N2 ,T;
    static String N1List;
    static String N2List;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        N1List = br.readLine();
        N2List = br.readLine();

        ArrayList<Ant> arr = new ArrayList<>();
        for(int i=N1List.length()-1; i>=0; i--) arr.add(new Ant(1, N1List.charAt(i)));
        for(int i=0; i<N2List.length(); i++) arr.add(new Ant(0, N2List.charAt(i)));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            for(int j=0; j<arr.size()-1; j++){
                //System.out.println("j = " + j);
                if(arr.get(j).dir==1 && arr.get(j+1).dir==0){
                    //switch
                    Ant tmpJ = arr.get(j);
                    Ant tmpJ1 = arr.get(j+1);
                    arr.remove(j);
                    arr.remove(j);
                    arr.add(j, tmpJ1);
                    arr.add(j+1, tmpJ);
                    j+=1;
                }
            }
        }
        for(Ant ant : arr){
            System.out.print(ant.alpha);
        }
    }
    static class Ant{
        int dir; //0이면 좌측 1이면 우측
        char alpha;
        public Ant(int dir, char alpha){
            this.dir = dir;
            this.alpha = alpha;
        }
    }
}
