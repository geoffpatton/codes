package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ - PIGBANK - Piggy-Bank
 * 
 * @author Geoff
 *
 */
class PigBank
{

    private static final int MAX_VAL = 1000000000;
    private static final String IMPOSSIBLE = "This is impossible.";
    private static final String MONEY_OUTPUT = "The minimum amount of money in the piggy-bank is %d.%n";

    public static void main(String[] args) throws IOException
    {
        new PigBank().run();
    }

    private void run() throws NumberFormatException, IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        int totalWeight, variousCoins, value, weight;
        int[] min;
        while (testCases-- > 0)
        {
            st = new StringTokenizer(bf.readLine());
            totalWeight = -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            min = new int[totalWeight + 1];
            Arrays.fill(min, MAX_VAL);
            min[0] = 0;
            variousCoins = Integer.parseInt(bf.readLine());
            for (int i = 0; i < variousCoins; i++)
            {
                st = new StringTokenizer(bf.readLine());
                value = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                for (int j = weight; j <= totalWeight; j++)
                {
                    if (min[j] > min[j - weight] + value)
                    {
                        min[j] = min[j - weight] + value;
                    }
                }
            }

            if (min[totalWeight] == MAX_VAL)
            {
                System.out.println(IMPOSSIBLE);
            } else
            {
                System.out.format(MONEY_OUTPUT, min[totalWeight]);
            }
            System.out.flush();
        }
        System.exit(0);
    }
}