package U_17MultiThreadingAndConcurrency.A_2CreatingThread_ThreadClass_RunnableInterface;


public class Main {
    public static void main(String[] args) {

        Thread printer1 = new Thread(new Printer("Printer 1."));
        Thread printer2 = new Thread(new Printer("Printer 2."));



        printer1.start();
        printer2.start();
        System.out.println("Başlıyooozzz");

        // İstersek 3. Bir yolu ise anonim thread oluşturmaktır.
        Thread printer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 4; i++) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Printer 3. Çalışıyor: " + i);

                }
                System.out.println("Printer 3. işi bitti");
            }
        });

        printer3.start();

    }



}
