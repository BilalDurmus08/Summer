package U_17MultiThreadingAndConcurrency.K_Callable_Future_Interface;

import java.util.Random;
import java.util.concurrent.*;

public class main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

      Future<Integer> IntegerFuture = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();

                System.out.println("Thread has been working...");
                int time = random.nextInt(1000) + 2000;
                Thread.sleep(time);

                System.out.println("Thread's job is done");
                return time;
            }

        });
        executor.shutdown();

        try {
            System.out.println("The value of time is: " + IntegerFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

}
