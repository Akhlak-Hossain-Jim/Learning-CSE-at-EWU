package Lab3;

import java.util.Scanner;

class Prob6 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is sorting students biased on their number.\nEnter the number of student: ");
        int n = inp.nextInt();
        String[] name = new String[n];
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + " th student's name: ");
            inp.nextLine();
            name[i] = inp.nextLine();
            System.out.print("Enter " + (i + 1) + " th student's number: ");
            score[i] = inp.nextInt();
        }
        for (int j = 1; j < n; j++) {
            for (int k = 0; k < n - j; k++) {
                if (score[k] < score[k + 1]) {
                    int a = score[k];
                    score[k] = score[k + 1];
                    score[k + 1] = a;

                    String b = name[k];
                    name[k] = name[k + 1];
                    name[k + 1] = b;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("name: " + name[i] + "\t Number: " + score[i]);
        }
    }
}