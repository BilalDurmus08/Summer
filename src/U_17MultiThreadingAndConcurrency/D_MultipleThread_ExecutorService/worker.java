package U_17MultiThreadingAndConcurrency.D_MultipleThread_ExecutorService;

public class worker implements Runnable {
    private String name;
    private int Id;

    public worker(String name, int id) {
        this.name = name;
        Id = id;
    }


    @Override
    public void run() {
        System.out.println(name + " adlı işçi çalışmaktadır. Id: " + Id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " adlı işi bitti Id: " + Id);

    }

}
