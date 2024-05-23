package interview.multithreading.Bank_Account_Management_System;

class DepositTask implements Runnable {
    private final BankAccount account;
    private final double amount;

    public DepositTask(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(amount);
            try {
                Thread.sleep(100); // Simulate time taken to perform deposit
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}