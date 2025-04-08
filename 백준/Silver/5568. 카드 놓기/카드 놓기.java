import java.util.*;

public class Main {
    static Set<Integer> answerList = new HashSet<>();
    static int[] visited;
    static int N;
    static int K;
    public static void DFS(int cnt, String res, String[] numberList){
        if(cnt==K){
            answerList.add(Integer.parseInt(res));
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i]==0 && cnt<K){
                visited[i] = 1;
                DFS(cnt+1, res+numberList[i], numberList);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        //초기화
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        String[] numberList = new String[N];

        visited = new int[N];
        sc.nextLine();
        for(int i=0; i<N; i++){
            numberList[i] = sc.nextLine();
        }

        DFS(0, "", numberList);

        Iterator<Integer> iterator = answerList.iterator();
        System.out.println(answerList.size());
    }
}