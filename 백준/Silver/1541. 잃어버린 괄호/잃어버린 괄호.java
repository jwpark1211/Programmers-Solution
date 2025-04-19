import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        String tmp = "";

        //Greedy하게 계산하기
        int result = 0;
        for(int i=0; i<exp.length(); i++) {
            if (exp.charAt(i) == '-') {
                if(!tmp.equals("")) result += Integer.parseInt(tmp);
                tmp = "";

                String tmp2 = "";
                int resultTmp = 0;
                i++;
                while(i<exp.length() && exp.charAt(i)!='-'){
                    if(exp.charAt(i)=='+'){
                        if(!tmp2.equals("")) resultTmp += Integer.parseInt(tmp2);
                        tmp2 = "";
                    }else{
                        tmp2 += exp.charAt(i);
                    }
                    i++;
                }
                i--;
                if(!tmp2.equals("")) resultTmp += Integer.parseInt(tmp2);
                result -= resultTmp;
            } else if(exp.charAt(i)=='+'){
                if(!tmp.equals("")) result += Integer.parseInt(tmp);
                tmp = "";
            }else{
                tmp += exp.charAt(i);
            }
        }
        if(!tmp.equals("")) result += Integer.parseInt(tmp);
        System.out.println(result);
    }
}