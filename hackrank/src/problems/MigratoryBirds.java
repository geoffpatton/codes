package problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hacker Rank MigratoryBirds
 * Return the lowest type number of the most frequently sighted bird.
 */
public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int n, List<Integer> arr) {

        // array holding the counts for the different types
        int[] typeCount = new int[5];

        // populate type count array
        for (int i = 0; i < n; ++i) {
            int type = arr.get(i) - 1;
            typeCount[type] += 1;
        }

        // iterate over type count array and find the first most freq type
        int maxCount = 0, result = 0;
        for (int i = 0; i < 5; ++i) {
            if (typeCount[i] > maxCount) {
                maxCount = typeCount[i];
                result = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        bufferedWriter.write(String.valueOf(migratoryBirds(arrCount, arr)));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
