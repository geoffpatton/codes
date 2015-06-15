import java.util.Arrays;
import java.util.Random;

/**
 * Created by tua26762 on 6/7/2015.
 */
class ArrayCopyOfDemo {
    public static void main(String[] args) {

        char[] copyFrom = {'a', 'c', 'c', 'x', 'z', 'f', 'g',
                'h', 'i', 'y', 'k', 'l', 'm'};

        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        char[] exactCopy = java.util.Arrays.copyOfRange(copyFrom, 0, copyFrom.length);

        char searchElement = 'c';

        int bSearch = java.util.Arrays.binarySearch(copyFrom, searchElement);


        boolean retval= Arrays.equals(copyFrom, copyTo);

        boolean retval2= Arrays.equals(copyFrom, exactCopy);


        // initializing int array
        int arr[] = new int[10];

        Random randomGenerator = new Random();

        for(int y = 0; y<arr.length;y++){
            arr[y] = randomGenerator.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);

        // using fill for placing 18
        //Arrays.fill(arr, 2);

        // let us print the values
/*        System.out.println("New values after using fill() method: ");
        for (int value : arr) {
            System.out.println("Value = " + value);
        }*/







        //System.out.println()

        System.out.println(new String(copyTo));

        System.out.println("element c found at:"+ bSearch);

        System.out.println("copyFrom and arr3 copyTo: " + retval);

        System.out.println("copyFrom and arr3 exactCopy: " + retval2);



        System.out.println(Arrays.toString(arr));


        Arrays.parallelSort(copyFrom);
        System.out.println(Arrays.toString(copyFrom));

        Arrays.parallelSort(copyFrom);

        int test1 = 5;


        System.out.println(test1);

        System.out.println(++test1);

        System.out.println(test1);

        System.out.println(test1++);

        System.out.println(test1);

        boolean someCondition = true;


        int result = someCondition ? 0 : 99;

        System.out.println(someCondition);
        System.out.println(result);



        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        System.out.println("obj1 instanceof Parent: " + (obj1 instanceof Parent));
        System.out.println("obj1 instanceof Child: " + (obj1 instanceof Child));
        System.out.println("obj1 instanceof MyInterface: "  + (obj1 instanceof MyInterface));
        System.out.println("obj2 instanceof Parent: "  + (obj2 instanceof Parent));
        System.out.println("obj2 instanceof Child: " + (obj2 instanceof Child));
        System.out.println("obj2 instanceof MyInterface: " + (obj2 instanceof MyInterface));






    }

    public static void bubbleSort(int[] array) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }


}