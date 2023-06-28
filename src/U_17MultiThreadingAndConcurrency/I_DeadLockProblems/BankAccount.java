package U_17MultiThreadingAndConcurrency.I_DeadLockProblems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    String Name;
    private int AccountSafe = 10000;

    public BankAccount(String name) {
        Name = name;

    }

    public void Increasing(int value){

        AccountSafe = AccountSafe + value;
    }

    public void Decreasing(int value){
        AccountSafe =AccountSafe - value;
    }

    public static void Transfer(BankAccount account1, BankAccount account2, int amount){
        account1.Decreasing(amount);
        account2.Increasing(amount);
    }

    public String getName() {
        return Name;
    }


    public int getAccountSafe() {
        return AccountSafe;
    }

}
