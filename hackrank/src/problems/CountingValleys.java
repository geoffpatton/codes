package problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Counting Valleys problem from Hackerrank
 * Input:
 * The first line contains an integer n, the number of steps in Gary's hike.
 * The second line contains a single string s, of n characters that describe his path.
 */
class CountingValleys {

    public static void main(String[] args) {
        new CountingValleys().solve();
    }

    /**
     * It must return an integer that denotes the number of valleys Gary traversed.
     * 
     * @param n number of steps
     * @param s String describing the path U for uphill, D for downhill
     * @return an integer that denotes the number of valleys Gary traversed.
     */
    int countingValleys(int n, String s) {
        int valleyCount = 0;
        int level = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'U') {
                ++level;
                if (level == 0) {
                    ++valleyCount;
                }
            } else {
                --level;
            }
        }
        return valleyCount;
    }

    private void solve() {
        final Scanner scanner = new Scanner(System.in);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
            int n = scanner.nextInt(); // number of steps
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            bufferedWriter.write(String.valueOf(countingValleys(n, scanner.nextLine())));
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }

}
