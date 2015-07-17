import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * Created by geoffpatton on 7/17/2015.
 * ARRAYSUB - subarrays
 */
public class ArraySub {

    public static void main(String[] args){
        new ArraySub().run();
    }

    private void run(){
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int[] array = new int[size];
        for (int i  = 0; i<size;i++){
            array[i] = in.nextInt();
        }
        int subSize = in.nextInt();
        int[] subArray = new int[subSize];
        int lowestMax = 0;


        for (int j = 0; j < size - subSize+1; j++){
            for(int y= 0; y < subSize; y++){
                subArray[y] = array[j+y];
            }
            //System.out.println(Arrays.toString(subArray));
            OptionalInt highest = Arrays.stream(subArray).max();
            int subMax = highest.getAsInt();
            if(j==0) {
                lowestMax = subMax;
              //  System.out.println(lowestMax);
            }else{
                if(lowestMax > subMax){
                    lowestMax = subMax;
                //    System.out.println(lowestMax);
                }
            }
        }


        System.out.println(lowestMax);



    }



}
