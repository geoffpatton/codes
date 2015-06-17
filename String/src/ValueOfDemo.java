/**
 * Created by tua26762 on 6/16/2015.
 */
public class ValueOfDemo {

    public ValueOfDemo(){

    }

    public static void main(String[] args){

        if(args.length ==2){

            //float a = (Float.valueOf(args[0])).floatValue();
            //float b = (Float.valueOf(args[1])).floatValue();

            //int a = (Integer.valueOf(args[0])).intValue();

            //String Alpha = String.valueOf(args[0]);

            int a = (Integer.valueOf(args[0]));

            int b = (Integer.parseInt(args[1]));




            // do some arithmetic
            System.out.println("a + b = " +
                    (a + b));
            System.out.println("a - b = " +
                    (a - b));
            System.out.println("a * b = " +
                    (a * b));
            System.out.println("a / b = " +
                    (a / b));
            System.out.println("a % b = " +
                    (a % b));
        } else {
            System.out.println("This program " +
                    "requires two command-line arguments.");
        }


    }



}
