package HW2;

import java.util.Scanner;

class ColSum {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is summing all elements by column of a 2D array.\nEnter row number: ");
        int r = inp.nextInt();
        System.out.print("Enter Column number: ");
        int c = inp.nextInt();
        int[][] arr = new int[r][c];
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
        for (int i = 0; i < c; i++) {
            int sumC = 0;
            for (int j = 0; j < r; j++) {
                sumC += arr[j][i];
            }
            System.out.println("Sum of column " + (i + 1) + " elements is: " + sumC);
        }
    }
}