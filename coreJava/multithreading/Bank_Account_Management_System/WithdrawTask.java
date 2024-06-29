package coreJava.multithreading.Bank_Account_Management_System;

class WithdrawTask implements Runnable {
    private final BankAccount account;
    private final double amount;

    public WithdrawTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.withdraw(amount);
            try {
                Thread.sleep(150); // Simulate time taken to perform withdrawal
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}