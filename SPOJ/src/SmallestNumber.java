import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by geoffpatton on 6/30/2015.
 * SMALL - Smallest Number
 * WA on (3)
 */
public class SmallestNumber {

    public static void main(String[] args) {
        new SmallestNumber().run();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        List<Long> allNumbers = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            allNumbers.add(in.nextLong());
        }

        for (int y = 0; y < allNumbers.size(); y++) {
            //int[] answer = new int[allNumbers[y]];
            List<Long> answer = new ArrayList<>();

            for (long i = 1; i <= allNumbers.get(y); i++) {
                answer.add(i);
            }
            //System.out.println(answer);
            long ans = lcm(answer);
            System.out.println(ans);
        }
    }

    public long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    public long lcm(List<Long> input) {
        //System.out.println(input);
        long result = input.get(0);
        for (int i = 1; i < input.size(); i++){
            result = lcm(result, input.get(i));
            //System.out.println(input.get(i)+" "+result);
        }

        return result;
    }

    public long gcd(long a, long b) {
        while (b > 0 && b<1000000007L) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}