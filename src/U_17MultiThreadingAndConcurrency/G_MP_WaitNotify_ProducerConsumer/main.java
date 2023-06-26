package U_17MultiThreadingAndConcurrency.G_MP_WaitNotify_ProducerConsumer;

public class main {
    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer();


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            producerConsumer.producer();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
           producerConsumer.consumer();
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

    }


}
