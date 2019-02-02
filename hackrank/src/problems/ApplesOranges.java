package problems;

import java.util.Scanner;

/**
 * Hacker rank Apples and oranges problem https://www.hackerrank.com/challenges/apple-and-orange/problem
 * 
 * @author Geoff Feb 2, 2019
 *
 */
public class ApplesOranges {

    /**
     * Print two integers on two different lines:
     * The first integer: the number of apples that fall on Sam's house.
     * The second integer: the number of oranges that fall on Sam's house.
     * 
     * @param s integer, starting point of Sam's house location.
     * @param t integer, ending location of Sam's house location.
     * @param a integer, location of the Apple tree.
     * @param b integer, location of the Orange tree.
     * @param apples integer array, distances at which each apple falls from the tree.
     * @param oranges integer array, distances at which each orange falls from the tree.
     */
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int appleCount = 0, orangeCount = 0;

        // calculate amount of apples on Sam's house
        final int appLen = apples.length;
        for (int i = 0; i < appLen; i++) {
            int appLoc = apples[i] + a;
            if (appLoc >= s && appLoc <= t) {
                appleCount++;
            }
        }

        // calculate amount of oranges on Sam's house
        final int orangeLen = oranges.length;
        for (int i = 0; i < orangeLen; i++) {
            int orangeLoc = oranges[i] + b;
            if (orangeLoc >= s && orangeLoc <= t) {
                orangeCount++;
            }
        }

        // print out counts
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");
        int s = Integer.parseInt(st[0]);
        int t = Integer.parseInt(st[1]);
        String[] ab = scanner.nextLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[] apples = new int[m];
        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];
        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);
        scanner.close();
    }

}
