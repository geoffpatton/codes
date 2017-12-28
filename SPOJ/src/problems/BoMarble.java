package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Spoj - BOMARBLE - D - Playing with Marbles
 * 
 * @author Geoff Dec 28, 2017
 */
class BoMarble
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new BoMarble().solve();
    }

    void solve() throws NumberFormatException, IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        while (true)
        {
            int num = Integer.parseInt(in.readLine());
            if (num == 0)
            {
                break;
            }
            // formula to figue out number of pentagons
            out.println(5 * num + (3 * num * (num - 1) / 2) - (num - 1));
        }
    }
}
