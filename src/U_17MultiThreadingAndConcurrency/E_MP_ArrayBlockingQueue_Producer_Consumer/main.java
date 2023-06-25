package U_17MultiThreadingAndConcurrency.E_MP_ArrayBlockingQueue_Producer_Consumer;

public class main {

    public static void main(String[] args) {
            ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.produce();
            }
        }) ;

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consume();
            }
        }) ;

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
