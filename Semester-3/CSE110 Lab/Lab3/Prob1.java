package Lab3;

import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is assigning grade based on height marks.\nEnter the number of students: ");
        int n = inp.nextInt();
        int[] arr = new int[n];
        int max = 0;
        System.out.print("Enter " + n + " scores: ");
        for (int i = 0; i < n; i++) {
            arr[i] = inp.nextInt();
            if (arr[i] > max)
                max = arr[i];
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= max - 10)
                System.out.println("Student " + i + " score is " + arr[i] + " and grade is A");
            else if (arr[i] >= max - 20)
                System.out.println("Student " + i + " score is " + arr[i] + " and grade is B");
            else if (arr[i] >= max - 30)
                System.out.println("Student " + i + " score is " + arr[i] + " and grade is C");
            else if (arr[i] >= max - 40)
                System.out.println("Student " + i + " score is " + arr[i] + " and grade is D");
            else
                System.out.println("Student " + i + " score is " + arr[i] + " and grade is F");
        }
    }
}