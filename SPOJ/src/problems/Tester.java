package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Tester
{
    static int arr1[] =
        { 7,
                2,
                3,
                10,
                2,
                4,
                8,
                1 };

    public static void main(String[] args)
    {
        System.out.println(Tester.maxDifference(arr1));
        
    }

    /**
     * Find the max difference in the array given
     * @param a - int array
     * @return - differenct
     */
    static int maxDifference(int[] a)
    {
             System.out.println(Arrays.toString(arr1));
             
             Arrays.sort(a);
             int result = -1;
             final int size = a.length;
             
             int min = a[0];
             int max = a[size -1];
             for (int i = 0; i < size; ++i)
             {
                 int currentDiff = a[size - i -1] - a[i];
                 for (int y = 0; y < size; ++y)
                 {
                     if (currentDiff == a[y] && currentDiff > result) {
                         result = currentDiff;
                     }
                 }
             }
             
             return result;

    }



}
