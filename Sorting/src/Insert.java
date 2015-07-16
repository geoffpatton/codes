import java.util.*;

/**
 * Created by tua26762 on 6/14/2015.
 */
public class Insert {



    public static void main(String[] args){

        List<Integer> randomList = new LinkedList<>();

        Random randomNum = new Random();

        for(int i =0; i <=10; i++){
            int x = randomNum.nextInt(100);
            randomList.add(x);
        }

        Set<Integer> noDups = new HashSet<>(randomList);

        List<Integer> sortList = insertSort(randomList);
        List<Integer> sortList2 = quicksort(randomList);
    }



    public static List<Integer> quicksort(List<Integer> numbers) {
        System.out.println("Start over quicksort numbers ="+numbers);

        if (numbers.size() < 2) {
            return numbers;
        }
        final Integer pivot = numbers.get(0);
        System.out.println("Pivot = "+pivot);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            //    System.out.println("Add "+numbers.get(i)+ " to lower");
            //    System.out.println("Lower= "+lower);

            } else {
                higher.add(numbers.get(i));
          //      System.out.println("Add "+numbers.get(i)+ " to higher");
          //      System.out.println("Higher= "+higher);
            }
        }
        final List<Integer> sorted = quicksort(lower);
        sorted.add(pivot);
       // System.out.println("Add Pivot to sorted sorted "+pivot);
        //System.out.println("Before addAll quicksort(higher) sorted ="+sorted);
        //System.out.println("run quicksort of higher ="+higher);
        sorted.addAll(quicksort(higher));
        //System.out.println("END OF QUICKSORT sorted ="+sorted);
        return sorted;
    }




    public static List<Integer> insertSort(final List<Integer> numbers){
        final List<Integer> sortedList = new LinkedList<>();
        System.out.println("Entered insertSort");
        System.out.println(numbers);

        originalList: for (Integer number : numbers){
            System.out.println(sortedList);
            //System.out.println("Entered First Loop");
            //System.out.println("number"+number);
            for(int i=0; i < sortedList.size();i++){
                //System.out.println("Entered Second Loop");
                if(number <sortedList.get(i)){
                    //System.out.println(sortedList.get(i));
                    sortedList.add(i,number);
                    System.out.println("Add "+number+ " at position "+i);
                    continue originalList;
                }
            }
            System.out.println("Add "+number+ " at position "+sortedList.size() + " Return to Start");
            sortedList.add(sortedList.size(),number);
        }

        return sortedList;

    }










}
