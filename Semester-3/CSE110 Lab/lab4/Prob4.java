package lab4;

import java.util.Scanner;
import java.util.Arrays;

public class Prob4 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the number of elements you wanna sort: ");
        int n = inp.nextInt();
        String[] arr = new String[n];
        inp.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + i + "th string: ");
            arr[i] = inp.nextLine();
        }
        Arrays.sort(arr);
        for (String el : arr) {
            System.out.println(el);
        }
    }
}