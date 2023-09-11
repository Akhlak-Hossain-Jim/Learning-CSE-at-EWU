import java.util.Scanner;

class Prob4 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print(
                "This program is converting USD to BDT and BDT to USD.\nOptions:\n0. USD to BDT\n1. BDT to USD\nChoose an option between (0-1): ");
        int op = inp.nextInt();
        double usdV = 108.42;
        if (op == 0) {
            System.out.print("Enter USD amount: ");
            int am = inp.nextInt();
            System.out.print(am + " USD = " + (am * usdV) + " BDT");
        } else if (op == 1) {
            System.out.print("Enter BDT amount: ");
            int am = inp.nextInt();
            System.out.print(am + " BDT = " + (am / usdV) + " USD");
        } else
            System.out.print("You have chosen a wrong option.");
    }
}