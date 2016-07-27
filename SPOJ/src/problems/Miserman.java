package problems;
import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by tua26762 on 6/24/2015.
 */
public class Miserman {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        StringTokenizer tok = new StringTokenizer(in.readLine());

        int rows = Integer.parseInt(tok.nextToken());
        int columns = Integer.parseInt(tok.nextToken());

        int[] fare = new int[columns+2];       //  add two

        fare[0] = fare[columns+1] = Integer.MAX_VALUE;

        // first row only
        tok = new StringTokenizer(in.readLine());
        for (int j = 1; j <= columns; j++) {
            fare[j] = Integer.parseInt(tok.nextToken());
        }

        // fill DP
        for (int i = 2; i <= rows; i++) {
            int temp1 = fare[0], temp2;
            tok = new StringTokenizer(in.readLine());
            for (int j = 1; j <= columns; j++) {
                temp2 = fare[j];
                fare[j] = Integer.parseInt(tok.nextToken()) + findLeast(temp1, temp2, fare[j + 1]);
                temp1 = temp2;
            }
        }

        // Find the least number at city
        int minFare = Integer.MAX_VALUE;
        for (int j = 1; j <= columns; j++)
            minFare = (minFare > fare[j]) ? fare[j] : minFare;
        out.println(minFare);
        out.flush();
    }

    static int findLeast(int a, int b, int c) {
        if (a <= b) {
            if (a <= c)
                return a;
            return c;
        } else {
            if (b <= c)
                return b;
            return c;
        }
    }


}
