package problems;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TransformTheExpression {

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Character> list = new ArrayList<Character>(6);

    public static void main(String args[]) {

        list.add('(');
        list.add('+');
        list.add('-');
        list.add('*');
        list.add('/');
        list.add('^');

        int t = 0;
        if (scan.hasNext()) {
            t = scan.nextInt();
        }

        while (t-- > 0) {

            Stack<Character> stack = new Stack<Character>();
            String str;
            str = scan.next();
            str += ')';
            int len = str.length();
            char[] arr;
            char[] temp;
            temp = str.toCharArray();
            arr = new char[401];
            int j = 0;

            stack.push('(');

            for (int i = 0; i < len; i++) {

                if (Character.isLetter(temp[i])) {
                    arr[j] = temp[i];
                    j++;
                } else {
                    if (temp[i] == '(')
                        stack.push(temp[i]);
                    else if (temp[i] == ')') {
                        char temp1 = stack.pop();
                        while (temp1 != '(') {

                            arr[j] = temp1;
                            j++;
                            temp1 = stack.pop();
                        }
                    } else {
                        char temp1 = stack.peek();
                        while (priority(temp1, temp[i])) {

                            temp1 = stack.pop();
                            arr[j] = temp1;
                            j++;
                            temp1 = stack.peek();
                        }
                        stack.push(temp[i]);
                    }
                }
            }
            System.out.println(arr);
        }
    }

    private static boolean priority(char temp, char c) {

        if (list.indexOf(temp) > list.indexOf(c))
            return true;
        else
            return false;
    }
}
