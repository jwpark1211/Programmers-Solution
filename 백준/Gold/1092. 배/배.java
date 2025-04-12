import java.util.*;

public class Main {
    public static void main(String[] args) {
        //깂 입력 받기 [ 크레인, 박스 ]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> crane = new ArrayList<>();
        sc.nextLine();
        for(int i=0; i<N; i++) crane.add(sc.nextInt());
        int M = sc.nextInt();
        List<Integer> box = new ArrayList<>();
        boolean[] visited = new boolean[M];
        sc.nextLine();
        for(int i=0; i<M; i++) box.add(sc.nextInt());

        //크레인과 박스 모두 내림차순 정렬
        Collections.sort(box, Collections.reverseOrder());
        Collections.sort(crane, Collections.reverseOrder());

        if(crane.get(0)<box.get(0)){
            System.out.println(-1);
        }
        else {
            /* 풀이 고민.. : Greedy 적용, 무거운 박스가 우선순위 선점 */
            /*64%에서 시간초과로 죽어버림 => ArrayList의 remove 기능 대신 visited로 방문 처리  */
            int time = 0;
            int cnt = 0;
            while (cnt < M) {
                int boxIdx = 0;
                for (int i = 0; i < N; i++) {
                    while (boxIdx<M) {
                        if (!visited[boxIdx] && crane.get(i) >= box.get(boxIdx) ) {
                            visited[boxIdx++] = true;
                            cnt++;
                            break;
                        }
                        boxIdx++;
                    }
                }
                time++;
                //System.out.println("time="+time);
            }
            System.out.println(time);
        }
    }
}