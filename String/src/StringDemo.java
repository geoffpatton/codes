import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by tua26762 on 6/16/2015.
 */
public class StringDemo {

    public StringDemo(){
    }

    public static void main(String[] args){

        String TurnAround = "Dot saw I was Tod";


        int len = TurnAround.length();

        char[] tempArray = new char[len];
        char[] reverseArray = new char[len];


        System.out.println(TurnAround);


        //seperates string into char array
/*        for(int i=0; i<len; i++){
            tempArray[i] = TurnAround.charAt(i);
        }*/
        TurnAround.getChars(0, len, tempArray,0);

        System.out.println(Arrays.toString(tempArray));

        //reverses char array into new array
        for(int j = 0; j<len;j++){
            reverseArray[j] = tempArray[len - j - 1];
        }
        System.out.println(Arrays.toString((reverseArray)));

        //places char array back into string
        /*for(int y = 0; y<len; y++){
            Rev = Rev + reverseArray[y];
        }*/
        String Rev = new String(reverseArray);
        System.out.println(Rev);




    }





}
