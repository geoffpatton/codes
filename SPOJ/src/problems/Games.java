package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ - GAMES - HOW MANY GAMES
 * 
 * Input:
 * 
 * The first line consists of an integer t, the number of test cases. Each test
 * case consists of a single Rational Number which represents the average score
 * of the player.
 * 
 * Output:
 * 
 * For each test case, find the minimum number of matches the player should have
 * played to achieve that average.
 * 
 * @author Geoff Dec 23, 2017
 */
class Games
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new Games().run();
    }

    void run() throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);

        // test Cases
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0)
        {
            String average = br.readLine();
            // if average doesn't contain decimal, answer is one game
            if (!average.contains("."))
            {
                out.println(1);
            }
            else
            {
                // if average does contain a decimal, all we car about are the numbers
                // after that decimal point to determine the lowest counting number
                String mantissa = average.substring(average.indexOf('.') + 1);
                int decValue = Integer.parseInt(mantissa);
                int powerOfDecLength = (int) Math.pow(10, mantissa.length());
                int powVal = powerOfDecLength;
                while (powVal % decValue != 0)
                {
                    powVal = powVal + powerOfDecLength;
                }
                out.println(powVal / decValue);
            }
        }
    }
}
