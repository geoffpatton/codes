import java.util.Scanner;

/**
 * Created by geoffpatton on 6/30/2015.
 * AE00 - Rectangles
 */
public class Rectangles {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        new Rectangles().run();
    }

    public void run(){
        int count = 0;
        int input = in.nextInt();
        for (int i = 1; i<=Math.sqrt(input);i++){
            for(int j=i; i*j<=input; j++){
                count++;
            }
        }
        System.out.println(count);
    }
}
