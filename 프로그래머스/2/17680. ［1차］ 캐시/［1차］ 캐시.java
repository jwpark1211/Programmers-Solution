import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<cities.length; i++) 
            cities[i] = cities[i].toUpperCase();
        
        if(cacheSize==0) return cities.length*5;
        
        for(int i=0; i<cities.length; i++){
            //cache hit
            if(map.containsKey(cities[i])){
                answer += 1;
                map.put(cities[i],i);
            //cache miss
            }else{
                answer += 5;
                if(map.size()<cacheSize) {
                    map.put(cities[i],i);
                }else {
                    int minIdx = 100001;
                    String minKey = "";
                    Set<String> keySet = map.keySet();
                    for(String key : keySet){
                        if(map.get(key)<minIdx) {
                            minIdx = map.get(key);
                            minKey = key;
                        }
                    }
                    map.remove(minKey);
                    map.put(cities[i],i);
                }
            }
        }
        return answer;
    }
}