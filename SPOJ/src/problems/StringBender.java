package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 7/27/2015.
 *
 */
public class StringBender {
    public static void main(String[] args) throws IOException{
        new StringBender().run();
    }
    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(in.nextToken());

        in = new StringTokenizer(br.readLine(), "\n");
        String s1 = in.nextToken();

        in = new StringTokenizer(br.readLine(), "\n");
        String s2 = in.nextToken();

        in = new StringTokenizer(br.readLine());
        int moves = Integer.parseInt(in.nextToken());

        String[] swapped = {s1, s2};

        for (int i = 0; i < moves; i++) {
            in = new StringTokenizer(br.readLine());
            int startLocation = Integer.parseInt(in.nextToken());
            int endLocation = Integer.parseInt(in.nextToken());
            if (endLocation<length){
                endLocation++;
            }


            swapped = swap(swapped[0], swapped[1], startLocation, endLocation);

        }
        System.out.println(swapped[0]);
        System.out.println(swapped[1]);

    }

    private String[] swap(String s1, String s2, int l, int r){

        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        String sub1 = sb1.substring(l,r);
        String sub2 = sb2.substring(l,r);

        s1= sb1.replace(l,r,sub2).toString();
        s2= sb2.replace(l,r,sub1).toString();

        String[] swapped = {s1,s2};

        return swapped;
    }
}

