package U_17MultiThreadingAndConcurrency.A_2CreatingThread_ThreadClass_RunnableInterface;

public class Printer implements Runnable{



    @Override
    public void run() {
        System.out.println( name + " Çalışıyor...");

        for (int i = 0; i < 11; i++) {
            System.out.println(name + " Yazıyor: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sürede sorun çıktı");
            }
        }
        System.out.println(name + " İşi Bitti.");
    }

    String name;
    public Printer(String name){
        this.name = name;
    }

}
