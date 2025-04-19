import java.util.*;

/* 1차 시도 : DP 로 해결하고자 함 -> 발생한 문제 : 0부터 시작한다는 가정이 증명되기 어려움 */
/* 2차 시도 : 이진 탐색 이용 -> 프로그래머스에 있던 징검다리 문제와 유사함 */
/* 3차 시도 : long -> int 오버플로우 발생 형변환 해결 */
public class Main {
    public static void main(String[] args) {
        long K = 0; //정답
        Scanner scanner = new Scanner(System.in);
        //입력 받기
        int N = scanner.nextInt();
        int arr[] = new int[N];
        for(int i=0; i<N; i++) arr[i] = scanner.nextInt();

        long low = 0L; long high = (long) (N-1) * (1 + Math.abs(arr[N-1]-arr[0]));
        long mid = (low + high) / 2;
        while(low<=high){
            mid = (low + high)/2;
            if(canReach(arr, mid)){
                K = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        System.out.println(K);
    }

    public static boolean canReach(int[] arr, long max){
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = cur+1; i  < arr.length; i++){
                if((long)(i-cur)*(1+Math.abs(arr[i]-arr[cur]))>max) continue;
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return visited[arr.length-1];
    }

}