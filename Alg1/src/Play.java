import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tua26762 on 6/21/2015.
 */
public class Play {


    public static void main(String[] args) throws IOException{

        List<Object> arrayList = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Iterator<Object> iterator = arrayList.iterator();

        String inputText;
        boolean run;



        try {
            do {

                inputText = in.readLine();


                arrayList.add(inputText);

                printArray(arrayList);




            }while(run=true);




        } catch (IOException e) {
            System.err.println(e);
            throw e;
        }
        finally {
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }






    }

    static void printArray(List<Object> arrayList2){
        Iterator<Object> iterator2 = arrayList2.iterator();


        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }


}
