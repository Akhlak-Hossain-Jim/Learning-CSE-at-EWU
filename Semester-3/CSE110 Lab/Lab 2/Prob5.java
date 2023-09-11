import java.util.Scanner;

class Prob5 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("This program is finding if a point is inside the circle.\nEnter a point x,y: ");
        int p = inp.nextInt();
        int q = inp.nextInt();
        System.out.print("Enter the radius, r: ");
        int r = inp.nextInt();
        double d = Math.pow(((p * p) + (q * q)), 0.5);
        if (d <= r)
            System.out.print("Point (" + p + ", " + q + ") is inside of the circle with r=" + r + " radius.");
        else
            System.out.print("Point (" + p + ", " + q + ") is outside of the circle with r=" + r + " radius.");
    }
}