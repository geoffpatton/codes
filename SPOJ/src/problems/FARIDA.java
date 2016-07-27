package problems;

import java.io.IOException;
import java.util.Scanner;

public class FARIDA {

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    Integer nextInt = in.nextInt();
    int caseNum = 0;
    while (nextInt-- > 0) {
      caseNum++;
      Integer NextInteger = in.nextInt();
      if (NextInteger.equals(0)) {
        System.out.println("Case " + caseNum + ": " + "0");
        continue;
      } else if (NextInteger.equals(1)) {
        System.out.println("Case " + caseNum + ": " + in.nextInt());
        continue;
      } else if (NextInteger.equals(2)) {
        System.out.println(
            "Case " + caseNum + ": " + Math.max(in.nextInt(), in.nextInt()));
        continue;
      }

      Long dp[] = new Long[3];
      dp[0] = 0l;
      dp[1] = 0l;
      dp[2] = 0l;

      Long current;
      for (int i = 1; i <= NextInteger; i++) {
        current = in.nextLong();
        dp[0] = dp[1];
        dp[1] = dp[2];
        dp[2] = Math.max(dp[0] + current, dp[1]);
      }

      System.out.println("Case " + caseNum + ": " + dp[2]);
      continue;

    }

  }

}