package lab4;

import java.util.Scanner;

public class Prob2 {
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void checkPass(String str) {
        boolean ind = false;
        int digits = 0;
        if (str.length() >= 8) {
            ind = true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)) == true)
                ind = true;
            else if (isInt(String.valueOf(str.charAt(i)))) {
                digits++;
                ind = true;
            } else {
                ind = false;
                break;
            }
        }
        if (ind && digits >= 2)
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print(
                "This program checks whether a string is a valid password. Suppose the password rules are as follows:\n- A password must have at least eight characters.\n- A password consists of only letters and digits.\n- A password must contain at least two digits.\nEnter your password: ");
        String pass = inp.nextLine();
        checkPass(pass);
    }
}