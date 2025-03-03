import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();
        
        for(int[] command : commands){
            List<Integer> list = new ArrayList<>();
            for(int i=command[0]-1; i<command[1]; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answerList.add(list.get(command[2]-1));
        }
        
        // List<Integer> -> int[] 변환 (stream 사용)
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}