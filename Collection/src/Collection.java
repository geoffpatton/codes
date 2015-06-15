import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tua26762 on 6/3/2015.
 */
public class Collection {

    public Collection(){

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++) {
            list.add(i);
        }

    }

    public static void main(String[] args){

        ArrayList();

        Print();




    }


    public void Print(){

        for (int i : list)
            System.out.println(Arrays.deepToString(ArrayList.get(i)));
        }

    }


    public static void ArrayList(){


    }



}
