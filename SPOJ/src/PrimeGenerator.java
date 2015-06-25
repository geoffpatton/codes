import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tua26762 on 6/25/2015.
 */
public class PrimeGenerator {

    public static void main(String[] args){

        List<Integer> inputList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int numberOfInputs = in.nextInt();
        while(in.hasNextInt()){
            inputList.add(in.nextInt());
        }

        boolean printedForSection;
        for(int i = 0; i<inputList.size(); i+=2){
            printedForSection =false;
            int lowbound = inputList.get(i);
            int upperbound = inputList.get(i+1);

            for(int y = lowbound; y<=upperbound; y++) {
                if (y == 1) {
                    continue;
                } else if (y == 2) {
                    System.out.println(y);
                    printedForSection = true;
                } else {
                    boolean isPrime = primeChecker(y);
                    if (isPrime) {
                        System.out.println(y);
                        printedForSection = true;
                    }
                }
            }
            if(printedForSection){
                System.out.println("");
            }
        }
    }

    //returns true if numer is prime
    static boolean primeChecker(int n) {
        if (n%2==0) return false; //if multiple of 2 return false

        for(int i=3;i*i<=n;i+=2) { //if not a multiple of 2 only check odd numbers to save time
            if(n%i==0)
                return false;
        }
        return true;
    }
}
