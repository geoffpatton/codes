import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by geoffpatton on 6/21/15.
 */
public class Sets {

    public static void main (String[] args){

        String[] randomStrings = {"i", "came", "i", "saw", "i", "left"};

        Set<String> uniques = new HashSet<>();
        Set<String> dups = new HashSet<>();

        for(String s: randomStrings)
            if(!uniques.add(s))
                dups.add(s);

        uniques.removeAll(dups);

        //uniques.addAll(dups);
        //uniques.retainAll(dups);
        //uniques.containsAll(dups);
        //uniques.removeAll(dups);


      /*  Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        System.out.println("uniques= "+uniques+" dups= "+dups);



    }

}
