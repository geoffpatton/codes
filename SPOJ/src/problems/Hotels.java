package problems;
import java.util.Scanner;

/**
 * Created by geoffpatton on 6/30/2015.
 */
public class Hotels {
    Scanner in = new Scanner(System.in);


    public static void main(String[] args){
        new Hotels().run();
    }

    public void run(){
        int numberOfHotels = in.nextInt();
        int maxValue = in.nextInt();

        int[] hotelArray = new int[numberOfHotels];

        for (int i = 0; i<numberOfHotels; i++){
            hotelArray[i] = in.nextInt();
        }

        int currentMax=0,bestMax =0, start =0, end=0;

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
