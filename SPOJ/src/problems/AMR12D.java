package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Spoj - AMR12D - The Mirror of Galadriel
 * 
 * @author Geoff Dec 28, 2017
 *
 */
class AMR12D
{

    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new AMR12D().solve();
    }

    void solve() throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0)
        {
            String answer = "NO";
            String input = (br.readLine());
            String rev = new StringBuilder(input).reverse().toString();
            if (input.equals(rev))
            {
                answer = "YES";
            }
            out.println(answer);
        }
    }
}
