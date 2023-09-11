package Lab3;

import java.util.Scanner;

class Prob3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is checking if input is Palindrome or not.\nEnter your input: ");
        int num = inp.nextInt();
        int ent = num;
        String ns = Integer.toString(num);
        int n = ns.length();
        int[] arr = new int[n];
        int[] Rarr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = num % 10;
            num = num / 10;
        }
        num = ent;
        for (int i = n - 1; i >= 0; i--) {
            Rarr[i] = num % 10;
            num = num / 10;
        }
        boolean ind = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] != Rarr[i]) {
                ind = false;
                break;
            } else
                ind = true;
        }
        if (ind)
            System.out.print("Your input " + ent + " is a Palindrome.");
        else
            System.out.print("Your input " + ent + " is not a Palindrome.");
    }
}