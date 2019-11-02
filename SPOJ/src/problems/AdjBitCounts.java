package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;

/**
 * Created by tua26762 on 6/23/2015.
 */
public class AdjBitCounts {
    static BufferedReader reader;
    static StringTokenizer tok;

    public static void main(String[] args) {
        /*
         * Reader.init( System.in );
         * double x = Reader.nextDouble();
         * int n = Reader.nextInt();
         */

        String a = "5";
        String b = "2";

        int alpha = Integer.parseInt(a);

        String alpha1 = Integer.toBinaryString(alpha);

        int alpha2 = Integer.valueOf(alpha);

        // byte alphaByte = Byte.parseByte(binary, a);

        System.out.println(alpha1);

    }

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tok = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while (!tok.hasMoreTokens()) {
            // TODO add check for eof if necessary
            tok = new StringTokenizer(reader.readLine());
        }
        return tok.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
