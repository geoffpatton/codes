import java.awt.*;

/**
 * Created by tua26762 on 6/12/2015.
 */
public class RectanglePlus
        implements Relatable {
    public int width = 0;
    public int height = 0;
    public ThePoint origin;
    public String Name;



    // four constructors
    public RectanglePlus() {
        origin = new ThePoint(0, 0);
    }
    public RectanglePlus(ThePoint p) {
        origin = p;
    }
    public RectanglePlus(int w, int h) {
        origin = new ThePoint(0, 0);
        width = w;
        height = h;
    }
    public RectanglePlus(ThePoint p, int w, int h, String N) {
        origin = p;
        width = w;
        height = h;
        this.Name = N;
    }

    public static void main(String[] args){
        ThePoint orginOne = new ThePoint(1,1);
        RectanglePlus one = new RectanglePlus(orginOne,5,5, "one");
        RectanglePlus two = new RectanglePlus(orginOne,5,6, "two");

        RectanglePlus three = (RectanglePlus)findLargest(one, two);

        int areaOfOne = one.getArea();
        int areaOfTwo = two.getArea();

        int large = two.isLargerThan(one);




        System.out.println("Area of one= "+areaOfOne);

        System.out.println("Area of two= "+areaOfTwo);

        System.out.println("1 vs 2 ="+large);

        System.out.println("1 vs 2 ="+three.getArea());


    }
    public String getName() {
        return Name;
    }


    public static Object findLargest(Object object1, Object object2) {
        Relatable obj1 = (Relatable)object1;
        Relatable obj2 = (Relatable)object2;
        if ((obj1).isLargerThan(obj2) > 0)
            return object1;
        else
            return object2;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    public boolean isEqual(Object object1, Object object2) {
        Relatable obj1 = (Relatable)object1;
        Relatable obj2 = (Relatable)object2;
        if ( (obj1).isLargerThan(obj2) == 0)
            return true;
        else
            return false;
    }





    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }

    // a method required to implement
    // the Relatable interface
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect
                = (RectanglePlus)other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;
    }




}