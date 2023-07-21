package HW2;

import java.util.Scanner;

class MostRowSum {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is finding the row with largest sum of a 2D array.\nEnter row number: ");
        int r = inp.nextInt();
        System.out.print("Enter Column number: ");
        int c = inp.nextInt();
        int[][] arr = new int[r][c];
        int[] row = new int[r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("Enter element for row " + (i + 1) + " column " + (j + 1) + " : ");
                arr[i][j] = inp.nextInt();
            }
        }
        System.out.println("The 2D Array:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
        for (int i = 0; i < r; i++) {
            int sumC = 0;
            for (int j = 0; j < c; j++) {
                sumC += arr[i][j];
            }
            row[i] = sumC;
        }
        int max = row[0];
        int in = 0;
        for (int i = 0; i < r; i++) {
            if (row[i] > max) {
                max = row[i];
                in = i;
            }
        }
        System.out.println("Row " + (in + 1) + " has the largest sum, which is: " + row[in]);
    }
}