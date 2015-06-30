import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by geoffpatton on 6/30/2015.
 * SMALL - Smallest Number
 */
public class SmallestNumber {

    public static void main(String[] args){
        new SmallestNumber().run();
    }

    public void run(){
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();


        //int[] allNumbers = new int[testCases];

        List<Integer> allNumbers = new ArrayList<>();

        for(int i = 0;i<testCases;i++){
            allNumbers.add(in.nextInt());
        }


        for (int y=0; y<allNumbers.size(); y++) {

            //int[] answer = new int[allNumbers[y]];
            List<Integer> answer = new ArrayList<>();

            for (int i = 1; i <= allNumbers.get(y); i++) {
                answer.add(i);
            }
            //System.out.println(answer);
            int ans = lcm(answer);
            System.out.println(ans);
        }

    }


    public int lcm(int a, int b){
        return a * (b / gcd(a, b));
    }
    public int lcm(List<Integer> input)
    {
        //System.out.println(input);
        int result = input.get(0);

        for(int i = 1; i < input.size(); i++) result = lcm(result, input.get(i));
        return result;
    }

    public int gcd(int a, int b)
    {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
/*    public int gcd(List<Integer> input)
    {
        int result = input.get(0);
        for(int i = 1; i < input.size(); i++) result = gcd(result, input.get(i));
        return result;
    }*/

}
/*        int[] allNumbers = new int[testCases];


        for(int i = 0;i<testCases;i++){
            allNumbers[i] = in.nextInt();
        }*/