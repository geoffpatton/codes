import java.util.*;

/**
 * Created by geoffpatton on 6/21/15.
 */
public class Collect {


    public static void main (String[] args){

        List<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            arrayList.add(i);
            arrayList.add(i);
        }

        System.out.println(arrayList.toString());

        Set<Integer> noDups = new HashSet<>(arrayList);

        System.out.println(noDups.toString());

    }
}
