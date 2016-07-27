package problems;
import java.util.Scanner;

/**
 * Created by geoffpatton on 8/10/2015.
 */
public class Party {
    private static final int MAX_BUDGET = 501, MAX_PARTIES = 101;
    private static int[][] dp = new int[MAX_PARTIES][MAX_BUDGET];

    private static void clean(int n, int m) {
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = 0;
    }

    public static void main(String[] args){
        new Party().run();
    }
    private void run(){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            int budget = in.nextInt();
            int party = in.nextInt();
            if (budget == 0 && party == 0)
                break;
            clean(party, budget);
            dp[0][0] = 0;
            int[][] p = new int[party][2];
            for (int i = 0; i < p.length; i++) {
                p[i][0] = in.nextInt();
                p[i][1] = in.nextInt();
            }
            int entranceFee = 0, funVal = 0;
            for (int i = 1; i <= party; i++) {
                for (int j = 0; j <= budget; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - p[i - 1][0] >= 0) {
                        dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - p[i - 1][0]] + p[i - 1][1]);
                        if (dp[i][j] > funVal || (dp[i][j] == funVal && entranceFee > j)) {
                            funVal = dp[i][j];
                            entranceFee = j;
                        }
                    }
                }
            }
            sb.append(entranceFee + " " + funVal + "\n");
        }
        System.out.print(sb);
    }
}
