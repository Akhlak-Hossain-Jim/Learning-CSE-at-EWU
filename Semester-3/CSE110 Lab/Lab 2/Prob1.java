import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is finding if the given number is divisible by 2 or 3.\nEnter the number: ");
        int num = inp.nextInt();
        if ((num % 2 == 0 || num % 3 == 0) && !(num % 2 == 0 && num % 3 == 0))
            System.out.print("TRUE");
        else
            System.out.print("FALSE");
    }
}