import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M; //N = A 집합의 개수, M = B 집합의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = (Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) B[i] = (Integer.parseInt(st.nextToken()));

        Set<Integer> set = new HashSet<>();
        for(int a : A) set.add(a);
        for(int b : B){
            if(set.contains(b)) set.remove(b);
            else set.add(b);
        }

        System.out.println(set.size());
    }
}