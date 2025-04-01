import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Price> st = new Stack<>();
        
        int T = 0;
        for(int i=0; i<prices.length-1; i++){
            //스택이 비어있으면 
            if(st.isEmpty()){
                st.push(new Price(T,i,prices[i]));
            }else{ //스택이 비어있지 않다면 
                //peek의 value 값이 현재 price보다 작으면 
                if(st.peek().value<=prices[i]){
                    st.push(new Price(T,i,prices[i]));
                }else{ //price보다 크거나 같으면 
                    while(!st.isEmpty() && st.peek().value>prices[i]){
                        answer[st.peek().idx] = T - st.peek().time;
                        st.pop();
                    }
                    st.push(new Price(T, i, prices[i]));
                }
            }
            T++;
        }
        while(!st.isEmpty()){
            answer[st.peek().idx] = T - st.peek().time;
            st.pop();
        }
        return answer;
    }
    static class Price{
        int time;
        int idx;
        int value;
        public Price(int time, int idx, int value){
            this.time = time;
            this.idx = idx;
            this.value = value;
        }
    }
}