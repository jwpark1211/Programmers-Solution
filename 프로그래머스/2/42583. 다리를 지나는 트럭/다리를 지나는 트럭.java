import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> wQ = new LinkedList<>(); //대기 큐 
        for(int w : truck_weights) wQ.offer(w);
        Queue<Truck> bQ = new LinkedList<>(); //다리 큐 
        
        int cnt = 0; //다리를 지난 트럭의 수
        int total = 0; //현재 다리 위에 있는 차량의 무게 
        while(true){
            //모두 다 다리를 지나면 끝 !
            if(cnt==truck_weights.length) break;
            if(!bQ.isEmpty() && (time-bQ.peek().start)==bridge_length){
                cnt ++;
                total -= bQ.poll().weight;
            }
            //만약 대기 큐가 비어있지 않고, 모든 조건을 만족한다면
            if(!wQ.isEmpty() && total+wQ.peek()<=weight && bQ.size()<bridge_length){
                total += wQ.peek();
                bQ.offer(new Truck(time, wQ.poll()));
            }
            time ++;
        }
        return time;
    }
    
    static class Truck{
        int start; //건너기 시작한 시간
        int weight; //트럭의 무게 
        public Truck(int start, int weight){
            this.start = start;
            this.weight = weight;
        }
    }
}