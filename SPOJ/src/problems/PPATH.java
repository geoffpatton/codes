package problems;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author general - SPOJ - PPATH - Prime Path
 * 
 *
 *         Input
 * 
 *         One line with a positive number: the number of test cases (at most
 *         100). Then for each test case, one line with two numbers separated by
 *         a blank. Both numbers are four-digit primes (without leading zeros).
 * 
 *         Output
 * 
 *         One line for each case, either with a number stating the minimal cost
 *         or containing the word Impossible.
 *
 */

public class PPATH {

    static boolean[] primeArray = new boolean[10000];

    public static void main(String[] args) throws IOException {
        new PPATH().run();
    }

    public void run() throws IOException {
        InputReader input = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Arrays.fill(primeArray, true);
        primeArray[0] = primeArray[1] = false;

        for (int i = 2; i < primeArray.length; ++i) {
            if (primeArray[i]) {
                for (int j = 2; i * j < primeArray.length; ++j) {
                    primeArray[i * j] = false;
                }
            }
        }

        int T = input.iscan();

        while (T-- > 0) {
            int firstNum = input.iscan();
            int secondNum = input.iscan();
            int[] cache = new int[10000];
            Arrays.fill(cache, Integer.MAX_VALUE);
            cache[firstNum] = 0;

            Queue<Integer> numQueue = new ArrayDeque<Integer>();
            List<Integer> next;
            numQueue.offer(firstNum);

            while (!numQueue.isEmpty()) {
                int curr = numQueue.poll();
                next = next(curr);

                for (int i = 0; i < next.size(); ++i) {
                    if (cache[next.get(i)] > cache[curr] + 1) {
                        cache[next.get(i)] = cache[curr] + 1;
                        numQueue.offer(next.get(i));
                    }
                }
            }
            out.println(cache[secondNum]);
        }
        out.close();
    }

    public List<Integer> next(int n) {
        List<Integer> next = new ArrayList<Integer>();
        char[] arr = new char[4];

        int tmp = n;

        for (int pos = 3; pos >= 0 && tmp > 0; --pos) {
            arr[pos] = Character.forDigit(tmp % 10, 10);
            tmp /= 10;
        }

        char ctmp;
        int p = 0;

        for (int i = 0; i < 4; ++i) {
            ctmp = arr[i];

            for (int d = 0; d < 10; ++d) {
                arr[i] = Character.forDigit(d, 10);
                p = Character.getNumericValue(arr[3]) + Character.getNumericValue(arr[2]) * 10
                    + Character.getNumericValue(arr[1]) * 100 + Character.getNumericValue(arr[0]) * 1000;

                if (p != n && p >= 1000 && primeArray[p])
                    next.add(p);
            }

            arr[i] = ctmp;
        }

        return next;
    }

    private class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int cscan() throws IOException {
            // if (numChars == -1) throw new InputMismatchException ();

            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);

            }

            return buf[curChar++];
        }

        public int iscan() throws IOException {
            int c = cscan(), sgn = 1;
            while (space(c))
                c = cscan();

            if (c == '-') {
                sgn = -1;
                c = cscan();
            }

            int res = 0;

            do {

                res = (res << 1) + (res << 3);
                res += c - '0';

                c = cscan();
            } while (!space(c));

            return res * sgn;
        }

        public boolean space(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

}
