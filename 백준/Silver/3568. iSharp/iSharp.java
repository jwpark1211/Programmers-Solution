import java.io.*;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] list1 = str.split(" ");
        String defaultVariable = list1[0];

        String[] list2 = new String[list1.length-1];
        for(int i=1; i<list1.length; i++){
            StringBuilder sb = new StringBuilder(list1[i]);
            list2[i-1] = sb.deleteCharAt(list1[i].length()-1).toString();
        }

        for(int i=0; i<list2.length; i++){
            String tmp = list2[i];
            boolean flag = false;
            String name = "";
            String extraVariable = "";
            for(int j=0; j<tmp.length(); j++){
                if(tmp.charAt(j)=='*' || tmp.charAt(j)=='[' || tmp.charAt(j)==']' || tmp.charAt(j)=='&'){
                    flag = true;
                }
                if(!flag) name += tmp.charAt(j);
                else extraVariable += tmp.charAt(j);
            }

            //출력!
            if(extraVariable.length()==0){
                System.out.println(defaultVariable+" "+name+";");
            }else{
                System.out.print(defaultVariable);
                StringBuilder sb = new StringBuilder(extraVariable).reverse();
                String extra = sb.toString();
                for(char c : extra.toCharArray()){
                    if(c == ']') continue;
                    if(c =='[') System.out.print("[]");
                    else System.out.print(c);
                }
                System.out.println(" "+name+";");
            }
        }

    }
}
