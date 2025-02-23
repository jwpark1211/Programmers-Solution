import java.util.*;

class Solution {
    int visited[] = new int[10];
    Set<Integer> set = new HashSet<>();
    
    //소수 판별 
    public boolean isPrime(int n){
        if(n==1 || n==0) return false;
        for(int i=2; i<n; i++) if(n%i==0) 
            return false;
        return true;
    }
    
    //DFS로 numbers로 만들 수 있는 모든 경우의 수 찾음 -> Set으로 중복 제거 
    public void DFS(String numbers, int cnt, String result){
        if(cnt == numbers.length()){
            if(result != ""){
                set.add(Integer.parseInt(result));
            }
            return;
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]==0){
                visited[i] = 1;
                DFS(numbers, cnt+1, result+numbers.charAt(i));
                visited[i] = 0;
                DFS(numbers, cnt+1, result);
            }
        }
    }
    
    //결과 도출
    public int solution(String numbers) {
        int answer = 0;
        //DFS로 모든 경우의 수 찾고 Set에 값 정리 
        DFS(numbers, 0, "");
        for(int s : set){
            //Set 돌면서 해당 값이 소수인지 판별 
            if(isPrime(s)) answer++;
        }
        return answer;
    }
}