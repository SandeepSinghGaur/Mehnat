package interview.multithreading.Bank_Account_Management_System;


public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread depositor1 = new Thread(new DepositTask(account, 100), "Depositor-1");
        Thread depositor2 = new Thread(new DepositTask(account, 150), "Depositor-2");
        Thread withdrawer1 = new Thread(new WithdrawTask(account, 50), "Withdrawer-1");
        Thread withdrawer2 = new Thread(new WithdrawTask(account, 200), "Withdrawer-2");
        Thread balanceChecker = new Thread(new BalanceCheckTask(account), "BalanceChecker");

        depositor1.start();
        depositor2.start();
        withdrawer1.start();
        withdrawer2.start();
        balanceChecker.start();

        try {
            depositor1.join();
            depositor2.join();
            withdrawer1.join();
            withdrawer2.join();
            balanceChecker.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}