import java.util.Scanner;

public class Prob2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is finding Year and days.\nEnter the number of minutes: ");
        int num = inp.nextInt();
        int days = num / (24 * 60);
        int year = days / 365;
        System.out.print(num + " minutes is approximately " + year + " years and " + (days % 365) + " days.");
    }
}