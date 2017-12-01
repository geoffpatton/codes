package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SPOJ - BUSYMAN
 * 
 * Incomplete
 * 
 * @author Geoff
 *
 */
class BusyMan
{

    public static void main(String[] args) throws IOException
    {
        new BusyMan().run();
    }

    private void run() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(in.nextToken());

        while (t-- > 0)
        {
            in = new StringTokenizer(br.readLine());
            int activities = Integer.parseInt(in.nextToken());
            int times[][] = new int[activities][2];
            for (int i = 0; i < activities; i++)
            {
                in = new StringTokenizer(br.readLine());
                times[i][0] = Integer.parseInt(in.nextToken());
                times[i][1] = Integer.parseInt(in.nextToken());
            }
        }
    }
}
