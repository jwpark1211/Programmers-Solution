import java.io.*;
import java.util.*;

public class Main {
    //투포인터 + 슬라이딩 윈도우로 접근
    public static int N; //탕후루 과일의 개수
    public static int ans = 0;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int [] arr = new int[N]; //탕후루
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int low = 0; int high = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(true){
            map.put(arr[high], map.getOrDefault(arr[high],0)+1);
            if(map.size()<=2){
                ans = Math.max(ans, high-low+1);
            }else{
                if(map.get(arr[low])==1) map.remove(arr[low]);
                else map.put(arr[low],map.get(arr[low])-1);
                low ++;
            }
            if(high<N-1) high ++;
            else break;

        }
        System.out.println(ans);
    }
}