import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by geoffpatton on 7/30/2015.
 * used
 */
public class AmazingPrimeSequence {
    int count = 0;
    public static void main(String[] args) throws IOException{
        new AmazingPrimeSequence().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            long n = Long.parseLong(br.readLine());
            count=0;
            System.out.println(lowPrime(n));
        }
    }
    private long lowPrime(long n){
        if(n<=2){
            return n;
        }
        int lp=0;
        for(int i = 2; i<=n;i++){
            if(n%i==0){
                lp =i;
            }
        }
        count++;
        if(count>=2){
            return lp;
        }
        return lp + lowPrime(n-1);
    }
}
