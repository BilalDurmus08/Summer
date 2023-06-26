package U_17MultiThreadingAndConcurrency.G_MP_WaitNotify_ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {
    Random random = new Random();
    int limit = 10;
    Queue queue = new LinkedList();
    Object lock = new Object();

    public void producer() {
        System.out.println("Producer have started to work");
        while (true) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock) {
                if (queue.size() == limit){
                    try {
                        System.out.println("The limit is full");
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
               int value = random.nextInt(100);
               queue.offer(value);
                System.out.println("The number have been created: " + value);
               lock.notify();
            }

        }//while

    }//producer

    public void consumer (){
        System.out.println("Consumer have started to work");

        while (true){

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock){
                if (queue.size() == 0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                lock.notify();
                System.out.println("The size of LinkedList: " + queue.size());
                int value = (int) queue.poll();
                System.out.println("The pulling number is: " + value);



            }

        }



    }



}








