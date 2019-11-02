package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * SPOJ - CRAN02 - Roommate Agreement
 * 
 * --Input--
 * First line contains T - number of test cases
 * Second line contains n - the number of elements in a particular test case.
 * Next line contain n elements, ai (1 <= i <= n) separated by spaces.
 * 
 * --Output--
 * The number of such sequences whose sum if zero.
 * 
 * @author Geoff
 */
class Cran02 {
    public static void main(String[] args) throws IOException {
        new Cran02().run();
    }

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            int testNumbers = Integer.parseInt(br.readLine()), sum = 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(0, 1);
            long totalSeq = 0;
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < testNumbers; i++) {
                int curVal = Integer.parseInt(line[i]);
                sum += curVal;
                Integer seq = map.get(sum);
                if (seq == null)
                    seq = 0;
                totalSeq += seq;
                map.put(sum, seq + 1);
            }
            System.out.println(totalSeq);
        }
    }
}
