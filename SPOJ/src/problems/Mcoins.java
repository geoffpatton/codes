package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SPOJ - MCOINS - Coins Game
 * @author Geoff Feb 25, 2018
 */
class Mcoins
{

    public Mcoins()
    {
    }

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new Mcoins().solve();
    }

    private void solve() throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);
        int[] valArr = new int[n];

        input = br.readLine().split(" ");

        int maxVal = 0;
        for (int i = 0; i < n; i++)
        {
            valArr[i] = Integer.parseInt(input[i]);
            if (valArr[i] > maxVal)
            {
                maxVal = valArr[i];
            }
        }

        int[] coins = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; ++i)
        {
            if (coins[i - 1] == 0
                    || (i >= k && coins[i - k] == 0)
                    || (i >= l && coins[i - l] == 0))
            {
                coins[i] = 1;
            }
        }
        for (int i = 0; i < n; ++i)
        {
            System.out.print(coins[valArr[i]] == 1 ? "A" : "B");
        }
    }

}
