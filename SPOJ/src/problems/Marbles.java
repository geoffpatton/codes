package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 7/1/2015.
 * Marbles
 * TLE
 */
public class Marbles {
    public static void main(String[] args) throws IOException {
        new Marbles().run();
    }
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        int testCases = Integer.parseInt(in.nextToken());

        for (int i = 0; i < testCases; i++) {
            while ( ! in.hasMoreTokens() ) {
                in = new StringTokenizer(br.readLine() );
            }
            int x = Integer.parseInt(in.nextToken());
            int y = Integer.parseInt(in.nextToken());
            System.out.println(getPossibilities(x - 1, y - 1));
        }

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
