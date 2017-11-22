package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * SPOJ D-query
 * 
 * Given a sequence of n numbers a1, a2, ..., an and a number of d-queries. A
 * d-query is a pair (i, j) (1 ≤ i ≤ j ≤ n). For each d-query (i, j), you have
 * to return the number of distinct elements in the subsequence ai, ai+1,.., aj.
 * 
 * Currently TLE
 * 
 * @author Geoff
 *
 */
class Dquery
{
    public static void main(String[] args) throws IOException
    {
        new Dquery().run();
    }

    private void run() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // amount of numbers in sequence
        int numberSize = Integer.parseInt(br.readLine());

        // setup array to store the numbers in the sequence
        int[] seqArray = new int[numberSize];

        String tempArray[] = br.readLine().split(" ");

        // populate sequence array
        for (int i = 0; i < numberSize; i++)
        {
            seqArray[i] = Integer.parseInt(tempArray[i]);
        }

        // amount of queries to process
        int dQuerySize = Integer.parseInt(br.readLine());

        int[] outputArray = new int[dQuerySize];

        // loop the amount queries
        for (int queryNum = 0; queryNum < dQuerySize; queryNum++)
        {
            tempArray = br.readLine().split(" ");
            int firstVal = Integer.parseInt(tempArray[0]) - 1;
            int secondVal = Integer.parseInt(tempArray[1]) - 1;

            Set<Integer> distinctValueSet = new HashSet<Integer>();

            // populate set with values between the the sequence
            for (int seqNum = firstVal; seqNum <= secondVal; seqNum++)
            {
                distinctValueSet.add(seqArray[seqNum]);
            }

            outputArray[queryNum] = distinctValueSet.size();
        }

        // print out all values in output array
        for (int outputVal : outputArray)
        {
            System.out.println(outputVal);
        }
    }
}
