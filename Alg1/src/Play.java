import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tua26762 on 6/21/2015.
 */
public class Play {


    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String inputText;

        try {
            while (true) {
                inputText = in.readLine();

                System.out.println(inputText);

            }


        } catch (IOException e) {
            System.err.println(e);
            throw e;
        }


    }


}
