package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ZCR - Zen And His Crush
 * 
 * @author Geoff Dec 23, 2017
 */
class ZCR
{
    final int maxNum = 1001;

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new ZCR().run();
    }

    void run() throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);

        double dp[][] = new double[maxNum][maxNum];

        // test Cases
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- != 0)
        {
            String[] line = br.readLine().split(" ");
            int coins = Integer.parseInt(line[0]);
            int headCount = Integer.parseInt(line[1]);

            for (int i = 1; i < coins; i++)
            {
                for (int j = 0; j < coins; j++)
                {
                    dp[i][j] = -1.0;
                }
            }
            dp[0][0] = 1.;

            line = br.readLine().split(" ");

            for (int i = 1; i <= coins; i++)
            {
                double probVal = Double.parseDouble(line[i - 1]);
                dp[i][0] = dp[i - 1][0] * (1 - probVal);
                for (int j = 1; j <= i; j++)
                {
                    dp[i][j] = dp[i - 1][j - 1] * probVal + dp[i - 1][j] * (1 - probVal);
                }
            }
            out.println(String.format("%.10f", dp[coins][headCount]));
        }
    }
}
