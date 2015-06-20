import java.util.ArrayList;
import java.util.List;

/**
 * Created by tua26762 on 6/20/2015.
 */
public class Box<T> {

    private T t; // T stands for "Type"

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}