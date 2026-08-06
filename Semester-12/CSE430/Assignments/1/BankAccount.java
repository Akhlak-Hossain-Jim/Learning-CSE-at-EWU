package Banking;

public class BankAccount {
    private double balance;
    private boolean active = true;

    public void deposit(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount.");
        }
        balance += amt;
    }

    public void withdraw(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount.");
        }
        if (amt > balance) {
            throw new IllegalStateException("Insufficient funds.");
        }
        balance -= amt;
        if (balance < 100) {
            active = false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }
}