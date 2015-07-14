import java.util.Scanner;

/**
 * Created by geoffpatton on 7/14/2015.
 * SUMPRO - SUM OF PRODUCT
 */
public class SumPruduct {
    long modulo = 1000000007;

    public static void main(String[] args){
        new SumPruduct().run();
    }

    public void run(){

        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for(int i = 0; i<testCases; ++i){
            long n = in.nextLong();
            System.out.println(solve(n));
        }
    }

    public long solve(long n){
        long sum = 0;
        long d = 1;
        long q = n;
        while (d < q){
            sum = add(sum,(q*(q+1+2*d)/2)%modulo, modulo);
            ++d;
            q = n / d;
        }
        return sub(add(sum, (q * (q + 1) / 2) % modulo, modulo), (d*(d-1)/2*d)%modulo, modulo);
    }

    public long add(long a, long b, long c){
        a += b;
        if(a >= modulo){
            a -= modulo;
        }
        return a;
    }
    public long sub(long a, long b, long c){
        if (a < b){
            a += modulo;
        }
        return a - b;
    }
}
