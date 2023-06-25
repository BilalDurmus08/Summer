package U_17MultiThreadingAndConcurrency.D_MultipleThread_ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new worker("1", 1));
        executor.submit(new worker("2", 2));
        executor.submit(new worker("3", 3));
        executor.submit(new worker("4", 4));
        executor.submit(new worker("5", 5));

        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.HOURS);  //If the executor's work takes more time than the required time we can close with automatically.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("executor's job is done");
    }

}
