package misc;

public class Child extends Programmer {

    public String value = "Child";

    public String getValue() {
        return value;
    }

    public static void main(String args[]) {
        Child child = new Child();

        System.out.printf(child.value + "&" + child.getValue());
    }

}
