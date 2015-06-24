import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tua26762 on 6/24/2015.
 */
public class Dice {

    public static void main(String[] args){

        DecimalFormat df = new DecimalFormat("####0.00");
        Scanner sc = new Scanner(System.in);

        List<Double> sideList = new ArrayList<>();

        System.out.println("enter dice followed by sides");

        double numDice = sc.nextDouble();

        while(sc.hasNextDouble()){
            sideList.add(sc.nextDouble());
        }
        //System.out.println(sideList);


        double rolls;

        for (int y = 0; y<sideList.size(); y++) {
            rolls = 0;

            for (int i = 0; i < sideList.get(y); i++) {
                rolls = rolls + (sideList.get(y) / (i + 1));
            }
            System.out.println(df.format(rolls));
        }


    }


}
