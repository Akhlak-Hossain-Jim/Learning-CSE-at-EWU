
import java.util.Scanner;

class Circle {
    double radius;

    void input(double r) {
        radius = r;
    }

    void display() {
        System.out.println("Radius: " + radius + "Area: " + area());
    }

    double area() {
        return 3.1416 * radius * radius;
    }

    void checkArea(Circle c2) {
        if (area() == c2.area())
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }

    boolean checkRadius(Circle c2) {
        if (radius == c2.radius)
            return true;
        else
            return false;
    }
}

public class Lecture5 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Circle c1;
        c1 = new Circle();
        System.out.print("Enter 1st object's r: ");
        double r1 = inp.nextDouble();
        c1.input(r1);
        c1.display();
        Circle[] c2 = new Circle[10];
        for (int i = 0; i < c2.length; i++) {
            System.out.print("Taking " + (i + 1) + " elements r: ");
            c2[i] = new Circle();
            double r = inp.nextDouble();
            c2[i].input(r);
        }
        c1.checkArea(c2[0]);
        checkArea(c1, c2[2]);
        System.out.println(c1.checkRadius(c2[3]));
    }

    public static void checkArea(Circle c1, Circle c2) {
        if (c1.area() == c2.area())
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}