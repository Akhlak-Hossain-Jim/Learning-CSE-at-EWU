package HW2;

import java.util.Scanner;

class Initializing2DArray {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is taking inputs to initialize a 2D array and printing it.\nEnter row number: ");
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
    }
}