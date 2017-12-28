package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ - GDCOFTI - Greatest Common Divisor Of Three Integers
 * 
 * @author Geoff Dec 28, 2017
 */
class GDCOFTI
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new GDCOFTI().solve();
    }

    void solve() throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputVals[] = new int[3];
        inputVals[0] = Integer.parseInt(br.readLine());
        inputVals[1] = Integer.parseInt(br.readLine());
        inputVals[2] = Integer.parseInt(br.readLine());

        new PrintWriter(System.out, true).println(gcd(inputVals));
    }

    /**
     * finds GCD of the numbers in the input array
     * 
     * @param numbers
     *            - array of int values
     * @return - gcd of all numbers
     */
    int gcd(int[] numbers)
    {
        int gcd = 1;
        int index = 2;
        if (numbers.length == 1)
        {
            gcd = numbers[1];
        }
        if (numbers.length > 1)
        {
            gcd = euclidGcd(numbers[0], numbers[1]);
        }
        while (index < numbers.length)
        {
            gcd = euclidGcd(gcd, numbers[index]);
            index++;
        }
        return gcd;
    }

    /**
     * Euclid's algorithm
     * 
     * @param a
     * @param b
     * @return - Greatest common divisor of the two inputs
     */
    int euclidGcd(int a, int b)
    {
        int temp = 0;
        while (b != 0)
        {
            temp = b;
            b = a % b;
            a = temp;
        }
        a = a < 0 ? a * (-1) : a;
        return a;
    }

}
