/**
 * Created by geoffpatton on 6/23/15.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("in.txt"));
            outputStream = new FileWriter("out.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}