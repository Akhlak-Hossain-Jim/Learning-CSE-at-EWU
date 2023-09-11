package Lab3;

import java.util.Scanner;

class Prob4 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is printing unique values.\nEnter 10 numbers: ");
        int[] arr = new int[10];
        int[] set = new int[10];
        int i;
        int j = 0;
        for (i = 0; i < 10; i++) {
            int x = inp.nextInt();
            arr[i] = x;
            int f = 0;
            for (int el : set) {
                if (arr[i] == el) {
                    f = 1;
                    break;
                }
            }
            if (f == 0) {
                set[j] = arr[i];
                j++;
            }
        }
        System.out.print("Unique inputs: ");
        for (int el : set) {
            if (el != 0)
                System.out.print(el + " ");
        }
    }
}