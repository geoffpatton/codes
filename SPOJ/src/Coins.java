import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by gpatton on 6/23/2015.
 */
public class Coins {

    static HashMap<Integer, Integer> resultCache = new HashMap<>();

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {

        System.out.println("Starting Coins:");
        init( System.in );


        int byteLandCoin = nextInt();
                System.out.println(ByteLandianConversion(byteLandCoin));
    }


    private static int ByteLandianConversion(int goldCoinAmount){


        if (resultCache.containsKey(goldCoinAmount)) return resultCache.get(goldCoinAmount);

        int halfValue = (goldCoinAmount/2);
        int thirdValue = (goldCoinAmount/3);
        int fourthValue = (goldCoinAmount/4);


        int totalIntermediate = halfValue + thirdValue + fourthValue;
        if(goldCoinAmount > totalIntermediate)
            return goldCoinAmount;
        else{
            int maxHalfPortion = ByteLandianConversion(halfValue);
            int maxThirdPortion = ByteLandianConversion(thirdValue);
            int maxFourthPortion = ByteLandianConversion(fourthValue);
           // return maxHalfPortion+maxThirdPortion+maxFourthPortion;

            int result = maxHalfPortion+maxThirdPortion+maxFourthPortion;
            resultCache.put(goldCoinAmount, result);
            return result;

        }
    }



    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }



}
