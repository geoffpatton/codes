import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by geoffpatton on 8/8/15.
 */
public class TOANDFRO {
    public static void main(String[] args) throws IOException{
        new TOANDFRO().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());

        int columns = Integer.parseInt(in.nextToken());

        while (columns !=0){

            while(in.hasMoreElements() == false){
                in = new StringTokenizer(br.readLine());
            }

            String inputOfChars = in.nextToken();

            int lengthOfRow = inputOfChars.length() / columns;

            char array [][] = new char [lengthOfRow][columns];

            int count = 0;

            for (int r = 0; r < lengthOfRow; r++){
                for (int c = 0; c < columns; c++){
                    if (r % 2 == 0){
                        array[r][c] = inputOfChars.charAt(count);
                    } else {
                        array[r][columns - c - 1] = inputOfChars.charAt(count);
                    }
                    count++;
                }
            }

            // print the result
            for (int c = 0; c < columns; c++){
                for (int r = 0; r < lengthOfRow; r++){
                    System.out.print(array[r][c]);
                }
            }

            System.out.print("\n");

            while(in.hasMoreElements() == false){
                in = new StringTokenizer(br.readLine());
            }

            columns = Integer.parseInt(in.nextToken());

        }


    }
}
