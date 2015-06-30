import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 6/30/2015.
 */
public class Hotels2  {

    public static void main(String[] args) {
        new Hotels().run();
    }

    public void run(){
        BufferedReader buf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer tok = null;
        try {
            tok = new StringTokenizer(buf.readLine());
        }catch (IOException e){
            System.err.println(e.getMessage());
            return;
        }

        int numberOfHotels = Integer.parseInt(tok.nextToken());
        int maxValue = Integer.parseInt(tok.nextToken());
        int[] hotelArray = new int[numberOfHotels];

        for (int i = 0; i<numberOfHotels; i++){
            hotelArray[i] = Integer.parseInt(tok.nextToken());
        }

        int bestMax =0, start =0, end=0,currentMax=0;
        //long currentMax=0;

        while(end < numberOfHotels) {
            currentMax += hotelArray[end++];
            while (currentMax > maxValue && start < end) {
                currentMax -= hotelArray[start++];
            }
            bestMax = (bestMax < currentMax) ? currentMax : bestMax;
            if (bestMax == maxValue) {
                System.out.println(bestMax);
                return;
            }
        }
        System.out.println(bestMax);
    }

}
