import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        //초기화
        Set<List<Integer>>[] arr = new HashSet[n+1];
        for (int i = 0; i <= n; i++) arr[i] = new HashSet<>();
        for (int[] result : results){
            arr[result[0]].add(Arrays.asList(result[0], result[1]));
            arr[result[1]].add(Arrays.asList(result[0], result[1]));
        }
        
         for(int i=1; i<=n; i++){
            System.out.println("i="+i+", size="+arr[i].size());
        }
        System.out.println();
        
        // 모든 경우의 수 순회 
        for(int i=1; i<=n; i++){
            Set<List<Integer>> player = arr[i];
            for(List<Integer> result : new ArrayList<>(player)){
                //player가 승리한 경기인 경우 
                if(result.get(0)==i){
                    for(List<Integer> winResult : new ArrayList<>(arr[result.get(1)])){
                        if(result.get(1)==winResult.get(0)){
                            arr[i].add(Arrays.asList(i, winResult.get(1)));
                            arr[winResult.get(1)].add(Arrays.asList(i, winResult.get(1)));
                        }
                    }
                }
                //player가 진 경기인 경우
                else{
                    for(List<Integer> loseResult : new ArrayList<>(arr[result.get(0)])){
                        if(result.get(0)==loseResult.get(1)){
                            arr[i].add(Arrays.asList(loseResult.get(0),i));
                            arr[loseResult.get(0)].add(Arrays.asList(loseResult.get(0),i));
                        }
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(arr[i].size()==n-1) answer++;
            System.out.println("i="+i+", size="+arr[i].size());
        }
        
        return answer;
    }
}