package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 8/10/2015.
 */
public class ACPC10A {
    public static void main(String[] args) throws IOException {
        new ACPC10A().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // for output

        while (true) {
            StringTokenizer in = new StringTokenizer(br.readLine());
            long a = Long.parseLong(in.nextToken());
            long b = Long.parseLong(in.nextToken());
            long c = Long.parseLong(in.nextToken());
            if (a == b && a == c && a == 0) {
                break; // break out of while loop
            }

            if (b == (a + c) * 1.0 / 2) { // check for AP

                sb.append("AP " + (c + c - b) + "\n");// this adds all output to sb then prints when finished

            } else { // else GP

                sb.append("GP " + (c * (c / b)) + "\n");
            }
        }// end while loop, execute next line on break
        System.out.print(sb);	// prints out all output in one go
    }
}
