import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 6/30/2015.
 */
public class Hotels2  {

    public static void main(String[] args) throws IOException {
        new Hotels().run();
    }

    public void run() throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        long numberOfHotels = Long.parseLong(in.nextToken());
        long maxValue = Long.parseLong(in.nextToken());
        long[] hotelArray = new long[(int) numberOfHotels];

        for (int i = 0; i<numberOfHotels; i++){
            hotelArray[i] = Long.parseLong(in.nextToken());
        }

        long bestMax =0, currentMax=0;
        int  start =0, end=0;

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
