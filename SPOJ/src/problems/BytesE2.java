package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * SPOJ BYTESE2 - The Great Ball
 * 
 * @author Geoff Dec 23, 2017
 */
class BytesE2
{
    public static void main(String[] args) throws IOException
    {
        new BytesE2().run();
    }

    void run() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);

        // test Cases
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0)
        {
            // number of entries and exits recorded
            int n = Integer.parseInt(br.readLine());
            int maxDancers = 0;
            int[] entries = new int[n];
            int[] exits = new int[n];

            for (int i = 0; i < n; i++)
            {
                String[] line = br.readLine().split(" ");
                entries[i] = Integer.parseInt(line[0]);
                exits[i] = Integer.parseInt(line[1]);
            }

            // sort arrays
            Arrays.sort(entries, 0, n);
            Arrays.sort(exits, 0, n);

            int totalCount = 0;
            for (int entryCount = 0, exitCount = 0; entryCount < n && exitCount < n;)
            {
                if (entries[entryCount] < exits[exitCount])
                {
                    totalCount++;
                    entryCount++;
                }
                else if (entries[entryCount] > exits[exitCount])
                {
                    totalCount--;
                    exitCount++;
                }

                if (totalCount > maxDancers)
                {
                    maxDancers = totalCount;
                }
            }
            out.println(maxDancers);
        }
    }
}
