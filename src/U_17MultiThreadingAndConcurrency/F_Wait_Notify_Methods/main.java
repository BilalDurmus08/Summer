package U_17MultiThreadingAndConcurrency.F_Wait_Notify_Methods;

public class main {

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            waitNotify.waitfunction();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
            waitNotify.notifyFunction();
            }
        }) ;

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All the process done");

    }




}
