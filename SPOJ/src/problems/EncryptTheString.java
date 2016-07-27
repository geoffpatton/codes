package problems;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tua26762 on 6/24/2015.
 */
public class EncryptTheString {

    public static void main(String[] args){



        Scanner sc = new Scanner(System.in);

        System.out.println("enter text");
        String scanString = sc.nextLine();


        String[] splitter = scanString.split(" ");

        String[] strings = new String[splitter.length/2];
        int[] numbers = new int[splitter.length/2];

        int stringCount = 0;
        int numCount = 0;

        for(int y = 0; y<splitter.length; y++){
            if(y%2==0){
                strings[stringCount] = splitter[y].trim();
                stringCount++;
            }else{
                int num = Integer.parseInt(splitter[y].trim());
                numbers[numCount] = num;
                numCount++;
            }
        }

        String[] stringsFinal = new String[strings.length];


        for(int i = 0; i<strings.length; i++){

            String beg = strings[i].substring(0,numbers[i]);
            String end = strings[i].substring(numbers[i]);
            stringsFinal[i] = end+beg;

        }

       for(String s : stringsFinal)
           System.out.println(s);
    }

}






/*
//taking in args

*/
