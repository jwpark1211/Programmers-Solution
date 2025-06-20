import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N; //숫자의 개수
    public static int[] op = new int[4]; // + - * /
    public static int arr[] ;
    public static List<Integer> arrList = new ArrayList<>(); //결과값 저장
    static void dfs(int idx, int sum, int plus, int minus, int mul, int div){
        if(idx==N-1) {
            arrList.add(sum);
            return;
        }
        if(plus>0) dfs(idx+1, sum+arr[idx+1],plus-1, minus, mul, div);
        if(minus>0) dfs(idx+1, sum-arr[idx+1],plus, minus-1, mul, div);
        if(mul>0) dfs(idx+1, sum*arr[idx+1],plus, minus, mul-1, div);
        if(div>0){
            if(sum<0 && arr[idx+1]>0) {
                int tmp = (sum*(-1))/arr[idx+1];
                dfs(idx+1, tmp*(-1),plus, minus,mul, div-1);
            }else{
                dfs(idx+1, sum/arr[idx+1],plus, minus,mul,div-1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());

        dfs(0, arr[0], op[0], op[1], op[2], op[3]);

        //정답 출력
        Collections.sort(arrList);
        System.out.println(arrList.get(arrList.size()-1));
        System.out.println(arrList.get(0));
    }
}