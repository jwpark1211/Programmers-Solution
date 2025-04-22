import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//휴게소 세우기 => 징검다리 문제??
public class Main {
    static int N, M, L; //N = 현재 휴게소의 개수, M = 더 지으려고 하는 휴게소의 개수, L = 고속도로의 길이
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+2];
        arr[0] = 0; arr[N+1] = L;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = (Integer.parseInt(st.nextToken()));
        Arrays.sort(arr); //arr sort (오름차순)

        int low = 0; int high = L;
        int mid = (low+high)/2;
        while(low<=high){
            mid = (low+high)/2;

            int cnt = 0;
            for(int i=1; i<arr.length; i++){
                if(arr[i]-arr[i-1]<=mid) continue;
                int tmp = arr[i-1];
                while(tmp<arr[i]){
                    tmp += mid;
                    if(tmp<arr[i]) cnt ++;
                    if(cnt>M) break;
                }
            }
            //System.out.println("mid = " + mid);
            //System.out.println("cnt = " + cnt);

            if(cnt <= M){
                answer = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }

        }
        System.out.println(answer);
    }
}