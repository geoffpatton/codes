package benchmark;

class BenchmarkUtil {

    private BenchmarkUtil() {

    }

    static void sleeper(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
