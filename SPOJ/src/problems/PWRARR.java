package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by tua26762 on 1/12/2016.
 */
public class PWRARR {
    public static void main(String args[]) throws IOException{
        new PWRARR().run();
    }

    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(in.nextToken());
        //System.out.println("testCases"+testCases);

        while (testCases-->0){
            while(!in.hasMoreTokens()){
                in = new StringTokenizer(br.readLine());
            }

            //long numInCase = Integer.parseInt(in.nextToken());
            long numInCase = Long.parseLong(in.nextToken());

            long array[] = new long[(int)numInCase];
            //System.out.println("numInCase"+numInCase);
            while(!in.hasMoreTokens()){
                in = new StringTokenizer(br.readLine());
            }
            for(long i=0; i<numInCase; i++){
                //array[i] = Integer.parseInt(in.nextToken());
                array[(int)i] = Long.parseLong(in.nextToken());
                //System.out.println("array["+i+"]="+array[i]);
            }

            Arrays.sort( array );
            long ans=0;
            for(long i=0;i<numInCase;i++)
            {
                long c=1;
                while(i<numInCase-1 && array[(int)i]==array[(int)i+1])
                {
                    c++;
                    i++;
                }
                ans+=((i+1)*c);
            }
            System.out.println(ans);


            //System.out.println(array[(int)numInCase-1]);

            //System.out.println(sum);
        } //END while
    } //END run
}
