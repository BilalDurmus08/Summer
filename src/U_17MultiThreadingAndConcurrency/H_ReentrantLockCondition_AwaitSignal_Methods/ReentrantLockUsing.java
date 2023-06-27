package U_17MultiThreadingAndConcurrency.H_ReentrantLockCondition_AwaitSignal_Methods;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockUsing {

    private Lock myLock = new ReentrantLock();
    private Condition condition = myLock.newCondition();
    int number = 0;

    public void IncreasingFunction() {
        for (int i = 0; i < 40000; i++) {
            number++;
        }
    }

    public void Function1() {

        System.out.println("Function1 have been worked");
            myLock.lock();

        try {
            condition.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Function1 have awoken from function2. Function1 is working.");
        IncreasingFunction();

                myLock.unlock();


    }

    public void Function2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        myLock.lock();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Function2 is working");
        IncreasingFunction();
        System.out.println("Function2 worked function1");
        condition.signal();
            myLock.unlock();


    }

    public void finalFunction() {
        System.out.println("The final number is: " + number);
    }


}
