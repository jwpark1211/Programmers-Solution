import java.util.*;

//kruskal algorithm 외워서 해결 
class Solution {
    public static void union(int[] parent, int a, int b){
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);
        if(a_parent < b_parent) parent[b_parent] = a_parent;
        else parent[a_parent] = b_parent;
    }
    public static int find(int[] parent, int i){
        if(parent[i] == i) return i;
        return find(parent, parent[i]);
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        //union-find를 위한 parent 초기화
        int [] parent = new int[n];
        for(int i=0; i<parent.length; i++) parent[i]=i;
        //가중치 기준으로 정렬 
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        for(int i=0; i<costs.length; i++){
            if(find(parent, costs[i][0])!=find(parent, costs[i][1])){
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }
}