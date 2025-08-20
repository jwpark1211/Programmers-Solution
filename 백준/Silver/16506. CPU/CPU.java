import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String[] opAss = {"ADD","ADDC","SUB","SUBC","MOV","MOVC","AND",
    "ANDC","OR","ORC","NOT","MULT","MULTC","LSFTL","LSFTLC","LSFTR","LSFTRC","ASFTR","ASFTRC",
    "RL","RLC","RR","RRC"};
    static String[] opMac = {"00000","00001","00010","00011","00100","00101","00110","00111",
    "01000","01001","01010","01100","01101","01110","01111","10000","10001","10010","10011",
    "10100","10101","10110","10111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] answerList = new String[T];
        for(int i=0; i<T; i++){
            String str = br.readLine();
            String[] arr = str.split(" ");
            StringBuilder sb = new StringBuilder("");

            //1. operation 번역
            for(int j=0; j<opAss.length; j++){
                if(opAss[j].equals(arr[0])) {
                    sb.append(opMac[j]);
                }
            }

            //2.[5]번째 0 더하기
            sb.append("0");

            //3.rD + rA번역
            String rD = toBinary(arr[1]);
            for(int j=0; j<3-rD.length(); j++) sb.append("0");
            sb.append(rD);

            String rA = toBinary(arr[2]);
            for(int j=0; j<3-rA.length(); j++) sb.append("0");
            sb.append(rA);

            //4. rB 혹은 #C 번역
            if(sb.charAt(4)=='1'){
                String C = toBinary(arr[3]);
                for(int j=0; j<4-C.length(); j++) sb.append("0");
                sb.append(C);
            }else{
                String rB = toBinary(arr[3]);
                for(int j=0; j<3-rB.length(); j++) sb.append("0");
                sb.append(rB);
                sb.append("0");
            }

            //5. 정답 출력
            answerList[i]=sb.toString();
        }
        for(String ans : answerList)
            System.out.println(ans);
    }
    public static String toBinary(String n){
        int num = Integer.parseInt(n);
        return Integer.toBinaryString(num);
    }
}
