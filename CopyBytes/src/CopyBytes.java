/**
 * Created by geoffpatton on 6/23/15.
 */
import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            in = new  BufferedInputStream ( new FileInputStream("in.txt"));
            out = new BufferedOutputStream( new FileOutputStream("out.txt"));
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
