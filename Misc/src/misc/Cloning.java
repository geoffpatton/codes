package misc;

import java.util.concurrent.atomic.AtomicInteger;

public class Cloning {

    public static void main(String[] args) throws CloneNotSupportedException {
        new Cloning().run();
    }

    void run() throws CloneNotSupportedException {

        Person p1 = new Person(1, true, "blue", 2);

        Person p2 = (Person) p1.clone();

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        p1.age = 2;
        p1.hairColor = "Grey";
        p1.isCool = false;
        p1.jobCount.set(3);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }

}

class Person implements Cloneable {
    int age;
    Boolean isCool;
    String hairColor;
    AtomicInteger jobCount = new AtomicInteger();

    Person(int a, Boolean cool, String h, int jobs) {
        age = a;
        isCool = cool;
        hairColor = h;
        jobCount.set(jobs);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", isCool=" + isCool + ", hairColor=" + hairColor + ", jobCount=" + jobCount.get()
                + "]";
    }
}
