/**
 * Created by geoffpatton on 7/18/2015.
 */
public class NumberSwap {

    public static void main(String[] args){
        new NumberSwap().run();
    }

    public void run(){

        int a = 5;
        int b = 10;

        b= a+b;

        a= b-a;

        b= b-a;

        System.out.println("a="+a);
        System.out.println("b="+b);

    }
}
