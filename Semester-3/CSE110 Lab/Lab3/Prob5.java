package Lab3;

import java.util.Scanner;

class Prob5 {
    static void maximum(int[] arr) {
        int max = arr[0];
        int in = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                in = i;
                max = arr[i];
            }
        }
        System.out.println("The highest element is " + max + " with index of " + in);
    }

    static void minimum(int[] arr) {
        int min = arr[0];
        int in = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                in = i;
                min = arr[i];
            }
        }
        System.out.println("The smallest element is " + min + " with index of " + in);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println(
                "This program is generating a random array with 100 elements and finding the highest and smallest value with index.");
        int[] arr = new int[100];
        System.out.println("Generating a random array with 100 elements.");
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * 100);
            arr[i] = x;
        }
        System.out.println(
                "A random array with 100 elements is successfully generated.\nFinding the highest and smallest value with index.");
        maximum(arr);
        minimum(arr);
    }
}