package problems;
import java.util.Scanner;

/**
 * Created by geoffpatton on 7/17/2015.
 * FiboSum
 */
public class FiboSum {

    static final int mod = 1000000007;

    public static void main(String[] args){
        new FiboSum().run();
    }

    private void run(){
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt ();

        while (testCases-- > 0) {
            int num1 = in.nextInt (), num2 = in.nextInt ();
            long ans = fibo(num2 + 2) - fibo(num1 + 1);
            if (ans < 0) ans += mod;
            System.out.println(ans);
        }
    }

    private static long fibo (int n) {
        if (n == 0 || n == 1) return 1;
        long [][] C = exp(new long[][]{{1, 1}, {1, 0}}, n - 2);
        return (C [0][0] + C [0][1]) % mod;
    }

    private static long [][] exp (long [][] alpha, int beta) {
        long [][] res = new long [][] {{1, 0}, {0, 1}};
        while (beta > 0) {
            if ((beta & 1) == 1)
                res = matrix(res, alpha);
            beta >>= 1;
            alpha = matrix(alpha, alpha);
        }
        return res;
    }

    private static long [][] matrix (long [][] delta, long [][] gamma) {
        int deltaLenth = delta.length;
        long [][] zeta = new long [deltaLenth][deltaLenth];
        for (int i = 0; i < deltaLenth; i++)
            for (int j = 0; j < deltaLenth; j++)
                for (int y = 0; y < deltaLenth; y++)
                    zeta [i][y] = (zeta [i][y] + delta [i][j] * gamma [j][y]) % mod;
        return zeta;
    }



}
