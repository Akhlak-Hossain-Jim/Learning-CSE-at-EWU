package lab4;

import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println(
                "This program randomly fills in 0s and 1s into a 4-by-4 matrix, prints the matrix, and finds the first row and column with the most 1s.");
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int a = (int) (Math.random() * 2);
                arr[i][j] = a;
                System.out.print(a);
            }
            System.out.println();
        }
        int maxR = 0;
        int iR = 0;
        for (int i = 0; i < 4; i++) {
            int max = 0;
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 1)
                    max++;
            }
            if (max > maxR) {
                maxR = max;
                iR = i;
            }
        }
        int maxC = 0;
        int iC = 0;
        for (int i = 0; i < 4; i++) {
            int max = 0;
            for (int j = 0; j < 4; j++) {
                if (arr[j][i] == 1)
                    max++;
            }
            if (max > maxC) {
                maxC = max;
                iC = i;
            }
        }
        System.out.print("The largest row index:\t" + iR + "\nThe largest column index:\t" + iC);
    }
}