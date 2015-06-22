/**
 * Created by geoffpatton on 6/17/15.
 */
public class StringBuilderDemo {


    public static void main(String[] args) {

        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);

        System.out.println(sb);


        sb.reverse();

        String end = " and he was cool";

        sb.append(end);


        System.out.println(sb);


        int i = sb.indexOf("and");

        sb.insert(i-1, ", he was slick");



     //   sb.reverse();  // reverse it

        System.out.println(sb);

    }


}
