package problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tua26762 on 6/25/2015.
 * ACODE - Alphacode
 */
public class Alphacode {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();

        int input=Integer.parseInt(Character.toString(line.charAt(0)));

        List<Long> possibleDecodings = new ArrayList<>();

        //run till input = 0
        while(input!=0){

            int alphaValue[]=new int[line.length()+1];

            //convert char to int
            for(int i=1;i<=line.length();i++){
                alphaValue[i]=Integer.parseInt(Character.toString(line.charAt(i -1)));
            }

            long decodings[]=new long[alphaValue.length+1];
            //set first 2 values to 1
            decodings[0]=1;
            decodings[1]=1;
            int n=line.length()+1;

            //loop and add all codings as you go through the array
            for(int i=2;i<n;i++){
                if(alphaValue[i]==0){
                    decodings[i]=decodings[i-2];
                }else if(alphaValue[i]<=6){
                    if(alphaValue[i-1]==1 || alphaValue[i-1]==2){
                        decodings[i]=decodings[i-1]+decodings[i-2];
                    }else{
                        decodings[i]=decodings[i-1];
                    }
                }else{
                    if(alphaValue[i-1]==1 || alphaValue[i-1]==2){
                        decodings[i]=decodings[i-1]+decodings[i-2];
                    }else{
                        decodings[i]=decodings[i-1];
                    }
                }
            }

            //prints answer for line

            //read in next line
            possibleDecodings.add(decodings[alphaValue.length-1]);
            line=br.readLine();
            input=Integer.parseInt(Character.toString(line.charAt(0)));
        }

        //prints out answer
/*        for(int i=0; i<possibleDecodings.size();i++){
            System.out.println(possibleDecodings.get(i));
        }*/
        Iterator<Long> it = possibleDecodings.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
