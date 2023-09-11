import java.util.Scanner;

public class Prob3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is finding two roots of a quadratic equation.\nEnter a, b, c: ");
        double a = inp.nextDouble();
        double b = inp.nextDouble();
        double c = inp.nextDouble();
        double iden = (b * b) - (4 * a * c);
        double eq = Math.pow(iden, 0.5);
        double x1 = ((-b) + eq) / (2 / a);
        double x2 = ((-b) - eq) / (2 / a);
        System.out.print("The equation has two roots " + x1 + " and " + x2);
    }
}