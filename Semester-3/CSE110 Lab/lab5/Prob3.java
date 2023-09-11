package lab5;

import java.util.Scanner;

class Fraction {
    private int numerator, denominator;

    String sumO, subO, mulO, divO;

    public Fraction(int nu, int de) {
        this.numerator = nu;
        this.denominator = de;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public String display() {
        return numerator + " / " + denominator;
    }

    public void add(Fraction f) {
        this.sumO = (this.numerator * f.getDenominator()) + (f.getNumerator() * denominator) + " / "
                + (denominator * f.getDenominator());
    }

    public void sub(Fraction f) {
        this.subO = ((this.numerator * f.getDenominator()) - (f.getNumerator() * denominator)) + " / "
                + (denominator * f.getDenominator());
    }

    public void multiplication(Fraction f) {
        this.mulO = ((this.numerator * f.getNumerator())) + " / " + (denominator * f.getDenominator());
    }

    public void division(Fraction f) {
        divO = ((this.numerator * f.getDenominator())) + " / " + (denominator * f.getNumerator());
    }
}

public class Prob3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the numerator for the 1st fraction: ");
        int n = inp.nextInt();
        System.out.print("Enter the denominator for the 1st fraction: ");
        int d = inp.nextInt();
        Fraction f1 = new Fraction(n, d);
        System.out.print("Enter the numerator for the 2nd fraction: ");
        n = inp.nextInt();
        System.out.print("Enter the denominator for the 2nd fraction: ");
        d = inp.nextInt();
        Fraction f2 = new Fraction(n, d);
        System.out.println(f1.display());
        System.out.println(f2.display());
        System.out.println("Calculating Sum of 1st & 2nd fraction");
        f1.add(f2);
        System.out.println(f1.sumO);
        System.out.println("Calculating Subtraction of 1st & 2nd fraction");
        f1.sub(f2);
        System.out.println(f1.subO);
        System.out.println("Calculating Multiplication of 1st & 2nd fraction");
        f1.multiplication(f2);
        System.out.println(f1.mulO);
        System.out.println("Calculating Division of 1st & 2nd fraction");
        f1.division(f2);
        System.out.println(f1.divO);
    }
}
