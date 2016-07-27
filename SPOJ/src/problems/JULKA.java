package problems;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by geoffpatton on 8/10/2015.
 */
public class JULKA {
    public static void main(String[] args){
        new JULKA().run();
    }
    private void run(){
        Scanner in = new Scanner(System.in);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger alpha, beta, gamma;
        while (in.hasNextBigInteger()) {
            alpha = in.nextBigInteger();
            beta = in.nextBigInteger();
            gamma = alpha.add(beta).divide(two);
            System.out.println(gamma);
            System.out.println(gamma.subtract(beta));
        }
    }
}
