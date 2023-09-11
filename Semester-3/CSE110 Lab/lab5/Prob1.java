package lab5;

import java.util.Scanner;

class IceCream {

    private String iceCreamType, iceCreamCompany;
    private double iceCreamPrice;

    IceCream() {
    }

    IceCream(String t, String c, double p) {
        iceCreamType = t;
        iceCreamCompany = c;
        iceCreamPrice = p;
    }

    void setType(String t) {
        iceCreamType = t;
    }

    String getType() {
        return iceCreamType;
    }

    void setCompany(String c) {
        iceCreamCompany = c;
    }

    String getCompany() {
        return iceCreamCompany;
    }

    void setPrice(double p) {
        iceCreamPrice = p;
    }

    double getPrice() {
        return iceCreamPrice;
    }

    boolean equals(IceCream I) {
        return iceCreamPrice == I.getPrice();
    }

    int compareTo(IceCream I) {
        if (iceCreamPrice > I.getPrice()) {
            return 1;
        } else if (iceCreamPrice == I.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }

    String display() {
        return "IceCream Type: " + iceCreamType + ", IceCream Company: " + iceCreamCompany + ", IceCream Pice: "
                + iceCreamPrice;
    }
}

public class Prob1 {

    static IceCream[] IceCreamArray = new IceCream[5];

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
        inp.nextLine();
        System.out.print("Enter a company name to search with: ");
        String name = inp.nextLine();
        System.out.println(name);
        searchByCompany(name);
    }

    static void searchByCompany(String name) {
        for (int i = 0; i < IceCreamArray.length; i++) {
            if (name.equals(IceCreamArray[i].getCompany())) {
                System.out.println(IceCreamArray[i].display());
            }
        }
    }
}
