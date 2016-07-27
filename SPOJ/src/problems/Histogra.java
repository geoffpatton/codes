package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 7/6/2015.
 * TLE
 */
public class Histogra {

    public static void main(String[] args) throws IOException {
        try {
            new Histogra().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() throws IOException {
        //java.util.Scanner in = new java.util.Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] input = br.readLine().split(" ");

        StringTokenizer in = new StringTokenizer(br.readLine());


        int numberOfInput;

       // while(Integer.parseInt(input[stringlocation] != 0)){


        while(in.hasMoreTokens()){


            /*numberOfInput = Integer.parseInt(input[stringlocation]);
            stringlocation++;
*/
            numberOfInput = Integer.parseInt(in.nextToken());

           if (numberOfInput==0)
                break;

            long[] heightList = new long[numberOfInput];
            long[] width = new long[numberOfInput];
            Arrays.fill(width, 1);
            Stack<Integer> leftQ = new Stack<>();
            Stack<Integer> rightQ = new Stack<>();

            for(int i=0;i<numberOfInput;i++){
                //heightList[i] =in.nextInt();
                heightList[i] = Integer.parseInt(in.nextToken());
            }

            for(int i = 0; i < numberOfInput; i++){
                // count # of consecutive higher bars on the left of the (i+1)th bar
                while(!leftQ.isEmpty() && heightList[i] <= heightList[leftQ.peek()]){
                    // while there are bars stored in the stack, we check the bar on the top of the stack.
                    leftQ.pop();
                }

                if(leftQ.isEmpty()){
                    // all elements on the left are larger than height[i].
                    width[i] += i;
                } else {
                    // bar[left.peek()] is the closest shorter bar.
                    width[i] += i - leftQ.peek() - 1;
                }
                leftQ.push(i);
            }

            for (int i = numberOfInput-1; i >=0; i--) {

                while(!rightQ.isEmpty() && heightList[i] <= heightList[rightQ.peek()]){
                    rightQ.pop();
                }

                if(rightQ.isEmpty()){
                    // all elements to the right are larger than height[i]
                    width[i] += numberOfInput - 1 - i;
                } else {
                    width[i] += rightQ.peek() - i - 1;
                }
                rightQ.push(i);
            }

            long max = Integer.MIN_VALUE;
            for(int i = 0; i < numberOfInput; i++){
                // find the maximum value of all rectangle areas.
                max = Math.max(max, width[i] * heightList[i]);
            }

            System.out.println(max);

            if(!in.hasMoreTokens()){
                in = new StringTokenizer(br.readLine());
            }


        }

    }
}
