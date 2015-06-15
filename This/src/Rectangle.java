/**
 * Created by tua26762 on 6/9/2015.
 */
public class Rectangle {
    protected int x, y;
    protected int width, height;

    public Rectangle() {
        this(0, 0, 1, 1);
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    private void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // a method for computing the area of the rectangle
    protected int getArea() {
        return width * height;
    }

    // a method for computing the area of the rectangle
    protected int getParameter() {
        return (2*width) +  (2*height);
    }

    protected boolean checkSquare(){
        return width==height;
    }

    protected double getDiagonal(){
        return java.lang.Math.sqrt(width^2+height^2);
    }
}