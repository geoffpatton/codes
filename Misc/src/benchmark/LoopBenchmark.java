package benchmark;

import java.util.ArrayList;
import java.util.List;

class LoopBenchmark {

    private static final int testSize = 100_000_000;
    private static final int sleepTime = 2_000;

    public static void main(String[] args) {
        new LoopBenchmark().run();
    }

    private void run() {

        List<Integer> data1 = new ArrayList<>(testSize);

        for (int i = 0; i < testSize; ++i) {
            data1.add(0);
        }

        long timeSpentInMilliseconds;
        BenchmarkUtil.sleeper(10_000);


        // Old style loop test -----------------------------------
        long millisecondsStart = System.currentTimeMillis();
        Integer val = 0;

        for (int i = 0; i < testSize; ++i) {
            val = data1.get(i);
        }

        timeSpentInMilliseconds = System.currentTimeMillis() - millisecondsStart;
        System.out.println("Old style for loop Time: " + timeSpentInMilliseconds);

        // For Each test --------------------------------------
        BenchmarkUtil.sleeper(sleepTime);
        millisecondsStart = System.currentTimeMillis();
        for (Integer i : data1) {
            val = i;
        }
        timeSpentInMilliseconds = System.currentTimeMillis() - millisecondsStart;
        System.out.println("For each loop Time: " + timeSpentInMilliseconds);


        // Stream test --------------------------------------
        BenchmarkUtil.sleeper(sleepTime);
        millisecondsStart = System.currentTimeMillis();
        data1.stream().forEach(i -> {
            int val1 = i;
        });
        timeSpentInMilliseconds = System.currentTimeMillis() - millisecondsStart;
        System.out.println("Stream Time: " + timeSpentInMilliseconds);
    }


}
