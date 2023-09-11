package lab4;

import java.util.Scanner;

public class Prob3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[][] arr = new int[8][7];
        String[] w = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        int[] total = new int[8];
        int[] ind = { 0, 1, 2, 3, 4, 5, 6, 7 };
        for (int i = 0; i < 8; i++) {
            int s = 0;
            for (int j = 0; j < 7; j++) {
                System.out.print("Enter Employee" + i + "'s for " + w[j] + ": ");
                arr[i][j] = inp.nextInt();
                s += arr[i][j];
            }
            total[i] = s;
        }
        System.out.println("\t");
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 8 - i; j++) {
                if (total[j] < total[j + 1]) {
                    int a = total[j];
                    total[j] = total[j + 1];
                    total[j + 1] = a;

                    int b = ind[j];
                    ind[j] = ind[j + 1];
                    ind[j + 1] = b;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("Employee" + ind[i] + " with " + total[i] + " hours of work in the week.");
        }
    }
}