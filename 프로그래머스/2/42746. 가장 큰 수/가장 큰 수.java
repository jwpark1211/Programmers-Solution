import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> arr = new ArrayList<>();
        
        //int -> String 변환하여 배열 생성 
        for(int i=0; i<numbers.length; i++) 
            arr.add(Integer.toString(numbers[i]));
        
        //String 기준으로 o1+o2와 o2+o1 값 비교, Comparator로 정렬 
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String str1 = o1+o2; 
                String str2 = o2+o1;
                return str2.compareTo(str1);
            }
        });
        
        //StringBuilder 사용 시 성능 향상 
        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);
        
        //테케 11번 반례
        if(sb.toString().charAt(0)=='0') return "0";
        
        return sb.toString();
    }
}