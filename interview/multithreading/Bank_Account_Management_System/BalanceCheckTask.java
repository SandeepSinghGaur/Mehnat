package interview.multithreading.Bank_Account_Management_System;

class BalanceCheckTask implements Runnable {
    private final BankAccount account;

    public BalanceCheckTask(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.checkBalance();
            try {
                Thread.sleep(200); // Simulate time taken to check balance
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}