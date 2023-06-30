package U_17MultiThreadingAndConcurrency.L_InterruptingThread;

import java.util.LinkedList;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {

        List<Long> linkedList1 = new LinkedList<>();


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
                for (long i = 0; i < 1000000; i++) {  //1 billion

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("We have Interrupted");
                return;
            }
                    linkedList1.add( i);

                }
                System.out.println("The process has done");
            }
        });

        thread1.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread1.interrupt();


    }


}
