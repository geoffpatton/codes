package problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Hacker Rank - Sock Merchant
 * Return an integer representing the number of matching pairs of socks that are available.
 */
public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Set<Integer> inventory = new HashSet<>();
        int matchingPairs = 0;

        for (int i = 0; i < n; ++i) {
            int sockColor = ar[i];
            // check if 1 sock of that color exists, if it doesn't add it to the set
            if (!inventory.contains(sockColor)) {
                inventory.add(sockColor);
            }
            // when one sock does exist increment matching pairs and remove it from the set
            else {
                ++matchingPairs;
                inventory.remove(sockColor);
            }
        }
        // return number of matching pairs
        return matchingPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(arItems[i]);
        }

        bufferedWriter.write(String.valueOf(sockMerchant(n, ar)));
        bufferedWriter.close();

        scanner.close();
    }
}
