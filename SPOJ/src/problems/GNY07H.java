package problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by geoffpatton on 6/25/2015.
 * GNY07H - Tiling a Grid With Dominoes
 */

public class GNY07H {

    public static void main(String[] args){



        List <Integer> widthInput = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int numberOfFloors = sc.nextInt();

        while(sc.hasNextInt()){
            widthInput.add(sc.nextInt());
        }


        //System.out.println(widthInput);
        for (int run = 0; run < numberOfFloors; run++){
            System.out.println(run+1+" "+computeTiles(widthInput.get(run)));
        }


    }

    public static Integer computeTiles (Integer n){
        Integer[] array = new Integer[]{1,1,5,11,36,95,281};
        List<Integer> tileList = new ArrayList<>(Arrays.asList(array));

        if(n<7){
            return tileList.get(n);
        }else{
            for(int i =7; i<=(n+1); i++){
                int k = tileList.get(i-1) + (5*tileList.get(i-2)) + tileList.get(i-3) - tileList.get(i-4);
                tileList.add(k);
            }
        }
        return tileList.get(n);
    }





}