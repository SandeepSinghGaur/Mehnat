package interview.multithreading.Bank_Account_Management_System;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(STR."\{Thread.currentThread().getName()} deposited: \{amount}, New Balance: \{balance}");
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(STR."\{Thread.currentThread().getName()} withdrew: \{amount}, New Balance: \{balance}");
            } else {
                System.out.println(STR."\{Thread.currentThread().getName()} insufficient balance for withdrawal: \{amount}");
            }
        } finally {
            lock.unlock();
        }
    }

    public void checkBalance() {
        lock.lock();
        try {
            System.out.println(STR."\{Thread.currentThread().getName()} Balance: \{balance}");
        } finally {
            lock.unlock();
        }
    }
}