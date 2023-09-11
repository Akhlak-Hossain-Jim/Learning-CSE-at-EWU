import java.util.Scanner;

public class Prob0 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = inp.nextLine();
        System.out.print("Enter your age: ");
        int age = inp.nextInt();
        System.out.print("Enter your CGPA: ");
        double cg = inp.nextDouble();
        System.out.print("Enter your department: ");
        inp.nextLine();
        String department = inp.nextLine();

        System.out.println();

        System.out.println("Your Name: " + name);
        System.out.println("Your Age: " + age);
        System.out.println("Your CGPA: " + cg);
        System.out.println("Your Department: " + department);
    }
}