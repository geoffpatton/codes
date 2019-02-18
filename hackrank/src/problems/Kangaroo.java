package problems;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * HackerRank Kangaroo
 * figure out a way to get both kangaroos at the same location at the same time as part of the show.
 * If it is possible, return YES, otherwise return NO.
 * first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
 * second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
 */
public class Kangaroo {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "NO";

        // when first position is behind and faster than the second position
        if (x1 < x2 && v1 > v2) {
            result = doRoosIntersect(v2, x2, v1, x1);
        }
        // when second position is behind and faster than the first position
        else if (x1 > x2 && v1 < v2) {
            result = doRoosIntersect(v1, x1, v2, x2);
        }

        return result;
    }

    /**
     * Checks if the Kangaroos intersect
     * 
     * @param slowSpeed
     * @param slowSpeedPosition
     * @param highSpeed
     * @param higherSpeedPostion
     * @return
     */
    private static String doRoosIntersect(int slowSpeed, int slowSpeedPosition, int highSpeed, int higherSpeedPostion) {
        String result = "NO";
        while (true) {
            slowSpeedPosition += slowSpeed;
            higherSpeedPostion += highSpeed;

            if (slowSpeedPosition == higherSpeedPostion) {
                result = "YES";
                break;
            }
            else if (slowSpeedPosition < higherSpeedPostion) {
                result = "NO";
                break;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");
        int x1 = Integer.parseInt(x1V1X2V2[0]);
        int v1 = Integer.parseInt(x1V1X2V2[1]);
        int x2 = Integer.parseInt(x1V1X2V2[2]);
        int v2 = Integer.parseInt(x1V1X2V2[3]);

        bufferedWriter.write(kangaroo(x1, v1, x2, v2));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
