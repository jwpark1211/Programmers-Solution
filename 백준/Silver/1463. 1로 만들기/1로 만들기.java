import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int Numbers[] = new int[1000001];

        Numbers[0] = 0;
        Numbers[1] = 0;
        Numbers[2] = 1;
        Numbers[3] = 1;
        int MIN;

        if(N>=4){
            for(int i=4;i<=N;i++){
                MIN = Integer.MAX_VALUE;
                if(i%2==0){
                    if(MIN>1+Numbers[i/2])
                        MIN = 1+Numbers[i/2];
                }
                if(i%3==0){
                    if(MIN>1+Numbers[i/3])
                        MIN = 1+Numbers[i/3];
                }
                if(MIN>1+Numbers[i-1])
                    MIN = 1+Numbers[i-1];
                Numbers[i] = MIN;
            }
        }

        System.out.println(Numbers[N]);
    }
}
