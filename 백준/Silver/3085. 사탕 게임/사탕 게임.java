import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int N;
    static int answer = 1;
    static char[][] array;
    public static void main(String[] args) throws IOException {
        //입력부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new char[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                array[i][j] = s.charAt(j);
            }
        }

        //구현부
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j<N-1 && array[i][j+1]!=array[i][j]){
                    //1. 두 수를 바꿈
                    char tmp = array[i][j];
                    array[i][j] = array[i][j+1];
                    array[i][j+1] = tmp;

                    //최대 길이를 셈
                    count1();
                    count2();

                    //2. 두 수를 원상복귀
                    tmp = array[i][j];
                    array[i][j] = array[i][j+1];
                    array[i][j+1] = tmp;
                }

                if(i<N-1 && array[i+1][j]!=array[i][j]){
                    //1. 두 수를 바꿈
                    char tmp = array[i][j];
                    array[i][j] = array[i+1][j];
                    array[i+1][j] = tmp;

                    //최대 길이를 셈
                    count1();
                    count2();

                    //2. 두 수를 원상복귀
                    tmp = array[i][j];
                    array[i][j] = array[i+1][j];
                    array[i+1][j] = tmp;
                }
            }
        }

        System.out.println(answer);
    }


    //행방향 계산
    static void count1(){
        for(int i=0; i<N; i++){
            int cnt = 1;
            for(int j=0; j<N-1; j++){

                if(array[i][j]==array[i][j+1]){
                    cnt ++;
                    answer = Math.max(cnt, answer);
                }else{
                    cnt = 1;
                }
            }
        }
    }
    //열방향 계산
    static void count2(){
        for(int j=0; j<N; j++){
            int cnt = 1;
            for(int i=0; i<N-1; i++){
                if(array[i][j]==array[i+1][j]){
                    cnt ++;
                    answer = Math.max(cnt, answer);
                }else{
                    cnt = 1;
                }
            }
        }
    }


}
