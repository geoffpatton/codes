import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by geoffpatton on 7/14/2015.
 */
public class AddReverseNumbers {

    public static void main(String[] args){
        new AddReverseNumbers().run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);
        for(int i = in.nextInt(); i-- > 0;){

            BigInteger a = new BigInteger(new String((reverse(in.next().toCharArray()))));

            BigInteger b = new BigInteger(new String(reverse(in.next().toCharArray())));

            System.out.println(new BigInteger(new String(reverse(a.add(b).toString().toCharArray()))));
        }
    }
    public char[] reverse(char[] c){
        char[] charArray = c.clone();
        for(int y = 0; y<charArray.length; ++y){
            charArray[y] = c[c.length - y - 1];
        }
        return charArray;
    }


}
