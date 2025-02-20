import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> arr = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) 
            arr.add(Integer.toString(numbers[i]));
        
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String str1 = o1+o2; 
                String str2 = o2+o1;
                return str2.compareTo(str1);
            }
        });
        
        for(String s : arr) answer+=s;
        
        //테케 11번 반례
        if(answer.charAt(0)=='0') return "0";
        
        return answer;
    }
}