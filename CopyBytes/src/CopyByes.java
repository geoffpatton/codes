/**
 * Created by tua26762 on 6/2/2015.
 */


import java.io.*;
import java.util.Scanner;

public class CopyByes {


    public static void main(String[] args) throws IOException {
        BufferedReader in =null;
        BufferedWriter out = null;

        //System.out.print("writing");

        //try{


        Scanner s = null;
            in = new BufferedReader(new FileReader("C:\\Users\\tua26762\\code\\CopyBytes\\src\\in.txt"));
            out = new BufferedWriter(new FileWriter("C:\\Users\\tua26762\\code\\CopyBytes\\src\\out.txt"));

        s = new Scanner (new BufferedReader(new FileReader("C:\\Users\\tua26762\\code\\CopyBytes\\src\\in.txt")));

            int c;

            //while((c=in.read()) != -1){
                System.out.print("writing");
            int reader = in.read();
                out.write(reader);
            //}

        System.out.println(s.next());
/*
        }catch (IOException ex){

        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }*/



    }




}
