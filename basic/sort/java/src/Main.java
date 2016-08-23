import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by Payne on 3/28/16.
 */
public class Main {
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true){
            n = sc.nextInt();
            if(n<1 || n > 5842) break;

            if(n > list.size()){
                if(list.size() == 0){
                    list.add(1);
                }
                for (int i = (int) list.get(list.size()-1)+1; list.size() <= n ; i++) {
                    if(ishn(i)) list.add(i);
                }
            }
            String suffix = "th";
            int ll = n%10;
            if (ll==1) suffix = "st";
            if (ll==2) suffix = "nd";
            if (ll==3) suffix = "rd";

            System.out.println("The "+n+suffix+" humble number is "+list.get(n-1)+".");


        }
    }

    public  static  boolean ishn(int x){
        int a[] = {2,3,5,7};
        int i ;
        for (i = 0; i < a.length ; i++) {
            if(x%a[i] == 0) break;
        }
        if(i<a.length){
            int div = x/a[i];
            if(in(div)) return true;
            else return ishn(div);
        }else return false;
    }

    public static boolean in(int x){
        if(x==1 || x == 2 || x==3 || x==5 || x==7) return true;
        else return false;
    }
}
