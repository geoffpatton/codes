import java.util.*;

import java.util.Collections;

/**
 * Created by tua26762 on 6/22/2015.
 */
public class Lists {

    public static void main(String[] args) {

        Random randomGenerator = new Random();
        //int r = ThreadLocalRandom.current() .nextInt(4, 77);

        List<Integer> arrayList1 = new ArrayList<>();
        List<Character> arrayList2 = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            arrayList1.add(randomGenerator.nextInt(10));
            arrayList2.add((char)(randomGenerator.nextInt(26) + 'a'));
        }


        ListIterator<Integer> iterator1 = arrayList1.listIterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }
        System.out.println("");


        //swapping

        shuffle2(arrayList1, randomGenerator.nextInt(3),randomGenerator.nextInt(10));
        iterator1 = arrayList1.listIterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }
        System.out.println("");

        Collections.sort(arrayList1);
        System.out.println(arrayList1);

        System.out.println("");
        System.out.println(arrayList2);

        Collections.sort(arrayList2);
        System.out.println(arrayList2);

        System.out.println("");


        String[] randWords = {"alpha", "beta", "delta", "gamma", "zeta"};

        List<String> words = Arrays.asList(randWords);

        System.out.println(words);
        Collections.shuffle(words, new Random());
        System.out.println(words);


        //return index
        int indexLocation = arrayList1.indexOf(2);


        List<?> deck = new ArrayList<>();
        deck = Arrays.asList(randWords);



    }

/*    public static void shuffle(List<?> shuffler, Random rand){
        for (int i = shuffler.size(); i>1; i--)
            swap(shuffler, i-1, rand.nextInt(i));
    }*/
    public static <E> void shuffle2(List<E> shuffler2, int i, int j){
        E temp = shuffler2.get(i);
        shuffler2.set(i, shuffler2.get(j));
        shuffler2.set(j, temp);
    }







}
