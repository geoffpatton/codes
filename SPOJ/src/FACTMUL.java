import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by geoffpatton on 9/22/2015.
 */
public class FACTMUL {
    public static void main(String[] args) throws IOException{
        new FACTMUL().run();
    }
    private void run() throws IOException{
        long mod = 109546051211L;
        long factorial[] = new long[10000003];
        factorial[1]=1;
        factorial[2]=2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=3; i<=n; i++)
        {
            factorial[i]=(factorial[i-1] * (long) i)%mod;
        }
        long r = 1;

        for (int i=1; i<=n; i++)
        {
            r=(factorial[i]*r)%mod;
        }

        System.out.print(r);

    }
}
