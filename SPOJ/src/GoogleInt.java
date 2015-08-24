/**
 * Created by geoffpatton on 8/17/2015.
 */
public class GoogleInt {


    public void run(){
        System.out.println(func(5).toString());
    }
    public Integer func(int i) {
        if (i < 1) {
            return i;
        } else {
            return (i + func(i - 1));
        }
    }

    public static void main(String[] args){
        new GoogleInt().run();
    }

}

