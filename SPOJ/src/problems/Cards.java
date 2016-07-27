package problems;
import java.util.Scanner;

/**
 * Created by geoffpatton on 7/30/2015.
 */
public class Cards {
    public static void main(String[] args){
        new Cards().run();
    }
    private void run(){
        Scanner in = new Scanner(System.in);
        long m = 1000007;
        int t = in.nextInt();
        while(t-->0){
            long n = in.nextLong();
            long ans =0;
            for(long i = n; i>0; i--){
                ans += (i*2) +(i-1);
            }
            System.out.println(ans%m);
        }
    }
}
