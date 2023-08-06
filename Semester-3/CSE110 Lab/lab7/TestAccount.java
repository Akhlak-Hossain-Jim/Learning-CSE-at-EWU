package lab7;

import java.util.Scanner;
import java.util.Calendar;

class Account {
    private int ID = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Calendar dateCreated;

    private double mIr = (this.annualInterestRate / 100) / 12;

    public Account() {
    }

    public Account(int i, double b, double ar) {
        this.ID = i;
        this.balance = b;
        this.annualInterestRate = ar;
        this.dateCreated = Calendar.getInstance();
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getID() {
        return this.ID;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public Calendar getDateCreated() {
        return this.dateCreated;
    }

    public double getMonthlyInterestRate() {
        return mIr;
    }

    public double getMonthlyInterestAmount() {
        return mIr * balance;
    }

    public void withdraw(double amo) {
        if (balance >= amo) {
            balance -= amo;
            System.out.println(amo + " successfully withdrawn from account: " + ID + " new balance: " + balance + ".");
        }
    }

    public void deposit(double amo) {
        balance += amo;
        System.out.println(amo + " successfully deposited to account: " + ID + " new balance: " + balance + ".");
    }

    public String display() {
        return "Savings Account:\n" +
                "\n\t\tAccount ID: " + this.getID() +
                "\n\t\tDate Created: " + this.getDateCreated() +
                "\n\t\tCurrent Balance: " + this.getBalance() +
                "\n\t\tAnnual Interest Rate: " + this.getAnnualInterestRate() +
                "\n\t\tMonthly Interest Amount: " + this.getMonthlyInterestAmount() +
                "\n\t\tMonthly Interest rate: " + this.getMonthlyInterestRate();
    }
}

class CheckingAccount extends Account {
    private double limit;

    CheckingAccount() {
    }

    CheckingAccount(int i, double b, double ar, double lim) {
        super(i, b, ar);
        this.limit = lim;
    }

    public void withdraw(double amo) {
        if (super.getBalance() >= amo && limit >= amo) {
            super.setBalance(super.getBalance() - amo);
            System.out.println(amo + " successfully withdrawn from account: " + super.getID()
                    + " new super.getBalance(): " + super.getBalance() + ".");
        }
    }

    public String display() {
        return "Checking Account:\n\n\t\tAccount ID: " + super.getID() + "\n\t\tDate Created: " + super.getDateCreated()
                + "\n\t\tCurrent Balance: " + super.getBalance() + "\n\t\tAnnual Interest Rate: "
                + super.getAnnualInterestRate() + "\n\t\tMonthly Interest Amount: " + super.getMonthlyInterestAmount()
                + "\n\t\tOverdraft Limit: " + limit;
    }
}

class SavingAccount extends Account {
    private String cardNumber;
    private Calendar expireDate;

    SavingAccount() {
    }

    SavingAccount(int i, double b, double ar) {
        super(i, b, ar);
        expireDate = Calendar.getInstance();
        expireDate.add(Calendar.YEAR, 5);
        cardNumber = randomGen(16);
    }

    private String randomGen(int len) {
        String[] arr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String res = "";
        for (int i = 0; i < len; i++) {
            res += (int) (Math.random() * arr.length);
        }
        return res;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public double getCreditBalance() {
        return super.getBalance() * 3;
    }

    public String display() {
        return "Savings Account:\n" +
                "\n\t\tAccount ID: " + super.getID() +
                "\n\t\tDate Created: " + super.getDateCreated() +
                "\n\t\tCurrent Balance: " + super.getBalance() +
                "\n\t\tAnnual Interest Rate: " + super.getAnnualInterestRate() +
                "\n\t\tMonthly Interest Amount: " + super.getMonthlyInterestAmount() +
                "\n\t\tCredit Card Number: " + this.getCardNumber() +
                "\n\t\tCard Expiry Date: " + this.getExpireDate() +
                "\n\t\tCredit Balance: " + this.getCreditBalance();
    }
}

public class TestAccount {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Welcome to XYZ Bank Management.");

        int shifter = 30;
        while (shifter != -1) {
            switch (shifter) {
                case 1:

                    break;

                default:
                    System.out.println(
                            "\n\n\n\n\t\tPress (1) for creating a Checking Account\n" +
                                    "\t\tPress (2) for creating a Savings Account\n" +
                                    "\t\tPress (3) for Deposit to a Checking Account\n" +
                                    "\t\tPress (4) for Deposit to a Savings Account\n" +
                                    "\t\tPress (5) for Withdraw from a Checking Account\n" +
                                    "\t\tPress (6) for Withdraw from a Savings Account\n" +
                                    "\t\tPress (7) for Display all Accounts\n" +
                                    "\t\tPress (8) for Deposit to a Checking Account\n" +
                                    "\t\tPress (9) for Deposit to a Savings Account\n");
                    break;
            }
        }
    }
}
