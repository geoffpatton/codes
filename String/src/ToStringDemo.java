/**
 * Created by tua26762 on 6/16/2015.
 */
import java.util.Arrays;

public class ToStringDemo {
    public ToStringDemo(){
    }

    public static void main(String[] args){

        int len = args.length;

        String[] Beta = new String[len];

        Beta[0] = args[0];
        Beta[1] = args[1];

        int dot = Beta[0].indexOf('.');




        System.out.println(Arrays.toString(Beta));



    }

}
