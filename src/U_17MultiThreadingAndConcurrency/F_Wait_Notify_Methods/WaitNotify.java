package U_17MultiThreadingAndConcurrency.F_Wait_Notify_Methods;

import java.util.Scanner;

public class WaitNotify {
        public Object lock1 = new Object();

        public void waitfunction(){

        synchronized (lock1){
            System.out.println("WaitFunction have started the work. ");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("The waiting process is done");
            try {
                lock1.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("The function Started now, because of the notify code.");

        }//lock1
            System.out.println("Just temp");
    }

    public void notifyFunction(){
       synchronized (lock1){
           Scanner scanner = new Scanner(System.in);
           System.out.println("The NotifyFunction have started the work");

           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("Just give input for the start waitFunction, It doesn't matter that you giving. ");
           scanner.nextLine();
           lock1.notify();

           try {
               Thread.sleep(2500);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("The function going to start now. NotifyFunction's job done.");


       }

    }




}
