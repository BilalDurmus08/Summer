package U_17MultiThreadingAndConcurrency.C_UseOfMultipleLOCKS;

import java.util.ArrayList;
import java.util.Random;

public class listWorker {
    Random random = new Random();

    ArrayList arrayList1 = new ArrayList<>();
    ArrayList arrayList2 = new ArrayList<>();

    public synchronized void putValueList1() {
        synchronized ("lock1") {   //We put the lock. If every method has an own key the process will be decrease.
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arrayList1.add(random.nextInt(100));

        }
    }

    public void putValueList2() {
        synchronized ("lock2") {  //We put the lock. If every method has an own key the process will be decrease.
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arrayList2.add(random.nextInt(100));
        }
    }

    public void putValueBoth() {

        for (int i = 0; i < 250; i++) {
            putValueList1();
            putValueList2();
        }

    }

    public void finalPath() {
        long startingTime = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                putValueBoth();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                putValueBoth();
            }
        });

        thread1.start();
        thread2.start();


        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finishedTime = System.currentTimeMillis();
        System.out.println("The size of List1: " + arrayList1.size() + "   The size of List1: " + arrayList2.size());
        System.out.println("The process's time is: " + (finishedTime - startingTime));

    }


}
