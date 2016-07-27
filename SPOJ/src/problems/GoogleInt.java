package problems;
/**
 * Created by geoffpatton on 8/17/2015.
 */
public class GoogleInt {




    public static void main(String[] args){

        new GoogleInt().run();
    }

    public void run(){
        System.out.println(func(5));
    }

    public int func(int i) {
        if (i < 1) {
            return i;
        } else {
            return (i + func(i - 1));
        }
    }

}

