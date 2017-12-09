package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CPCRC1C - Sum of Digits
 * 
 * --Input- Two space-separated integers 0 <= a <= b <= 109. Program terminates
 * if a and b are -1.
 * 
 * --Output - The sum of the digits of numbers a through b.
 * 
 * @author Geoff
 */
class CPCRC1C
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        new CPCRC1C().run();
    }

    void run() throws IOException
    {
        while (true)
        {
            String[] line = br.readLine().split(" ");
            int num1 = Integer.parseInt(line[0]), num2 = Integer.parseInt(line[1]);

            if (num1 == -1)
                break;

            long sum1 = calculate(num1 - 1), sum2 = calculate(num2);
            System.out.println(sum2 - sum1);
        }
    }

    long calculate(long val)
    {
        if (val <= 0)
            return 0;
        long div = val / 10, mod = val % 10;

        return 45L * div + 10 * calculate(div - 1) + mod * (mod + 1) / 2 + sumUp(div) * (mod + 1);
    }

    int sumUp(long num)
    {
        int retval = 0;
        while (num > 0)
        {
            retval += num % 10;
            num /= 10;
        }
        return retval;
    }

}
