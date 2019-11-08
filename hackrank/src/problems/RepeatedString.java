package problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Repeated String Hackerrank Challenge
 */
class RepeatedString {

    /**
     * return an integer representing the number of occurrences of a in the prefix of length n
     * in the infinitely repeating string.
     */
    long repeatedString(String s, long n) {
        // figure out the how many a's will occur for the length n
        long total = getACount(s) * (n / s.length());
        // find out how many letters are remaining
        long remainder = n % s.length();

        if (remainder > 0) { // add remaining a's to total
            total += getACount(s.substring(0, (int) remainder));
        }

        return total;
    }

    /** Counts the number of letter 'a' in the given String */
    private long getACount(String s) {
        long aCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') {
                ++aCount;
            }
        }
        return aCount;
    }

    public static void main(String[] args) {
        new RepeatedString().solve();
    }

    private void solve() {
        final Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String s = scanner.nextLine();
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            bufferedWriter.write(String.valueOf(repeatedString(s, n)));
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }
}
