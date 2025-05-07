import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) 
            arr[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return Integer.parseInt(s2+s1) - Integer.parseInt(s1+s2);
            }});
        
        if(arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder("");
        for(String s : arr) sb.append(s);
          
        return sb.toString();
    }
}