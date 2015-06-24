import java.util.*;
import static java.util.Arrays.*;


public class ONP {

    final Scanner scan = new Scanner(System.in);
    final String[] precedence = new String[] { "+", "-", "*", "/", "^" };

    boolean isIn(String s, String[] ss) {
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    private int getPrecedence(String op)
    {
        for (int i = 0; i < precedence.length; i++) {
            if (precedence[i].equals(op)) {
                return i;
            }
        }
        return -1;
    }

    void run()
    {
        int numCases = scan.nextInt();

        for (int i = 0; i < numCases; i++) {
            // infix string
            char[] line = scan.next().toCharArray();

            // create stack
            Stack<Character> operator = new Stack<>();

            for (Character operand : line) {
                if ('a' <= operand && operand <= 'z') {
                    // c = operand
                    System.out.print(operand);
                    continue;
                } else {
                    // (l|r)paren
                    switch (operand) {
                        case '(':
                            operator.push('(');
                            break;
                        case ')':
                            while (!operator.isEmpty() && operator.peek() != '(') {
                                System.out.print(operator.pop());
                                operator.pop(); // for first paren '('
                            }
                            break;
                        default:
                            break;
                    }

                    String s = operand.toString();
                    if (isIn(s, precedence)) {
                        // token check
                        if (operator.isEmpty()) {
                            operator.push(operand);
                            continue;
                        } else {
                            // operator stack is non-empty
                            while (!operator.isEmpty()) {
                                Character topStack = operator.peek();
                                int predTopStack = getPrecedence(topStack
                                        .toString());
                                int predScannedChar = getPrecedence(operand.toString());
                                if (predTopStack > predScannedChar) {
                                    System.out.print(operator.pop());
                                    continue;
                                } else {
                                    operator.push(operand);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            // empty operator stack
            while (!operator.isEmpty()) {
                System.out.print(operator.pop());
            }

            System.out.println();
        }
    }

    void debug(Object... os)
    {
        System.err.println(deepToString(os));
    }

    public static void main(String[] args)
    {
        new ONP().run();
    }

}