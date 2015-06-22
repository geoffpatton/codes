import java.util.*;

/**
 * Created by tua26762 on 6/22/2015.
 */
public class Maps {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println("Map= "+m);

        Map<String, Integer> tm = new TreeMap<>(m);
        System.out.println("Tree Map= "+tm);

        Map<String, Integer> lm = new LinkedHashMap<>(m);
       // System.out.println("Linked Hash Map= "+lm);

        for(String key : lm.keySet())
            System.out.print(key + " ");

        System.out.println(" ");

        Iterator<Integer> it = lm.values().iterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }

        System.out.println(" ");

        for(Map.Entry<String,Integer> e : lm.entrySet())
            System.out.print(" "+e.getKey() + " = " + e.getValue()+",");

    }
}
