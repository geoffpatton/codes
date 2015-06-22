/**
 * Created by tua26762 on 6/22/2015.
 */
import java.util.*;

public class Queue {
    public static void main(String[] args) throws InterruptedException {
        int time = Integer.parseInt(args[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = time; i >= 0; i--)
            queue.add(i);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }
    }
}