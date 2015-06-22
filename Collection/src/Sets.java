import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by geoffpatton on 6/21/15.
 */
public class Sets {

    public static void main (String[] args){

        Set<String> hashSet = new HashSet<>();

        for(String s: args){
            hashSet.add(s);
        }

        Iterator<String> iterator = hashSet.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //System.out.println(hashSet);



    }

}
