
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tua26762 on 6/21/2015.
 */
public class MergeSort {

    public static void main(String[] args) throws IOException {

        int argument;

        List<Integer> numlist = new ArrayList<>();
        int len = args.length;



        for (int i = 0; i <len; i++){

            argument = Integer.parseInt(args[i]);

            if(argument >= 1 && argument <= 100000){
                numlist.add(argument);
            }

        }





       // System.out.println(" Original List order "+numlist.toString());


        //long startTime = System.nanoTime();
        List<Integer> sortedList = mergeSort(numlist);
        //long endTime   = System.nanoTime();
        //double totalTime = (endTime - startTime)/1e6;
        //System.out.println(" List order After merge Sort "+sortedList.toString();


/*        for (int s: sortedList) {
            System.out.println(s);
        }*/

        Iterator<Integer> iterator = sortedList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }



    public static List<Integer> mergeSort(final List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }
        final List<Integer> leftHalf =
                values.subList(0, values.size() / 2);
        final List<Integer> rightHalf =
                values.subList(values.size() / 2, values.size());
        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }
    private static List<Integer> merge(final List<Integer> left,
                                       final List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;
        final List<Integer> merged = new ArrayList<>(left.size() + right.size());
        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }
        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }
        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }
        return merged;
    }
}
