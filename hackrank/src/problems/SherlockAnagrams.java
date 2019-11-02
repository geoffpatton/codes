package problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Sherlock and Anagrams
 * Hackerrank
 */
public class SherlockAnagrams {

    public static void main(String[] args) {
        new SherlockAnagrams().solve();
    }

    /**
     * return an integer that represents the number of anagrammatic pairs of substrings
     */
    int sherlockAndAnagrams(String s) {

        int anagramCounter = 0;
        for (Map.Entry<String, Integer> e : generateAnagramCounts(s).entrySet()) {
            int count = e.getValue();
            if (count > 1) {
                int sum = 0;
                for (int i = 1; i < count; i++) {
                    sum += i;
                }
                anagramCounter += sum;
            }
        }
        return anagramCounter;
    }

    Map<String, Integer> generateAnagramCounts(String word) {
        Map<String, Integer> countMap = new HashMap<>();

        for (int start = 0; start < word.length(); start++) {
            for (int end = start + 1; end <= word.length(); end++) {
                char[] charArr = word.substring(start, end).toCharArray();
                Arrays.sort(charArr);
                String sortWord = new String(charArr);
                countMap.put(sortWord, countMap.getOrDefault(sortWord, 0) + 1);
            }
        }

        return countMap;
    }

    private void solve() {
        final Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int testCases = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int testNum = 0; testNum < testCases; ++testNum) {
                String s = scanner.nextLine();

                int result = sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }
}
