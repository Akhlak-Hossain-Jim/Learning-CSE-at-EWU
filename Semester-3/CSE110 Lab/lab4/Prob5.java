package lab4;

import java.util.Scanner;

public class Prob5 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the 2D array length: ");
        int n = inp.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter the item for row " + i + " column " + j + " : ");
                arr[i][j] = inp.nextInt();
            }
        }

        System.out.print("Enter the column number you want to sort by: ");
        int s = inp.nextInt();

        System.out.println("The " + n + "x" + n + " array before sort:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][s] > arr[j + 1][s]) {
                    int[] a = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = a;
                }
            }
        }

        System.out.println("The " + n + "x" + n + " array after sort:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}