package U_17MultiThreadingAndConcurrency.E_MP_ArrayBlockingQueue_Producer_Consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    Random random = new Random();

    BlockingQueue queue = new ArrayBlockingQueue(10);

    public void produce() {

        while (true) {
            int value = random.nextInt(100);

            try {
                Thread.sleep(1000);
                queue.put(value);
                System.out.println("Producer " + value + " Putted!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void consume() {

        while (true) {
            try {
                Thread.sleep(5000);
                int value = (int) queue.take();
                System.out.println("Consumer " + value + " taked");
                System.out.println("The array's Size: " + queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}









