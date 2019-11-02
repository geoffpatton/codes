package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SPOJ - EC_CONB - Even Numbers Input
 * 
 * --Input-- In the first line contains the value of N. This integer is followed
 * by N lines, every one with a positive integer ai (1 <= ai <= 10^7).
 * 
 * --Output-- The output will contain N lines, the numbers that are on the
 * blackboard after the conversion process.
 * 
 * @author Geoff
 *
 */
class EC_CONB {
    public static void main(String[] args) throws IOException {
        new EC_CONB().run();
    }

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            Integer num = Integer.parseInt(br.readLine());
            // if odd print
            if (num % 2 != 0) {
                System.out.println(num);
            } else {
                // flip bits of the value
                System.out.println(getReverse(num));
            }
        }
    }

    /**
     * Converts the integer input to binary, then flips the bits, then converts the
     * flipped bits back to an Integer
     * 
     * @param val
     * @return
     */
    Integer getReverse(Integer val) {
        return Integer.parseInt(new StringBuilder(Integer.toBinaryString(val)).reverse().toString(), 2);
    }
}
