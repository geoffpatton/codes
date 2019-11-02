package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tua26762 on 6/25/2015.
 * SAMER08F - Feynman
 */
public class SumOfSquares {

    public static void main(String[] args) {

        List<Integer> squares = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            squares.add(sc.nextInt());
        }

        for (int run = 0; squares.get(run) != 0; run++) {
            System.out.println(computeSquares(squares.get(run)));
        }
    }

    public static int computeSquares(int n) {
        double a = (n * n * n) / 3d;
        double b = (n * n) / 2d;
        double c = n / 6d;

        double sum = a + b + c;

        sum = Math.round(sum);
        int returnVal = (int) sum;
        return returnVal;
    }

}
