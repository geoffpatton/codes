import java.math.BigInteger;
import java.util.Scanner;
/**
 * Created by geoffpatton on 7/1/2015.
 * Marbles
 * TLE
 */
public class Marbles {
    public static void main(String[] args) {
        new Marbles().run();
    }
    public void run(){
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0 ; i < testCases ; i ++ )
        {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(getPossibilities(x-1,y-1));
        }
        in.close();
    }
    public BigInteger getPossibilities (int a, int b) {
        BigInteger result = new BigInteger("1");
        for (int i = a; i > a-b; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        for (int i = b; i > 0 ; i--) {
            result = result.divide(BigInteger.valueOf(i));
        }
        return result;
    }
}
