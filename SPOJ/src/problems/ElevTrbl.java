package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ELEVTRBL - Elevator Trouble
 * 
 * Input
 * The input will consist of one line, namely f s g u d, where 1 <= s, g <= f <=
 * 1000000 and 0 <= u, d <= 1000000. The floors are one-indexed, i.e. if there
 * are 10 stories, s and g be in [1; 10].
 * 
 * Output
 * You must reply with the minimum numbers of pushes you must make in order to
 * get from s to g, or output "use the stairs" if it is impossible given the con
 * guration of the elevator.
 * 
 * @author Geoff
 */
class ElevTrbl
{
    public static void main(String[] args) throws IOException
    {
        new ElevTrbl().run();
    }

    void run() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int floors = Integer.parseInt(line[0]), start = Integer.parseInt(line[1]), goal = Integer.parseInt(line[2]),
                up = Integer.parseInt(line[3]), down = Integer.parseInt(line[4]);
        int result = solve(floors, start, goal, up, down);
        System.out.println((result >= 0) ? result : "use the stairs");
    }

    int solve(int f, int s, int g, int u, int d)
    {
        int[] count = new int[f + 1];
        boolean[] beenHere = new boolean[f + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        beenHere[s] = true;
        while (!queue.isEmpty())
        {
            int floorNum = queue.poll();
            if (floorNum == g)
                return count[floorNum];
            int curUp = floorNum + u, curDown = floorNum - d;
            if (curUp <= f && !beenHere[curUp])
            {
                beenHere[curUp] = true;
                queue.add(curUp);
                count[curUp] = count[floorNum] + 1;
            }
            if (curDown >= 1 && !beenHere[curDown])
            {
                beenHere[curDown] = true;
                queue.add(curDown);
                count[curDown] = count[floorNum] + 1;
            }
        }
        return -1;
    }
}
