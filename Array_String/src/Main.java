import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tua26762 on 5/28/2015.
 */
public class Main {




    public Main(){


       // System.out.print(array1.toString());

    }

    public static void main (String args[]) {

        int[] array1 = new int[10];

        int k = 1;

        for(int i = 0; i<10; i++){
            array1[i] = i;
        }

        System.out.print(Arrays.toString(array1));

       // rotate(array1, k);

        rotate_bub(array1, k);






    }



    public static void rotate(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;

        int[] result = new int[nums.length];

        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }

       /* int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }*/

        //System.arraycopy( result, 0, nums, 0, nums.length );

       /* System.out.print(Arrays.toString(result));
        System.out.print(Arrays.toString(nums));
*/
    }

    public static void rotate_bub(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }

        }

        for (int s : arr){
            System.out.print(s+" ");

        }




    }





/*

    public HashMap<Integer, Student> buildMap(Student[] students) {
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        for (Student s : students) map.put(s.getld(), s);
        return map;
    }


    public ArrayList<String> merge(String[] words, String[] more) {
        ArrayList<String> sentence = new Arraylist<String>();
        for (String w : words) sentence.add(w);
        for (String w : more) sentence.add(w);
        return sentence;
    }

    public String joinWords(String[] words) {
        StringBuffer sentence = new StringBuffer();
        for (String w : words) {
            sentence.append(w);
        }
        return sentence.toString();
    }
*/




}
