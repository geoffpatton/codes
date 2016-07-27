package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * Created by geoffpatton on 7/24/2015.
 * NFACTOR - N-Factorful
 */
public class NFactor {
    public static void main(String[] args) throws IOException{
        new NFactor().run();
    }

    private void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        int testCaseNum =  Integer.parseInt(in.nextToken());

        for(int t = 0; t<testCaseNum;t++) {
            if(!in.hasMoreTokens()) {
                in = new StringTokenizer(br.readLine());
            }
            int a = Integer.parseInt(in.nextToken());
            int b = Integer.parseInt(in.nextToken());
            int n = Integer.parseInt(in.nextToken());
            solve(a, b, n);
        }
    }
    private void solve(int a, int b, int n){
        int answerCount=0;
        for (int i = a; i <= b; i++) {
            if (factor(i) == n) {
                answerCount++;
            }
        }
        System.out.println(answerCount);
    }
    private int factor(int num){
        Set<Integer> factors = new HashSet<>();
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }
        int i = 3;
        while (i <= Math.sqrt(num) + 1) {
            if (num % i == 0) {
                factors.add(i);
                num /= i;
            } else {
                i += 2;
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors.size();
    }
}