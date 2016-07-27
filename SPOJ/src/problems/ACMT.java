package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 8/24/2015.
 */
public class ACMT {
    public static void main(String[] args) throws IOException{
        new ACMT().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(in.nextToken());

        while (t-->0){
            in = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(in.nextToken());
            int n = Integer.parseInt(in.nextToken());

            if(e == 0 || n == 0) {
                System.out.println(0);
                continue;
            }

            int max = Math.max(e,n);
            int min = e + n - max;
            int numTeams = 0;

            if (min > max/2){
                numTeams = (min+max)/3;
            }else{
                numTeams = min;
            }
            System.out.println(numTeams);
        }
    }
}
