import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] dir = {0,1,2,3}; //서, 북, 동, 남
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String str = br.readLine();
            int x = 0; int y = 0; //시작 지점
            int curDir = 1; //시작 방향 : 북
            int xMax=0; int xMin=0; int yMax=0; int yMin=0;

            for(char direction : str.toCharArray()){
                if(direction == 'F'){
                    switch(curDir) {
                        case 1: y++; break;
                        case 2: x++; break;
                        case 3: y--; break;
                        case 0: x--; break;
                        default: break;
                    }
                }else if(direction == 'B'){
                    switch(curDir) {
                        case 1: y--; break;
                        case 2: x--; break;
                        case 3: y++; break;
                        case 0: x++; break;
                        default: break;
                    }
                }else if(direction == 'L'){
                    curDir = (curDir+3)%4;
                }else if(direction == 'R'){
                    curDir = (curDir+1)%4;
                }
                xMax = Math.max(xMax,x);
                xMin = Math.min(xMin,x);
                yMax = Math.max(yMax,y);
                yMin = Math.min(yMin,y);
            }
            System.out.println((xMax-xMin)*(yMax-yMin));
        }
    }
}
