package problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Hacker rank - Day of the Programmer
 * Find the 256th day of the year in Russia
 */
public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        // set the default day to be the 13th of September
        String progDay = "13.09.";

        // check for transition year, the unique case of 1918
        if (year == 1918) {
            progDay = "26.09.";
        }
        // check for Gregorian or Julian calendar leap year when it falls on the 12th
        else if ((year % 400 == 0) || (year % 4 == 0 && (year % 100 != 0 || year < 1918))) {
            progDay = "12.09.";
        }

        // append the year to day and month
        return progDay += year;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bufferedWriter.write(dayOfProgrammer(Integer.parseInt(bufferedReader.readLine().trim())));
        bufferedReader.close();
        bufferedWriter.close();
    }

}
