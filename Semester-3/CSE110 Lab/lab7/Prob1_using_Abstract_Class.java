package lab7;

import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;

abstract class Account {
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

    public void deposit(double amo) {
        balance += amo;
        System.out.println(amo + " successfully deposited to account: " + ID + " new balance: " + balance + ".");
    }

    public abstract void withdraw(double amo);

    public abstract String display();
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
        return "Checking Account:\n\n\t\tAccount ID: " + super.getID() + "\n\t\tDate Created: "
                + super.getDateCreated().getTime()
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

    public void withdraw(double amo) {
        if (super.getBalance() * 3 >= amo && super.getBalance() >= amo) {
            super.setBalance(super.getBalance() - amo);
            System.out.println(amo + " successfully withdrawn from account: " + super.getID() + " new balance: "
                    + super.getBalance() + ".");
        }
    }

    public String display() {
        return "Savings Account:\n" +
                "\n\t\tAccount ID: " + super.getID() +
                "\n\t\tDate Created: " + super.getDateCreated().getTime() +
                "\n\t\tCurrent Balance: " + super.getBalance() +
                "\n\t\tAnnual Interest Rate: " + super.getAnnualInterestRate() +
                "\n\t\tMonthly Interest Amount: " + super.getMonthlyInterestAmount() +
                "\n\t\tCredit Card Number: " + this.getCardNumber() +
                "\n\t\tCard Expiry Date: " + this.getExpireDate().getTime() +
                "\n\t\tCredit Balance: " + this.getCreditBalance();
    }
}

public class Prob1_using_Abstract_Class {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Account> Accounts = new ArrayList<>();

        System.out.println("Welcome to XYZ Bank Management.");

        int shifter = 30;
        while (shifter != -1) {
            switch (shifter) {
                case 0:
                    System.out.println("\n\nExiting the program....");
                    shifter = -1;
                    break;
                case 1:
                    System.out.println("\n\n\n\n");
                    System.out.println("Creating a Checking Account, Enter below details:\n");
                    System.out.print("Enter Checking Account's ID: ");
                    int caID = inp.nextInt();
                    System.out.print("Enter Checking Account's Initial Balance: ");
                    double caBalance = inp.nextDouble();
                    System.out.print("Enter Checking Account's Annual Interest Rate: ");
                    double caAIR = inp.nextDouble();
                    System.out.print("Enter Checking Account's overdraft limit: ");
                    double caLim = inp.nextDouble();
                    Accounts.add(new CheckingAccount(caID, caBalance, caAIR, caLim));
                    System.out.println("\n\nChecking account with the ID of " + caID
                            + " successfully created.\nGetting back to main menu.");
                    shifter = 30;
                    break;
                case 2:
                    System.out.println("\n\n\n\n");
                    System.out.println("Creating a Savings Account, Enter below details:\n");
                    System.out.print("Enter Savings Account's ID: ");
                    int saID = inp.nextInt();
                    System.out.print("Enter Savings Account's Initial Balance: ");
                    double saBalance = inp.nextDouble();
                    System.out.print("Enter Savings Account's Annual Interest Rate: ");
                    double saAIR = inp.nextDouble();
                    Accounts.add(new SavingAccount(saID, saBalance, saAIR));
                    System.out.println("\n\nSavings account with the ID of " + saID
                            + " successfully created.\nGetting back to main menu.");
                    shifter = 30;
                    break;
                case 3:
                    System.out.println("\n\n\n\n");
                    System.out.println("Depositing to a Checking Account.\n");
                    System.out.print("Enter Checking Account's ID to search: ");
                    int caIDd = inp.nextInt();
                    boolean cadCan = false;
                    for (int i = 0; i < Accounts.size(); i++) {
                        if (Accounts.get(i).getID() == caIDd) {
                            System.out.print("Enter amount to deposit: ");
                            double dbl = inp.nextDouble();
                            Accounts.get(i).deposit(dbl);
                            cadCan = true;
                            System.out.println(
                                    "\n\nSuccessfully deposited amount " + dbl + " to Checking account: " + caIDd
                                            + " new balance: " + Accounts.get(i).getBalance()
                                            + ".\nGetting back to main menu.");
                            break;
                        }
                    }
                    if (!cadCan) {
                        System.out.println("\n\nNo Account found with the ID of " + caIDd
                                + ".\nGetting back to main menu.");
                    }
                    shifter = 30;
                    break;
                case 4:
                    System.out.println("\n\n\n\n");
                    System.out.println("Depositing to a Saving Account.\n");
                    System.out.print("Enter Saving Account's ID to search: ");
                    int saIDd = inp.nextInt();
                    boolean sadCan = false;
                    for (int i = 0; i < Accounts.size(); i++) {
                        if (Accounts.get(i).getID() == saIDd) {
                            System.out.print("Enter amount to deposit: ");
                            double dbl = inp.nextDouble();
                            Accounts.get(i).deposit(dbl);
                            cadCan = true;
                            System.out.println(
                                    "\n\nSuccessfully deposited amount " + dbl + " to Saving account: " + saIDd
                                            + " new balance: " + Accounts.get(i).getBalance()
                                            + ".\nGetting back to main menu.");
                            break;
                        }
                    }
                    if (!sadCan) {
                        System.out.println("\n\nNo Account found with the ID of " + saIDd
                                + ".\nGetting back to main menu.");
                    }
                    shifter = 30;
                    break;
                case 5:
                    System.out.println("\n\n\n\n");
                    System.out.println("Making withdraw from a Checking Account.\n");
                    System.out.print("Enter Checking Account's ID to search: ");
                    int caIDw = inp.nextInt();
                    boolean cawCan = false;
                    for (int i = 0; i < Accounts.size(); i++) {
                        if (Accounts.get(i).getID() == caIDw) {
                            System.out.print("Enter amount to withdraw: ");
                            double dbl = inp.nextDouble();
                            Accounts.get(i).withdraw(dbl);
                            cawCan = true;
                            System.out.println(
                                    "\n\nSuccessfully withdrawn amount " + dbl + " from Checking account: " + caIDw
                                            + " new balance: " + Accounts.get(i).getBalance()
                                            + ".\nGetting back to main menu.");
                            break;
                        }
                    }
                    if (!cawCan) {
                        System.out.println("\n\nNo Account found with the ID of " + caIDw
                                + ".\nGetting back to main menu.");
                    }
                    shifter = 30;
                    break;
                case 6:
                    System.out.println("\n\n\n\n");
                    System.out.println("Making withdraw from a Saving Account.\n");
                    System.out.print("Enter Saving Account's ID to search: ");
                    int saIDw = inp.nextInt();
                    boolean sawCan = false;
                    for (int i = 0; i < Accounts.size(); i++) {
                        if (Accounts.get(i).getID() == saIDw) {
                            System.out.print("Enter amount to withdraw: ");
                            double dbl = inp.nextDouble();
                            Accounts.get(i).withdraw(dbl);
                            cadCan = true;
                            System.out.println(
                                    "\n\nSuccessfully withdrawn amount " + dbl + " From Savings account: " + saIDw
                                            + " new balance: " + Accounts.get(i).getBalance()
                                            + ".\nGetting back to main menu.");
                            break;
                        }
                    }
                    if (!sawCan) {
                        System.out.println("\n\nNo Account found with the ID of " + saIDw
                                + ".\nGetting back to main menu.");
                    }
                    shifter = 30;
                    break;
                case 7:
                    System.out.println("\n\n\n");
                    for (int i = 0; i < Accounts.size(); i++) {
                        System.out.println(Accounts.get(i).display());
                    }
                    shifter = 30;
                    break;
                default:
                    System.out.print(
                            "\n\n\n\n\t\tPress (1) for creating a Checking Account\n" +
                                    "\t\tPress (2) for creating a Savings Account\n" +
                                    "\t\tPress (3) for Deposit to a Checking Account\n" +
                                    "\t\tPress (4) for Deposit to a Savings Account\n" +
                                    "\t\tPress (5) for Withdraw from a Checking Account\n" +
                                    "\t\tPress (6) for Withdraw from a Savings Account\n" +
                                    "\t\tPress (7) for Display all Accounts\n" +
                                    "\t\tPress (0) to exit the program.\n\nChoose an option to continue: ");
                    shifter = inp.nextInt();
                    break;
            }
        }
        inp.close();
    }
}
