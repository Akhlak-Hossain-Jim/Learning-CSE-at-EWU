package Lab3;

import java.util.Scanner;

class Prob2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is counting repeated numbers.\nEnter the integers between 1 to 100: ");
        int[] arr = new int[100];
        int[] set = new int[100];
        int i = 0;
        int j = 0;
        for (;;) {
            int x = inp.nextInt();
            if (x == 0)
                break;

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
            i++;
        }
        for (int el : set) {
            int count = 0;
            for (int k : arr) {
                if (el == k)
                    count++;
            }
            if (el == 0)
                break;
            if (count > 1)
                System.out.println(el + " occurs " + count + " times");
            else
                System.out.println(el + " occurs " + count + " time");
        }
    }
}