package problems;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tua26762 on 6/24/2015.
 */
public class UniqueString {

    public static void main(String[] args){

        Set<String> uniques = new HashSet<>();
        Set<String> dups = new HashSet<>();

        for(String s : args){
            if(!uniques.add(s)){
                dups.add(s);
            }
        }

        uniques.removeAll(dups);

        System.out.println(uniques.size());

    }

}
