package problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by geoffpatton on 8/10/2015.
 */
public class CANDY {
    public static void main(String[] args) {
        new CANDY().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        int blocks = in.nextInt();
        int candyPacks[];
        int i, sum, numInEach, moves;
        while (blocks != -1) {
            candyPacks = new int[blocks];
            i = sum = 0;
            while (blocks-- > 0) {
                candyPacks[i] = in.nextInt();
                sum += candyPacks[i];
                i++;
            }
            if (sum % candyPacks.length != 0) {
                System.out.println(-1);
            } else {
                moves = 0;
                numInEach = sum / candyPacks.length;
                Arrays.sort(candyPacks);
                for (int j = candyPacks.length - 1; candyPacks[j] > numInEach; j--) {
                    moves += (candyPacks[j] - numInEach);
                }
                System.out.println(moves);
            }
            blocks = in.nextInt();
        }
    }
}
