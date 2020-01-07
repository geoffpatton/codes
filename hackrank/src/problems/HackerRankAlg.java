package problems;

import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**
 * This Contains Solutions to Hacker Rank, Leet Code, SPOJ Algorithm type problems
 */
public class HackerRankAlg {

    private static TreeMap<Integer, String> roman = new TreeMap<>();

    static {
        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");
    }

    /**
     * Given a roman numeral, convert it to an integer
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param s String of the Roman numeral
     * @return Integer representation of the given roman numeral
     */
    int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;

        Map<Character, Integer> map = new WeakHashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int result = map.get(s.charAt(len - 1));

        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }

        return result;
    }

    /**
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     *
     * @param num Integer to convert to a roman numeral
     * @return String representation of the Roman Numeral
     */
    String intToRoman(int num) {
        int floorVal = roman.floorKey(num);
        if (num == floorVal) {
            return roman.get(num);
        }
        return roman.get(floorVal) + intToRoman(num - floorVal);
    }

}
