import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        int p1[] = {1,2,3,4,5};
        int p2[] = {2,1,2,3,2,4,2,5};
        int p3[] = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == p1[i%5]) answer[0]++;
            if(answers[i] == p2[i%8]) answer[1]++;
            if(answers[i] == p3[i%10]) answer[2]++;
        }
        
        int max = Math.max(answer[0],Math.max(answer[1],answer[2]));
        
        int size = 0;
        List<Integer> people = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            if(max == answer[i]){
                size++; people.add(i);
            }
        }
        
        int[] result = new int[size];
        for(int i=0; i<size; i++){
            result[i] = people.get(i)+1;
        }
       
        
        return result;
    }
}