package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 8/11/2015.
 */
public class TWENDS {
    static int[][] memo;
    static int FILL = 100000;
    public static void main(String[] args)throws IOException{
        new TWENDS().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int gameNumber = 1;

        while(true){

            StringTokenizer in = new StringTokenizer(br.readLine());
            int numberOfCards = Integer.parseInt(in.nextToken());
            if(numberOfCards == 0){
                break;
            }

            memo = new int[numberOfCards][numberOfCards];
            for(int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], FILL);
            }

            int[] cards = new int[numberOfCards];
            for(int i = 1; i <= numberOfCards; i++) {
                cards[i-1] = Integer.parseInt(in.nextToken());
            }
          //  System.out.println(Arrays.toString(cards));

            sb.append("In game " + gameNumber++ + ", the greedy strategy might lose by as many as " + play(cards, 0, cards.length-1) + " points.\n");
            //System.out.println("In game " + gameNumber++ + ", the greedy strategy might lose by as many as " + play(cards, 0, cards.size()-1) + " points.");
        }
        System.out.print(sb);
    }

    private int play(int[] cards, int left, int right) {
        if(left >= right) {
            return 0;
        }

        if(memo[left][right] != FILL)
            return memo[left][right];

        int l, r;

        //  pick left
        if(cards[left+1] >= cards[right]) {
            l = cards[left] - cards[left+1] + play(cards, left + 2, right);
        }
        else {
            l =  (cards[left] - cards[right]) + play(cards, left+1, right-1);
        }

        // pick right
        if(cards[left] >= cards[right-1]) {
            r = (cards[right] - cards[left]) + play(cards, left+1, right-1);
        }
        else {
            r = cards[right] - cards[right-1] + play(cards, left, right - 2);
        }

        int max = Math.max(l, r);

        if(memo[left][right] == FILL)
            memo[left][right] = max;

        return max;
    }


}
