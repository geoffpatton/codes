/**
 * Created by geoffpatton on 7/6/2015.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class INTEST {

    public static void main(String[] args) throws IOException {

        new INTEST().run();
    }

    public void run() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");

        int[] numbers = new int[Integer.parseInt(input[0])];
        int divisor = Integer.parseInt(input[1]);

        int count = 0;
        for (int x = 0; x < numbers.length; x++) {
            if ((Integer.parseInt(in.readLine()) % divisor) == 0) {
                count++;
            }
        }
        System.out.println(count);
        in.close();
    }
}
