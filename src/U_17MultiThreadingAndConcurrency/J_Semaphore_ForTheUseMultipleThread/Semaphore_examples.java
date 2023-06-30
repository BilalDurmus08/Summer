package U_17MultiThreadingAndConcurrency.J_Semaphore_ForTheUseMultipleThread;

import java.util.concurrent.Semaphore;

public class Semaphore_examples {

    Semaphore semaphore = new Semaphore(3);

    public void threadFunction(String ID){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread is starting : " + ID);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread's jop done" + ID);

        semaphore.release();
    }


}
