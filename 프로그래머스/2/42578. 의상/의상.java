import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        for(String[] ct : clothes){
            hm.put(ct[1], hm.getOrDefault(ct[1],0)+1);
        }
        
        int sum = 1;
        Set<String> key = hm.keySet();
        for(String k : key){
           sum *= (hm.get(k)+1);
        }
        
        return sum-1;
    }
}