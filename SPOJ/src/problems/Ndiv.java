package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 7/23/2015.
 * NDIV - n-divisors
 */
public class Ndiv {
    public static void main(String[] args) throws IOException{
        new Ndiv().run();
    }
    private void run() throws IOException {
        //Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());
        int limit = 1000000000;
        int size = 100005;
        int[] cnt = new int[size];

        int a = Integer.parseInt(in.nextToken());
        int b = Integer.parseInt(in.nextToken());
        int n = Integer.parseInt(in.nextToken());

        for (int i = 1; i * i <= limit; i++) { //  seive
            int j = (int) Math.ceil(1.0 * a / i) * i;
            for (; j <= b; j += i) {
                int check = j / i;
                if (check == i) // if sqrt only counts once
                    cnt[j-a]++;
                else if (check > i) // ad 2 if each no have k and n/k as its factors ,
                    cnt[j-a] += 2;
            }
        }
        int ans = 0;
        int addup = b - a;
        for (int i = 0; i <= addup; i++) {
            if (cnt[i] == n)
                ans++;
        }
        System.out.print(ans);
    }
}
