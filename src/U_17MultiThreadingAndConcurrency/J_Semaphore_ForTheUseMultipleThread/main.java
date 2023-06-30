package U_17MultiThreadingAndConcurrency.J_Semaphore_ForTheUseMultipleThread;

public class main {
    public static void main(String[] args) {
        Semaphore_examples semaphoreExamples = new Semaphore_examples();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphoreExamples.threadFunction("1.");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphoreExamples.threadFunction("2.");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphoreExamples.threadFunction("3.");
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphoreExamples.threadFunction("4.");
            }
        });

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphoreExamples.threadFunction("5.");
            }
        });

        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphoreExamples.threadFunction("6.");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All the process done");

    }


}
