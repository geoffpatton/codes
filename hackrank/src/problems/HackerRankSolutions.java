package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class HackerRankSolutions {

    /**
     * Jumping on the Clouds
     * <p>
     * Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud.
     * Jump on any 0 cloud that is 1 or 2 ahead of your current cloud
     * 
     * @param c int array containing 0's and 1's
     * @return the minimum number of jumps required, as an integer.
     */
    int jumpingOnClouds(int[] c) {
        int len = c.length;

        if (len < 3) {
            return 1; // return one when length is less than 3
        }

        int jump = 0;
        for (int i = 0; i < len - 2; ++i, ++jump) {
            if (c[i + 2] == 0) {
                ++i; // when two ahead is 0 jump to it and increment i
            }
            if (i == len - 3) {
                ++jump; // add another jump since we need to move one more space
            }
        }
        return jump;
    }

    /**
     * Find the maximum hour glass sum from the 6x6 array
     * 
     * @param arr
     * @return largest (maximum) hourglass sum found in the given array
     */
    int hourglassSum(int[][] arr) {
        int colLen = arr.length;
        int rowLen = arr[0].length;

        int maxSum = Integer.MIN_VALUE; // set Max Sum to Integer Min value
        for (int i = 0; i < colLen - 2; ++i) {
            for (int y = 0; y < rowLen - 2; ++y) {
                maxSum = Math.max(maxSum, arr[i][y] + arr[i][y + 1] + arr[i][y + 2] + arr[i + 1][y + 1] + arr[i + 2][y]
                    + arr[i + 2][y + 1] + arr[i + 2][y + 2]);
            }
        }
        return maxSum;
    }

    /**
     * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above.
     * Once sorted, print the following three lines:
     * <p>
     * Array is sorted in (count) swaps.
     * First Element: a[0]
     * Last Element: a[len -1]
     * 
     * @param a array of integers
     * @return number of swaps. added for testing
     */
    int countSwaps(int[] a) {
        int len = a.length;
        int swaps = 0;
        int tmp = 0;

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len - 1; ++j) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    ++swaps;
                }
            }
        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[len - 1]);

        return swaps;
    }

    /**
     * Given a string, determine how many special substrings can be formed from it.
     * 
     * @param n an integer, the length of string s
     * @param s String
     * @return count of total special substrings.
     */
    long substrCount(int n, String s) {
        long count = 0;

        // when all letters are the same
        int index;
        for (int i = 0; i < n; ++i) {
            index = i;
            while (index < n && s.charAt(i) == s.charAt(index)) {
                ++index;
            }
            count += index - i;
        }

        int prevIndex;
        int nextIndex;
        char first;
        // when middle letter is different
        for (int i = 1; i < n; ++i) {
            index = 1;
            nextIndex = i + index;
            prevIndex = i - index;
            first = s.charAt(prevIndex);
            while (prevIndex >= 0 && nextIndex < n && s.charAt(prevIndex) == s.charAt(nextIndex)
                && first == s.charAt(nextIndex) && s.charAt(nextIndex) != s.charAt(i)) {
                ++index;
                nextIndex = i + index;
                prevIndex = i - index;
            }
            count += index - 1;
        }
        return count;
    }

    /**
     * Given an array of integers: a, and a number: d, perform d left rotations on the array.
     * Return the updated array to be printed as a single line of space-separated integers.
     * 
     * @param a array of integer
     * @param d number of left rotations to perform
     * @return the rotated array
     */
    int[] rotLeft(int[] a, int d) {
        int len = a.length;
        int end; // end index location
        int[] result = new int[len]; // new array to hold the result

        // iterate over each element
        for (int x = 0; x < len; ++x) {
            end = x - d; // find the end location of the element
            if (end < 0) {
                end += len;
            }
            result[end] = a[x]; // place element in the result array
        }
        return result;
    }

    /**
     * Print an integer representing the minimum number of bribes necessary, or Too chaotic
     * if the line configuration is not possible.
     * 
     * @param q array describing the final state of the queue
     * @return minimum bribes
     */
    int minimumBribes(int[] q) {
        int bribes = 0;

        int expected;
        for (int i = 0; i < q.length; ++i) {
            expected = i + 1;
            if (q[i] - expected > 2) {
                System.out.println("Too chaotic");
                return -1;
            }

            for (int j = Math.max(0, (q[i] - 1) - 1); j < i; ++j) {
                if (q[j] > q[i]) {
                    ++bribes;
                }
            }
        }
        System.out.println(bribes);

        return bribes;
    }

    /**
     * Given two strings, determine if they share a common substring. A substring may be as small as one character.
     * <p>
     * For example, the words "a", "and", "art" share the common substring a.
     * The words "be" and "cat" do not share a substring.
     * 
     * @param s1
     * @param s2
     * @return a string, either YES or NO based on whether the strings share a common substring.
     */
    String twoStrings(String s1, String s2) {
        Set<Character> letters = new HashSet<>();
        char c;
        for (int i = 0; i < s1.length(); ++i) {
            c = s1.charAt(i);
            if (letters.add(c) && s2.indexOf(c) != -1) {
                return "YES";
            }
        }
        return "NO";
    }

    /**
     * Determine the two flavors they will purchase and print them as two space-separated integers on a line.
     * <p>
     * Print two space-separated integers denoting the respective indices for the two distinct flavors they choose to
     * purchase in ascending order.
     * 
     * @param cost an array of integers representing price for a flavor
     * @param money an integer representing the amount of money they have to spend
     */
    void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = cost.length;
        for (int i = 0; i < len; ++i) {
            map.put(cost[i], (i + 1));
        }
        for (int i = 0; i < len; ++i) {
            int val = Math.abs(money - cost[i]);
            if (map.containsKey(cost[i]) && map.containsKey(val) && map.get(val) != (i + 1)) {
                System.out.println((i + 1) + " " + map.get(val));
                break;
            }
        }
    }

    /**
     * Minimum Swaps 2
     * <p>
     * Find the minimum number of swaps required to sort the array in ascending order.
     * 
     * @param arr an unordered array of integers
     * @return an integer representing the minimum number of swaps to sort the array.
     */
    int minimumSwaps(int[] arr) {
        int len = arr.length;

        System.out.println(Arrays.toString(arr));
        int swaps = 0;
        int index;
        int i = 0;
        while (i < len) {
            index = arr[i] - 1;
            if (arr[i] != i + 1) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
                ++swaps;
            } else {
                ++i; // increment i when no swap has been made
            }
        }
        System.out.println("swaps: " + swaps);
        System.out.println(Arrays.toString(arr));

        return swaps;
    }

    /**
     * Alternating Characters
     * <p>
     * You are given a string containing characters and only.
     * Your task is to change it into a string such that there are no matching adjacent characters
     * 
     * @param s the string
     * @return integer representing the minimum number of deletions to make the alternating string
     */
    int alternatingCharacters(String s) {
        int len = s.length();
        int deletions = 0;

        if (len < 2) {
            return deletions;
        }

        char[] a = s.toCharArray();
        char lastChar = a[0];

        for (int i = 1; i < len; ++i) {
            if (lastChar == a[i]) {
                ++deletions;
            } else {
                lastChar = a[i];
            }
        }

        return deletions;
    }

    /**
     * Mark and Toys
     * <p>
     * Given a list of prices and an amount to spend, what is the maximum number of toys you can buy
     * 
     * @param prices an array of integers representing toy prices
     * @param k an integer, the budget
     * @return an integer representing the maximum number of toys Mark can purchase.
     */
    int maximumToys(int[] prices, int k) {

        Arrays.sort(prices); // sort prices

        int cost = 0;
        int toys;
        // iterate over prices, when cost is greater than budget return
        for (toys = 0; toys < prices.length; ++toys) {
            cost += prices[toys];
            if (cost > k) {
                break;
            }
        }

        return toys;
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " " + score;
        }

    }

    /**
     * Sorting: Comparator
     * <p>
     * Write a comparator that sorts Players in order of decreasing score.
     * If 2 or more players have the same score, sort those players alphabetically ascending by name
     */
    static class Checker implements Comparator<Player> {
        /*
         * (non-Javadoc)
         * 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(Player a, Player b) {
            int result = b.score - a.score;
            if (result == 0) {
                result = a.name.compareTo(b.name);
            }
            return result;
        }
    }

    /**
     * Flipping bits
     * <p>
     * Given a list of 32 bit unsigned integers. Flip all the bits an retthe unsigned decimal integer result.
     * 
     * @param n an integer as a long
     * @return the unsigned decimal integer result.
     */
    long flippingBits(long n) {
        long bitmask = Long.MAX_VALUE >>> 31; // create a mask for 32 bits
        return (~n & bitmask); // invert with mask
    }

    /**
     * Minimum Absolute Difference in an Array
     * <p>
     * Given an array of integers, find and print the minimum absolute difference between any two elements in the array
     * 
     * @param arr an array of integers
     * @return an integer that represents the minimum absolute difference between any pair of elements.
     */
    int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr); // first sort the array

        // set initial min from the difference of the first two items
        int min = Math.abs(arr[0] - arr[1]);

        // iterate through the rest of the array to find the min difference
        for (int i = 2; i < arr.length; ++i) {
            min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
        }

        return min;
    }

    /**
     * Balanced Brackets
     * <p>
     * determine whether each sequence of brackets is balanced. If a string is balanced, return YES.
     * Otherwise, return NO.
     * 
     * @param s a string of brackets
     * @return a string: YES if the sequence is balanced or NO if it is not
     */
    String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        char c;
        for (int i = 0; i < len; ++i) {
            c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && ((c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')
                || (c == ')' && stack.peek() == '('))) {
                stack.pop();
            } else {
                return "NO";
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
