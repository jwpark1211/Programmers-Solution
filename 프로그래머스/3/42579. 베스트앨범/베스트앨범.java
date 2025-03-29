import java.util.*;
import java.util.stream.Collectors;

/*중첩 해시맵 + 람다 + 스트림 + 정렬에 대한 정리가 다시 한 번 필요할듯...*/
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //1. 초기화 
        Map<String, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.putIfAbsent(genres[i], new HashMap<Integer, Integer>());
            map.get(genres[i]).put(i, plays[i]);
        }
        //2. 장르 별 노래 재생 횟수 총합을 기준으로 reverse 정렬 
        List<String> genreList = 
            map.entrySet().stream()
            .sorted((e1,e2) -> {
                int sum1 = e1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                int sum2 = e2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                return Integer.compare(sum2, sum1);
            })
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        List<Integer> answerList = new ArrayList<>();
        for(String genre : genreList){
            //3. 장르 내부 내림차순 
            List<Map.Entry<Integer,Integer>> songList = map.get(genre).entrySet().stream()
                .sorted((e1, e2) -> {
                    if(e1.getValue().equals(e2.getValue())){
                        return Integer.compare(e1.getKey(), e2.getKey());
                    }
                    return Integer.compare(e2.getValue(), e1.getValue());
                })
                .collect(Collectors.toList());
            //4. 장르 별 상위 2개씩 수록
            for(int i=0; i<Math.min(2, songList.size()); i++){
                answerList.add(songList.get(i).getKey());
            }
        }
        return answerList.stream().mapToInt(i->i).toArray();
    }
}