import java.io.*;
import java.util.*;

public class Main {
    static int N; //몇번 응답이 오갔는지를 저장
    static List<Turn> list = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ans = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            list.add(new Turn(ans,strike,ball));
        }

        for(int i=100; i<=999; i++){
            String tmp = String.valueOf(i);
            if((tmp.charAt(0)==tmp.charAt(1))||(tmp.charAt(0)==tmp.charAt(2))||(tmp.charAt(1)==tmp.charAt(2)))
                continue;
            if(tmp.charAt(0)=='0'||tmp.charAt(1)=='0'||tmp.charAt(2)=='0')
                continue;
            boolean flag = true;
            for(Turn turn : list){
                int strike1 = turn.strike; int ball1 = turn.ball;
                String ans1 = turn.ans;
                for(int j=0; j<3; j++){
                    for(int k=0;k<3; k++){
                        if(tmp.charAt(j)==ans1.charAt(k) && j==k){
                            strike1--;
                        }else if(tmp.charAt(j)==ans1.charAt(k)&&j!=k){
                            ball1--;
                        }
                    }
                }
                if(strike1!=0 || ball1!=0){
                    flag = false; break;
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
    static class Turn {
        String ans;
        int strike;
        int ball;
        public Turn(String ans, int strike, int ball){
            this.ans = ans;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
