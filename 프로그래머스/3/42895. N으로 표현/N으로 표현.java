import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        
        // 5,55,555 ... 초기화 
        for(int i=0; i<=8; i++){
            String res = "";
            String strN = Integer.toString(N);
            if(i==0) list.add(new HashSet<>());
            else{
                for(int j=0; j<i; j++) res += strN;
                int resInt = Integer.parseInt(res);
                if(resInt==number) return i;
                Set<Integer> set = new HashSet<>(Arrays.asList(resInt));
                list.add(set);
            }
        }
        
        for(int i=2; i<=8; i++){

            Set<Integer> set = list.get(i);
            
            for(int j=1; j<=i/2+1; j++){
                Set<Integer> set1 = list.get(j);
                Set<Integer> set2 = list.get(i-j);
                
                for(int s1 : set1){
                    for(int s2 : set2){
                        int sum = s1+s2;
                        set.add(sum);
                        int sub = (s1 > s2) ? s1-s2 : s2-s1;
                        set.add(sub);
                        int mul = s1*s2;
                        set.add(mul);
                        if(s1!=0 && s2!=0){
                            int div = (s1 > s2) ? s1/s2 : s2/s1;
                            set.add(div);
                            if(div==number) return i;
                        }
                        if(sum==number||sub==number||mul==number)
                            return i;
                    }
                }
            }
        }
 
        return -1;
    }
}