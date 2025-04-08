import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a,b;
        String s;

        for(int i=0;i<n;i++){
            s = sc.next();
            String numbers[] = s.split(",");

            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);

            System.out.println(a+b);
        }

    }
}
