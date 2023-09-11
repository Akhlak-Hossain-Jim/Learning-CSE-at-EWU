package lab5;

import java.util.Scanner;

class IceCream {

    private String iceCreamType, iceCreamCompany;
    private double iceCreamPrice;

    public IceCream() {
    }

    public IceCream(String t, String c, double p) {
        iceCreamType = t;
        iceCreamCompany = c;
        iceCreamPrice = p;
    }

    public void setType(String t) {
        iceCreamType = t;
    }

    public String getType() {
        return iceCreamType;
    }

    public void setCompany(String c) {
        iceCreamCompany = c;
    }

    public String getCompany() {
        return iceCreamCompany;
    }

    public void setPrice(double p) {
        iceCreamPrice = p;
    }

    public double getPrice() {
        return iceCreamPrice;
    }

    public boolean equals(IceCream I) {
        return iceCreamPrice == I.getPrice();
    }

    public int compareTo(IceCream I) {
        if (iceCreamPrice > I.getPrice()) {
            return 1;
        } else if (iceCreamPrice == I.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }

    public String display() {
        return "IceCream Type: " + iceCreamType + ", IceCream Company: " + iceCreamCompany + ", IceCream Pice: "
                + iceCreamPrice;
    }
}

public class Prob0 {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        IceCream I1 = new IceCream();

        System.out.print("Enter the iceCream type: ");
        String type = inp.nextLine();
        System.out.print("Enter the iceCream company name: ");
        String com = inp.nextLine();
        System.out.print("Enter the iceCream price: ");
        double price = inp.nextDouble();
        I1.setCompany(com);
        I1.setType(type);
        I1.setPrice(price);
        System.out.println(I1.display());

        inp.nextLine();
        System.out.print("Enter the iceCream type: ");
        type = inp.nextLine();
        System.out.print("Enter the iceCream company name: ");
        com = inp.nextLine();
        System.out.print("Enter the iceCream price: ");
        price = inp.nextDouble();
        IceCream I2 = new IceCream(type, com, price);
        System.out.println(I2.display());

        System.out.println(I1.equals(I2));
        System.out.println(I1.compareTo(I2));

        IceCream[] IceCreamArray = new IceCream[5];

        for (int i = 0; i < IceCreamArray.length; i++) {
            IceCreamArray[i] = new IceCream();

            inp.nextLine();
            System.out.print("Enter the iceCream type: ");
            String t = inp.nextLine();
            System.out.print("Enter the iceCream company name: ");
            String c = inp.nextLine();
            System.out.print("Enter the iceCream price: ");
            double p = inp.nextDouble();
            IceCreamArray[i].setCompany(c);
            IceCreamArray[i].setType(t);
            IceCreamArray[i].setPrice(p);
            System.out.println(IceCreamArray[i].display());
        }
    }
}
