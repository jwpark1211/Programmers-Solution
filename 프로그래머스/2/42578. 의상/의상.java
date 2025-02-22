import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hmap = new HashMap<>();
        
        for (String[] tmp : clothes) {
            hmap.put(tmp[1], hmap.getOrDefault(tmp[1], 0) + 1);
        }
            
        Iterator<String> iterator = hmap.keySet().iterator();
        while(iterator.hasNext()){
            answer *= (hmap.get(iterator.next())+1);
        }

        return --answer;
    }
}