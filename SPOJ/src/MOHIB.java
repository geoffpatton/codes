import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 7/29/2015.
 */
public class MOHIB {
    public static void main(String[] args) throws IOException{
        new MOHIB().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(in.nextToken());

        while(T-->0)
        {
            in = new StringTokenizer(br.readLine());
            while(!in.hasMoreTokens()){
                in = new StringTokenizer(br.readLine());
            }
            int x = Integer.parseInt(in.nextToken());
            int avg =Integer.parseInt(in.nextToken());

            int ans = avg*avg - x*x - 3*x + 3*avg;
            ans = ans / 2;
            System.out.println(ans);

        }
    }
}
