import java.util.*;

//시도 1 : pq로만 푸니까 시간 초과
public class Main {
    static int N;
    public static void main(String[] args) {
        //초기화
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        N = scanner.nextInt();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                pq.add(scanner.nextLong());
            }
        }

        for(int i=0; i<N-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}