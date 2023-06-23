package U_17MultiThreadingAndConcurrency.A_1CreatingThread_ThreadClass_RunnableInterface;

public class Main {
    public static void main(String[] args) {
        Printer printer1 = new Printer("Printer 1.");
        Printer printer2 = new Printer("Printer 2.");
         // Eğerki Threadleri kullandıysak, main methodu da ayrı bir thread olarak alır ve 3 threadi de rastgele çalıştırır.
        printer1.start();
        printer2.start();
        System.out.println("Başlıyooozzz");


    }



}
