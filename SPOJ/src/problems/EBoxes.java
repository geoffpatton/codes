package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Spoj - EBOXES - Empty Boxes
 * 
 * @author Geoff Dec 28, 2017
 *
 */
class EBoxes
{

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new EBoxes().solve();
    }

    void solve() throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0)
        {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int p = Integer.parseInt(line[2]);
            int f = Integer.parseInt(line[3]);

            f = f * k;
            k--;
            f = f - n;
            f = f / k;

            out.println(f);
        }
    }
}
