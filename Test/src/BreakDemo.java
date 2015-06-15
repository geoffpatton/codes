/**
 * Created by tua26762 on 6/7/2015.
 */
import java.util.Arrays;

class BreakDemo {
    public static void main(String[] args) {

        int[] arrayOfInts =
                { 32, 87, 3, 589,
                        12, 1076, 2000,
                        8, 622, 127 };
        int searchfor = 12;

        int i;
        boolean foundIt = false;

        int[] arraycopy = Arrays.copyOf(arrayOfInts,arrayOfInts.length);
        int[] arraycopy2 = Arrays.copyOf(arrayOfInts,arrayOfInts.length);

        int search = Arrays.binarySearch(arrayOfInts, searchfor);

        Arrays.parallelSort(arraycopy2);


        binarySearch(arraycopy2, searchfor);




        for (i = 0; i < arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchfor) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            System.out.println("Found " + searchfor + " at index " + i);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }

    static void binarySearch(int[] array, int key){

        int lo = 0;
        int hi = array.length;
        int position =  array.length/2;
        int countBS = 1;


        while((array[position] !=key) && (lo <= hi)){
            countBS++;
            if (array[position] > key)             // If the number is > key, ..
            {                                              // decrease position by one.
                hi = position - 1;
            }
            else
            {
                lo = position + 1;    // Else, increase position by one.
            }
            position = (lo + hi) / 2;
        }

        if (lo <= hi)
        {
            System.out.println("The number was found in array subscript" + position);
            System.out.println("The binary search found the number after " + countBS +
                    "comparisons.");
            // printing the number of comparisons is optional
        }
        else
            System.out.println("Sorry, the number is not in this array.  The binary search made "  +countBS  + " comparisons.");
    }

}





