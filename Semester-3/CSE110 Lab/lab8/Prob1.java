import java.util.Scanner;

class Calculator {
    private int x;
    private int y;

    Calculator(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public int Add() {
        int res = 0;
        try {
            if (x < 0 || y < 0) {
                ArithmeticException e = new ArithmeticException(
                        "Any of the variables are less than 0. Can't add the numbers");
                throw e;
            } else {
                res = x + y;
            }
        } catch (ArithmeticException e) {
            System.out.print(e);
        }
        return res;
    }

    public int Subtract() {
        int res = 0;
        try {
            if (x < 0 || y < 0) {
                ArithmeticException e = new ArithmeticException(
                        "Any of the variables are less than 0. Can't subtract the numbers");
                throw e;
            } else {
                res = x - y;
            }
        } catch (ArithmeticException e) {
            System.out.print(e);
        }
        return res;
    }

    public int Multiply() {
        int res = 0;
        try {
            if (x == 0 || y == 0) {
                ArithmeticException e = new ArithmeticException(
                        "Any of the variables are 0. Can't perform multiplication the numbers.");
                throw e;
            } else {
                res = x * y;
            }
        } catch (ArithmeticException e) {
            System.out.print(e);
        }
        return res;
    }

    public int Division() {
        int res = 0;
        try {
            if (x == 0 || y == 0) {
                ArithmeticException e = new ArithmeticException(
                        "Any of the variables are 0. Can't perform division the numbers.");
                throw e;
            } else {
                res = x / y;
            }
        } catch (ArithmeticException e) {
            System.out.print(e);
        }
        return res;
    }
}

public class Prob1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int x, y;
        System.out.print("Enter two space separated integer to perform addition: ");
        try {
            x = Integer.parseInt(inp.next());
            y = Integer.parseInt(inp.next());
            Calculator obj1 = new Calculator(x, y);
            System.out.println(obj1.Add());
        } catch (NumberFormatException e) {
            System.out.print(e);
        }
        System.out.print("Enter two space separated integer to perform subtraction: ");
        try {
            x = Integer.parseInt(inp.next());
            y = Integer.parseInt(inp.next());
            Calculator obj2 = new Calculator(x, y);
            System.out.println(obj2.Subtract());
        } catch (NumberFormatException e) {
            System.out.print(e);
        }
        System.out.print("Enter two space separated integer to perform multiplication: ");
        try {
            x = Integer.parseInt(inp.next());
            y = Integer.parseInt(inp.next());
            Calculator obj3 = new Calculator(x, y);
            System.out.println(obj3.Multiply());
        } catch (NumberFormatException e) {
            System.out.print(e);
        }
        System.out.print("Enter two space separated integer to perform division: ");
        try {
            x = Integer.parseInt(inp.next());
            y = Integer.parseInt(inp.next());
            Calculator obj4 = new Calculator(x, y);
            System.out.println(obj4.Division());
        } catch (NumberFormatException e) {
            System.out.print(e);
        }
        inp.close();
    }
}
