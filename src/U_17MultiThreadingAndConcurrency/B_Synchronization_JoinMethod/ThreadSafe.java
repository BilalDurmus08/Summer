package U_17MultiThreadingAndConcurrency.B_Synchronization_JoinMethod;

public class ThreadSafe {

    private int count = 0;

    public synchronized void Increase(){ //The synchronized word's meaning is; when different 2 method want to reach
        count = count + 1;              // at the same time, it doesn't allow that;
    }
    public void ThreadRun() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Increase();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    Increase();
                }

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

        System.out.println("The count is: " + count);
    }


    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafe();   //We can cot use the method that is not a static variable.
        threadSafe.ThreadRun();                     //That why we created the new ThreadSafe for the reach ThreadRun Method

    }

}
