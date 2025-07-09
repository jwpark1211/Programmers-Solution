import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(average());
        System.out.println(middle());
        System.out.println(often());
        System.out.println(range());
    }
    //1. 산술평균
    public static long average(){
        double sum = 0;
        for(int i=0; i<N; i++) sum += arr[i];
        return Math.round(sum/N);
    }
    //2.중앙값
    public static int middle(){
        return arr[N/2];
    }
    //3.최빈값
    public static int often(){
        //map 채우기
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        //value 기준으로 정렬
        List<Integer> keySet = new ArrayList(map.keySet());
        keySet.sort((o1,o2)-> Integer.compare(map.get(o2),map.get(o1)));
        //최빈값 list 찾기
        int fV = map.get(keySet.get(0));
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> it = keySet.iterator();
        while(it.hasNext()){
            int next = it.next();
            if(map.get(next)==fV) list.add(next);
            else break;
        }
        //결과 도출
        if(list.size()==1) return list.get(0);
        else {
            Collections.sort(list);
            return list.get(1);
        }
    }
    //4. 범위
    public static int range(){
        return arr[N-1]-arr[0];
    }
}
