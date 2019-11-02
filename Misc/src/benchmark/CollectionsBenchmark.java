package benchmark;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

class CollectionsBenchmark {
    // 2 146 483 639
    private static final int testSize = 10_000_000;
    private static final int half = testSize / 2;
    Collection<Integer> data1 = new ArrayList<>(testSize + 8);
    Collection<Integer> data2 = new ArrayDeque<>(testSize + 8);
    Collection<Integer> list1 = new ArrayList<>(testSize + 8);
    Collection<Integer> q = new ArrayDeque<>(testSize + 8);
    long listTime;
    long qTime;
    long selStart;
    long selTime;

    public static void main(String[] args) {
        new CollectionsBenchmark().run();
    }

    private void run() {
        System.out.println("Setting up test collections with size of: " + testSize);
        setup();
        sleeper(10000);

        long millisecondsStart;
        long timeSpentInMilliseconds;

        System.out.println("Starting List Test");

        for (int i = 0; i < 50; ++i) {
            millisecondsStart = System.currentTimeMillis();
            executeTest(list1);
            timeSpentInMilliseconds = System.currentTimeMillis() - millisecondsStart;
            listTime += timeSpentInMilliseconds;
            System.out.println("List Time: " + timeSpentInMilliseconds + ", Total: " + listTime);
        }

        System.out.println("-- List Add Time:   " + selTime);
        System.out.println("-- Total List Time: " + listTime);

        selTime = 0;

        sleeper(10000);
        System.out.println("Starting Queue Test");

        for (int i = 0; i < 50; ++i) {
            millisecondsStart = System.currentTimeMillis();
            executeTest(q);
            timeSpentInMilliseconds = System.currentTimeMillis() - millisecondsStart;
            qTime += timeSpentInMilliseconds;
            System.out.println("Queue Time: " + timeSpentInMilliseconds + ", Total: " + qTime);
        }

        System.out.println("-- Test Complete --");
        System.out.println("-- Queue Add Time:   " + selTime);
        System.out.println("-- Total Queue Time: " + qTime);
        System.out.println("-- Total List Time:  " + listTime);

        if (listTime > qTime) {
            System.out.println("Queue faster by: " + (listTime - qTime));
        } else {
            System.out.println("List faster by:  " + (qTime - listTime));
        }
        sleeper(2000);

    }

    private void executeTest(Collection<Integer> testColl) {
        selStart = System.currentTimeMillis();
        testColl.addAll(data1);
        selTime += System.currentTimeMillis() - selStart;
        if (testColl.stream().filter(e -> e % 2 == 0).count() != half)
            System.out.println("L invalid");
        testColl.clear();

        selStart = System.currentTimeMillis();
        testColl.addAll(data2);
        selTime += System.currentTimeMillis() - selStart;
        if (testColl.stream().filter(e -> e % 2 != 0).count() != half)
            System.out.println("L invalid");
        testColl.clear();
    }

    private void setup() {
        for (int i = 0; i < testSize; ++i) {
            data1.add(i);
            data2.add(i);
        }
    }

    private void sleeper(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
