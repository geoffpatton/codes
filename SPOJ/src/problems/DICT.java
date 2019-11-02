package problems;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by geoffpatton on 9/30/2015.
 * Wrong Answer at test case 5
 */
public class DICT {
    public static void main(String[] args) {
        new DICT().run();
    }

    private void run() {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int caseNumber = 1;

        while (caseNumber <= 2) {

            int wordCount = in.nextInt();

            String[] words = new String[wordCount];

            for (int i = 0; i < wordCount; i++) {
                words[i] = in.next();
            }
            // List<String> output = new ArrayList<>();
            Set<String> output = new TreeSet<>();

            String prefix = words[0];
            int len = prefix.length();

            if (prefix == null || len == 0) {
                System.out.println("Case #" + caseNumber + ":");
                System.out.println("No match.");
                continue;
            }

            for (int j = 1; j < wordCount; j++) {
                if (len > words[j].length()) {
                    continue;
                }

                if (prefix.equals(words[j].substring(0, len))) {
                    output.add(words[j]);
                }
            }

            System.out.println("Case #" + caseNumber + ":");

            if (output.isEmpty()) {
                System.out.println("No match.");
            } else {
                for (String s : output) {
                    System.out.println(s);
                }
            }

            caseNumber++;
        }
    }
}
