package problems;

import java.util.Scanner;

/**
 * Created by geoffpatton on 8/10/2015.
 */
public class WILLITST {
    public static void main(String[] args) {
        new WILLITST().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        if (num <= 1L) {
            num = 2L;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        if (num == 1) {
            System.out.println("TAK");
        } else {
            System.out.printf("NIE");
        }
    }
}
