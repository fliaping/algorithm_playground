import java.util.Scanner;

/**
 * Created by Payne on 3/28/16.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            int n,b;
            n = sc.nextInt();
            b = sc.nextInt();

            int x = n/2;
            if(x==b) x++;
            System.out.println(x);
        }
    }


}
