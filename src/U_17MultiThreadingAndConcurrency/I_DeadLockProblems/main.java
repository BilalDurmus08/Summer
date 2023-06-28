package U_17MultiThreadingAndConcurrency.I_DeadLockProblems;

public class main {
    public static void main(String[] args) {
        Dead_Lock dead_lock = new Dead_Lock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                 dead_lock.function1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                dead_lock.function2();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        dead_lock.finalFunction();

    }



}
