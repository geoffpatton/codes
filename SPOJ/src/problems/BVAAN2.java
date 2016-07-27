package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by geoffpatton on 7/29/2015.
 * This one works
 */
public class BVAAN2 {

    static String s1,s2;
    static int dp[][][]=new int[101][101][101];
    static int dp2[][]=new int[101][101];
    public static void main(String[] args) throws IOException{
        new BVAAN2().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0)
        {
            for(int i=0;i<=100;i++)
            {
                for(int j=0;j<=100;j++)
                {
                    for(int k=0;k<=100;k++)
                    {
                        dp[i][j][k]=-1;
                    }
                }
            }

            for(int i=0;i<=100;i++)
            {
                for(int j=0;j<=100;j++)
                    dp2[i][j]=-1;
            }

            s1=br.readLine();
            s2=br.readLine();

            int len1 = s1.length();
            int len2 = s2.length();
            int k = Integer.parseInt(br.readLine());
            int longest = lcs(len1,len2);
            if(longest>=k)
                System.out.println(solve(len1,len2,k));
            else
                System.out.println("0");
        } //end while
    } //end run

    private int solve(int pos1,int pos2,int size)
    {
        if(pos1<=0||pos2<=0||size<=0)
        {
            return 0;
        }
        if(dp[pos1][pos2][size]!=-1)
            return dp[pos1][pos2][size];
        int sumS1=0,sumS2,sum;
        if(s1.charAt(pos1-1)==s2.charAt(pos2-1))
        {
            sumS1=solve(pos1-1,pos2-1,size-1)+(int)s1.charAt(pos1-1);
        }
        sumS2=solve(pos1-1,pos2,size);
        sum=solve(pos1,pos2-1,size);
        return dp[pos1][pos2][size]=Math.max(sumS1,Math.max(sumS2,sum));

    } // end solve

    private int lcs(int m, int n )
    {
        int L[][]=new int[m+1][n+1];
        int i, j;
        for (i=0; i<=m; i++)
        {
            for (j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (s1.charAt(i-1) == s2.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;

                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    } //end lcs
}
