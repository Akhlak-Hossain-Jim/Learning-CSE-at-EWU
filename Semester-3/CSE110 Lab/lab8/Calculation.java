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

public class Calculation {
    public static void main(String[] args) {
        Calculator obj1 = new Calculator(2, 0);
        Calculator obj2 = new Calculator(-2, 0);
        Calculator obj3 = new Calculator(2, 3);
        Calculator obj4 = new Calculator(2, 0);
        obj1.Add();
        obj2.Subtract();
        obj3.Multiply();
        obj4.Division();
    }
}
