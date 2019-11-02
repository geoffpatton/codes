package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by geoffpatton on 8/10/2015.
 * not working
 */
public class NAJPWG {
    public static void main(String[] args) throws IOException {
        new NAJPWG().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCases; i++) {

            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            long[] range = new long[n];
            for (int y = 1; y <= n; y++) {
                range[y - 1] = (long) y;

            }
            System.out.println(Arrays.toString(range));
            long result = gcd(range);

            sb.append("Case " + i + ": " + result + "\n");

        }
        System.out.print(sb);
    }

    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long gcd(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
            System.out.println(result);
        }
        return result;
    }
}
