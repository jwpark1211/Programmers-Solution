import java.util.*;

//시도 1 : 해시로 간단히 풀리는 문제일듯..?
// list로 풀어서 list.contains 했을 때는 시간복잡도가 O(N)이라 시간초과 -> HashSet의 COntains는 해시 기반이라 O(1)
public class Main {
    static int N, M;
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       N = scanner.nextInt();
       M = scanner.nextInt();
       List<String> answer = new ArrayList<>();
       Set<String> listenPerson = new HashSet<>();

       scanner.nextLine();

       //듣도 못 한 사람
       for(int i=0; i<N; i++) listenPerson.add(scanner.nextLine());

       //보도 못 한 사람
       for(int i=0; i<M; i++){
           String str = scanner.nextLine();
           if(listenPerson.contains(str)) answer.add(str);
       }

       System.out.println(answer.size());
       Collections.sort(answer);
       for(String str : answer) System.out.println(str);
    }
}