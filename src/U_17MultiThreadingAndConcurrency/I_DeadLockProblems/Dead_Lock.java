package U_17MultiThreadingAndConcurrency.I_DeadLockProblems;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dead_Lock {

    BankAccount bankAccount1 = new BankAccount("Account1");
    BankAccount bankAccount2 = new BankAccount("Account2");


    private Lock myLock1 = new ReentrantLock();
    private Lock myLock2 = new ReentrantLock();


    Random random = new Random();

    public void CheckTheLocks(Lock a, Lock b) {
        boolean isALockTrue = false;
        boolean isBLockTrue = false;

        while (true) {
            isALockTrue = a.tryLock();
            isBLockTrue = b.tryLock();

            if (isALockTrue && isBLockTrue)
                return;
            if (isALockTrue) {
                a.unlock();
            }
            if (isBLockTrue) {
                b.unlock();
            }
        }


    }

    public void function1() {
        CheckTheLocks(myLock1, myLock2);

        for (int i = 0; i < 1000; i++) {
            BankAccount.Transfer(bankAccount1, bankAccount2, random.nextInt(100));
        }
        myLock1.unlock();
        myLock2.unlock();
    }

    public void function2() {
        CheckTheLocks(myLock1, myLock2);

        for (int i = 0; i < 1000; i++) {
            BankAccount.Transfer(bankAccount2, bankAccount1, random.nextInt(100));
        }
        myLock2.unlock();
        myLock1.unlock();

    }

    public void finalFunction() {
        int totalMoney = bankAccount2.getAccountSafe() + bankAccount1.getAccountSafe();
        System.out.println("BankAccount1 wallet: " + bankAccount1.getAccountSafe() +
                "   BankAccount2 wallet: " + bankAccount2.getAccountSafe() +
                "\nThe total wallet is: " + totalMoney);
    }


}
