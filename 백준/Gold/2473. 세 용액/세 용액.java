import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; //3 이상 5000 이하
    static long[] value; //각 용액들의 특성값
    static long[] answer = new long[3]; //정답
    static long totalValue = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) value[i] = Long.parseLong(st.nextToken());
        Arrays.sort(value); //값 오름차순 정렬

        for(int i=0; i<N-2; i++){
            int start = i;
            int mid = i + 1;
            int end = N - 1;
            while(mid < end){
                long sum = value[start]+value[mid]+value[end];
                if(Math.abs(sum) < totalValue){
                    totalValue = Math.abs(sum);
                    answer[0] = value[start];
                    answer[1] = value[mid];
                    answer[2] = value[end];
                }

                if(sum == 0){
                    break;
                }else if(sum > 0){
                    end --;
                }else{
                    mid ++;
                }
            }
        }
        System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
    }
}
