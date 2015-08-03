/**
 * Created by geoffpatton on 6/17/15.
 */
public class StringBuilderDemo {


    public static void main(String[] args) {

        String palindrome = "CS-CS-NDEGG";

        if(palindrome.contains("NDEGG")) {

            System.out.println("YES");

            StringBuilder sb = new StringBuilder(palindrome);

            System.out.println(sb);

        }







        //int i = sb.lastIndexOf("-");





     //   sb.reverse();  // reverse it

       //System.out.println(sb);


        /* sb.reverse();
 sb.insert(i-1, ", he was slick");
        String end = " and he was cool";

        sb.append(end);


        System.out.println(sb);*/




    }


}
