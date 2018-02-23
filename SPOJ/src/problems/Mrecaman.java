package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

class Mrecaman
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out, true);

    private static final int MAX_LENGTH = 500001;
    private static int[] a = new int[MAX_LENGTH];
    private static Set<Integer> seqSet = new HashSet<Integer>(MAX_LENGTH);

    public static void main(String[] args) throws IOException
    {
        new Mrecaman().solve();
    }

    private void solve() throws IOException
    {
        populateSet();
        int m = Integer.parseInt(br.readLine());
        while (m != -1)
        {
            out.println(a[m]);
            m = Integer.parseInt(br.readLine());
        }
    }

    private void populateSet()
    {
        int lastVal = 0;
        for (int i = 1; i <= 500000; i++)
        {
            if (lastVal - i > 0 && !seqSet.contains(lastVal - i))
            {
                lastVal -= i;
            }
            else
            {
                lastVal += i;
            }
            a[i] = lastVal;
            seqSet.add(lastVal);
        }
    }
}
