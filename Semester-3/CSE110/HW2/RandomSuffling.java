package HW2;

import java.util.Scanner;

class RandomShuffling {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is randomly shuffling a 2D array.\nEnter row number: ");
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
        for (int i = 0; i < r; i++) {
            int a = (int) (Math.random() * r);
            int[] b = arr[i];
            arr[i] = arr[a];
            arr[a] = b;
            for (int j = 0; j < c; j++) {
                int aa = (int) (Math.random() * c);
                int bb = arr[i][j];
                arr[i][j] = arr[i][aa];
                arr[i][aa] = bb;
            }
        }

        System.out.println("The randomly shuffled 2D Array:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}