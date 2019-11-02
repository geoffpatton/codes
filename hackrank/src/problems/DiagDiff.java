package problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Given a square matrix, calculate the absolute difference
 * between the sums of its diagonals.
 */
public class DiagDiff {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        int leftDiag = 0, rightDiag = 0;
        final int len = arr.length;

        for (int i = 0; i < len; ++i) {
            leftDiag += arr[i][i];
            rightDiag += arr[i][len - 1 - i];
        }

        // return absolute value
        return Math.abs(leftDiag - rightDiag);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
