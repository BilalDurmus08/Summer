package U_17MultiThreadingAndConcurrency.L_InterruptingThread;

public class Example1 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi guys I came :)");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("I am sorry but I can not work anymore");
                    return;
                }

                System.out.println("My job have done. ");

            }
        });

        thread.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();


    }

}
