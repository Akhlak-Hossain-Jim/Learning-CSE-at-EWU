import java.util.Scanner;

class IllegalTriangleException extends Exception {
    IllegalTriangleException(String s) {
        super(s);
    }
}

abstract class GeometricObject {
    String color;
    boolean filled = false;

    GeometricObject() {
    }

    GeometricObject(String c, boolean f) {
        color = c;
        filled = f;
    }

    abstract double getArea();

    abstract double getPerimeter();
}

class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    Triangle() {
    }

    Triangle(double a, double b, double c) throws IllegalTriangleException {
        if (a + b > c) {
            side1 = a;
            side2 = b;
            side3 = c;
        } else {
            throw new IllegalTriangleException(
                    "Triangle sides are not valid, 'In a valid triangle, if you add any two sides then it will be greater than the third side.'\nContinuing with default sides, which is '1.0'");
        }
    }

    Triangle(double a, double b, double c, String co, boolean f) throws IllegalTriangleException {
        super(co, f);
        if (a + b > c) {
            side1 = a;
            side2 = b;
            side3 = c;
        } else {
            throw new IllegalTriangleException(
                    "Triangle sides are not valid, 'In a valid triangle, if you add any two sides then it will be greater than the third side.'\nContinuing with default sides, which is '1.0'");
        }
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double a = s * (s - side1) * (s - side2) * (s - side3);
        return Math.sqrt(a);
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

public class Prob4 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("We are creating a triangle.\nEnter side a of the triangle: ");
        double a = inp.nextDouble();
        System.out.print("Enter side b of the triangle: ");
        double b = inp.nextDouble();
        System.out.print("Enter side c of the triangle: ");
        double c = inp.nextDouble();
        System.out.print("Enter the color of the triangle: ");
        String co = inp.next();
        System.out.print("Enter if the triangle is filled:(true/false) ");
        boolean f = inp.nextBoolean();
        Triangle obj = new Triangle();
        try {
            Triangle obj1 = new Triangle(a, b, c, co, f);
            obj = obj1;
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(obj.toString());
        System.out.println("The area of the triangle is: " + obj.getArea());
        System.out.println("The Perimeter of the triangle is: " + obj.getPerimeter());
        System.out.println("Color of the triangle is: " + obj.color);
        if (obj.filled)
            System.out.println("The triangle is filled.");
        else
            System.out.println("The triangle is not field.");
        inp.close();
    }
}
