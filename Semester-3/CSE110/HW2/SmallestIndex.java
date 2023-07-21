package HW2;

import java.util.Scanner;

class SmallestIndex {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is finding the row with largest sum of a 2D array.\nEnter row number: ");
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
        int max = arr[0][0];
        int ir = 0;
        int ic = 0;
        for (int i = 0; i < r; i++) {
            int a = arr[i][0];
            int b = 0;
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > a) {
                    a = arr[i][j];
                    b = j;
                }
            }
            if (a > max) {
                max = a;
                ir = i;
                ic = b;
            }
        }
        System.out.println("The largest element is: " + max + " present in row " + (ir + 1) + " & column " + (ic + 1));
    }
}