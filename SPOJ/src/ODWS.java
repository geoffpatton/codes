import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by geoffpatton on 8/24/2015.
 */
public class ODWS {
    public static void main(String[] args) throws IOException{
        new ODWS().run();
    }
    private void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while(testCases-->0){
            String s = br.readLine();
            String t = br.readLine();

            System.out.println(s+" "+ t);
        }

    }
}
