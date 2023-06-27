package U_17MultiThreadingAndConcurrency.H_ReentrantLockCondition_AwaitSignal_Methods;

public class main {

    public static void main(String[] args) {
        ReentrantLockUsing reentrantLockUsing = new ReentrantLockUsing();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            reentrantLockUsing.Function1();
            }
        }) ;

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
           reentrantLockUsing.Function2();
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

        reentrantLockUsing.finalFunction();

    }


}
