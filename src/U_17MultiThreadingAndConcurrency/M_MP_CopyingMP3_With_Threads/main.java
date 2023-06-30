package U_17MultiThreadingAndConcurrency.M_MP_CopyingMP3_With_Threads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void readFile (){
        String filePath;
        filePath = "tee.mp3";

        try {
            FileInputStream fis = new FileInputStream(filePath);

            int value;
            while (true){
                value = fis.read();
                if (value == -1)
                    return;
                arrayList.add(value);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void copying(String filePath){

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            for (Object a : arrayList){
                 fos.write((Integer) a);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {            //Look down !!!!
      /*  long starting = System.currentTimeMillis();  //this process took 23.2 second
        readFile();
        copying("teoman1.mp3");
        long finishing = System.currentTimeMillis();
        System.out.println("The process done, time of process is: " + (finishing - starting)); */

        long starting , finishing , total;

        starting = System.currentTimeMillis();
        readFile();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                copying("TeomanCopy1.mp3");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                copying("TeomanCopy2.mp3");
            }
        });


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                copying("TeomanCopy3.mp3");
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread3.join();
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finishing = System.currentTimeMillis();

        total = finishing - starting;
        System.out.println("We copied 3 Teoman's song. This took: " + total + " ms (ms = millisecond)");

    } //three of them took 24.6 second. That's showing us that how important and how useful thread subject.




}
