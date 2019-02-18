package problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Hacker Rank - Divisible Sum Pairs
 * Find and print the number of pairs (i,j) that are divisible by k.
 */
public class DivisibleSumPairs {

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;

        for (int i = 0; i < n; ++i) {
            for (int y = i + 1; y < n; ++y) {
                if ((ar[i] + ar[y]) % k == 0) {
                    ++result;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(arItems[i]);
        }

        bufferedWriter.write(String.valueOf(divisibleSumPairs(n, k, ar)));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
