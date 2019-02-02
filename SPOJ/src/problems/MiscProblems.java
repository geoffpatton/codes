package problems;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by geoffpatton on 8/17/2015.
 */
class MiscProblems {
    int arr1[] = { 1, 15, 5, 8, 10, 3, 13 };
    int arr2[] = { 1, 15, 5, 8, 10, 3, 13 };
    int arr3[] = { 7, 2, 3, 10, 2, 4, 8, 1 };

    List<Data> data = new ArrayList<Data>();

    public static void main(String[] args) {
        new MiscProblems().run();
    }

    private void run() {
         setup();
         System.out.println("Fibonacci: 5 = " + getFibonacci(5));
         System.out.println("Palindrome: HELLO = " + isPalindrome("HELLO"));
         System.out.println("Palindrome: TEET = " + isPalindrome("TEET"));
         System.out.println("Anagram: TETT TTEE" + isAnagram("TETT", "TTEE"));
         System.out.println("Anagram: TEET TTEE" + isAnagram("TEET", "TTEE"));
         System.out.println("findLargestInArr: " + findLargestInArr());
         System.out.println("bubbleSort: ");
         bubbleSort();
         System.out.println("rev string: HELLO = " + revStr("HELLO"));
         System.out.println("rev string2: GREAT " + revStr2("GREAT"));
         System.out.println("fixString 'Hello World' " + fixString("Hello World",
         data));
         System.out.println("maxDifference: " + maxDifference(arr3));
         checkBits();

        System.out.println(makeAnagram("bugexikjevtubidpulaelsbcqlupwetzyzdvjphn",
                "lajoipfecfinxjspxmevqxuqyalhrsxcvgsdxxkacspbchrbvvwnvsdtsrdk"));

    }

 

    void bubbleSort() {
        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 1; j < (arr2.length - i); j++) {
                if (arr2[j - 1] > arr2[j]) {
                    int temp = arr2[j - 1];
                    arr2[j - 1] = arr2[j];
                    arr2[j] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr2));
    }

    private int findLargestInArr() {
        System.out.println(Arrays.toString(arr1));
        int max = 0;
        for (int i : arr1) {
            if (i > max)
                max = i;
        }
        return max;
    }

    private boolean isAnagram(String a, String b) {
        char c[] = a.toCharArray();
        char d[] = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);

        return Arrays.equals(c, d);
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        return true;
    }

    private int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    private String revStr(String str) {
        char c[] = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            char a = c[i];
            c[i] = c[str.length() - 1 - i];
            c[str.length() - 1 - i] = a;
        }
        return new String(c);
    }

    private String revStr2(String str) {
        char[] c = str.toCharArray();

        for (int i = 0; i < str.length() / 2; ++i) {
            char temp = c[str.length() - 1 - i];
            c[str.length() - 1 - i] = c[i];
            c[i] = temp;
        }

        return new String(c);
    }

    private void setup() {
        data.add(new Data(0, "Hello", "Hi"));
        data.add(new Data(3, "World", "Universe"));
        data.add(new Data(0, "Hi", "YOYO"));

    }

    private String fixString(String source, List<Data> dataList) {

        System.out.println("Source: " + source);

        for (Data d : dataList) {
            int len = d.index + d.repPattern.length();

            System.out.println("index:" + d.index);
            System.out.println("a:" + source.substring(d.index, len));
            System.out.println("b:" + source.substring(0, d.index));
            System.out.println("c:" + source.substring(len, source.length()));
            System.out.println("len:" + len);
            System.out.println("source len:" + source.length());

            if (source.length() >= len && d.repPattern.equals(source.substring(d.index, len))) {
                System.out.println("replacing:" + source);
                String temp = source.substring(0, d.index) + d.replacement + source.substring(len, source.length());
                source = temp;
            }
            System.out.println("Current Result:" + source);

        }

        System.out.println("Final Result:" + source);

        return source;
    }

    /**
     * Find the max difference in the array given
     * 
     * @param a
     *            - int array
     * @return - differenct
     */
    private int maxDifference(int[] a) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        List<Integer> numList = Arrays.stream(a).boxed().collect(Collectors.toList());

        int result = -1;
        final int size = numList.size();

        for (int i = 0; i < size / 2; ++i) {
            int currentDiff = numList.get(size - i - 1) - numList.get(i);
            System.out.println("currentDiff: " + currentDiff);

            if (currentDiff > result && numList.contains(currentDiff)) {
                result = currentDiff;
                System.out.println("result: " + result);
            }

        }

        return result;

    }

    /**
     * 
     */
    void checkBits() {
        // Integer valInt = 65535;
        // byte[] bytes = ByteBuffer.allocate(4).putInt(valInt).array();

        // byte[] bytes2 = ByteBuffer.allocate(2).putShort(s).array();

        // System.out.println(Arrays.toString(bytes));

        // Integer result = Short.toUnsignedInt(s);
        // Engineering Units = (Proportional Counts) *( (Engineering Units @ high scale)
        // - (Engineering Units @ low scale))/((25000 - (Counts @ low scale)))

        // -22 38000
        // -1 64300
        float rVal = -4.0f;
        float lowEng = -20.0f;
        float highEng = 20.0f;

        Float output = rVal / ((highEng - lowEng) / 50000.0f);
        System.out.println("output: " + output);

        Integer curVal = output.intValue();
        System.out.println("curVal: " + curVal);
        byte[] bytes = ByteBuffer.allocate(4).putInt(curVal).array();
        System.out.println(Arrays.toString(bytes));

        Short s = curVal.shortValue();
        System.out.println("s: " + s);
        byte[] bytes2 = ByteBuffer.allocate(2).putShort(s).array();
        System.out.println(Arrays.toString(bytes2));

        Integer x = Short.toUnsignedInt(s);
        System.out.println("int val: " + x);

        byte[] bytes3 = ByteBuffer.allocate(4).putInt(x).array();
        System.out.println(Arrays.toString(bytes3));
    }
    
    //
    /**
     * Returns number of elements removed from the Strings to make an anagram
     */
    static int makeAnagram(String a, String b) {

        List<Character> c1 = new ArrayList<>();
        List<Character> c2 = new ArrayList<>();

        for (char x : a.toCharArray()) {
            c1.add(x);
        }
        for (char x : b.toCharArray()) {
            c2.add(x);
        }

        Collections.sort(c1);
        Collections.sort(c2);

        int removed = 0;

        while (!c1.equals(c2)) {
            int len = c1.size();
            if (c2.size() > len) {
                len = c2.size();
            }

            for (int i = 0; i < len; ++i) {
                if (i >= c1.size()) {
                    c2.remove(i);
                    ++removed;
                    --len;
                    --i;
                }
                else if (i >= c2.size()) {
                    c1.remove(i);
                    ++removed;
                    --len;
                    --i;
                }
                else if (!c1.get(i).equals(c2.get(i))) {
                    if (c1.get(i) < c2.get(i)) {
                        c1.remove(i);
                    }
                    else {
                        c2.remove(i);
                    }
                    ++removed;
                    --len;
                    --i;
                }
            }
        }
        return removed;
    }

    class Data {
        int index;
        String repPattern;
        String replacement;

        Data(int index, String repPattern, String replacement) {
            this.index = index;
            this.repPattern = repPattern;
            this.replacement = replacement;
        }

    }

}
