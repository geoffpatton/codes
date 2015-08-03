import java.util.Scanner;

/**
 * Created by geoffpatton on 7/21/2015.
 */
public class HorribleQueries {

    public static void main(String[] args){
        new HorribleQueries().run();
    }

    private void run(){
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for(int t = 0;t<testCases;t++) {

            int n = in.nextInt();
            int commands = in.nextInt();

            int arr[] = new int[ n ];
            for(int i = 0; i<n;i++)
                arr[i]=0;
            for(int c = 0; c<commands;c++){
                int choice = in.nextInt();
                if(choice==0) {
                    update(arr, in.nextInt() - 1, in.nextInt() - 1, in.nextInt());
                }else{
                    System.out.println(query(arr, in.nextInt()-1, in.nextInt()-1));
                }
            }
        }
    }
    private void update(int[] arr, int pos1, int pos2, int val)
    {

        for (int i = pos1; i <= pos2; i++)
            arr[i] += val;
    }
    private int query(int[] arr, int pos1, int pos2)
    {
        int sum = 0;
        for (int i = pos1; i<=pos2; i++)
            sum += arr[i];
        return sum;
    }
}
