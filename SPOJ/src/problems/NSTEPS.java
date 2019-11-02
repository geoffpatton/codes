package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 8/8/15.
 */
public class NSTEPS {
    public static void main(String[] args) throws IOException {
        new NSTEPS().run();

    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        int numTestCases = Integer.parseInt(in.nextToken());

        for (int i = 0; i < numTestCases; i++) {

            while (in.hasMoreElements() == false) {
                in = new StringTokenizer(br.readLine());
            }

            int x = Integer.parseInt(in.nextToken());
            int y = Integer.parseInt(in.nextToken());

            if (x == y || (x - y == 2)) {
                if (x % 2 == 0) {
                    System.out.println(x + y);
                } else {
                    System.out.println(x + y - 1);
                }
            } else {
                System.out.println("No Number");
            }
        }
    }
}
