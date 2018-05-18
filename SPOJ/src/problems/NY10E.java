package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Geoff May 18, 2018
 * 
 * SPOJ - NY10E - Non-Decreasing Digits
 */
class NY10E
{
    private static final int MAX = 65;
    private static final String ANSW_FMT = "%d %d";
    private static final String SPACE = " ";

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new NY10E().solve();
    }

    private void solve() throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);

        int testCases = Integer.parseInt(br.readLine());
        long dp[][] = new long[MAX][11];

        for (int i = 0; i < MAX; ++i)
        {
            for (int j = 1; j < 11; j++)
            {
                if (i == 0)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        for (int i = 1; i <= testCases; ++i)
        {
            String s[] = br.readLine().split(SPACE);
            out.println(String.format(ANSW_FMT, i, dp[Integer.parseInt(s[1])][10]));
        }
    }
}
