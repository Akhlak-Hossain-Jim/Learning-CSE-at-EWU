package lab5;

import java.util.Scanner;

class Icecream {

    private String icecreamType, icecreamCompany;
    private double icecreamPrice;

    Icecream() {
    }

    Icecream(String t, String c, double p) {
        icecreamType = t;
        icecreamCompany = c;
        icecreamPrice = p;
    }

    void setType(String t) {
        icecreamType = t;
    }

    String getType() {
        return icecreamType;
    }

    void setCompany(String c) {
        icecreamCompany = c;
    }

    String getCompany() {
        return icecreamCompany;
    }

    void setPrice(double p) {
        icecreamPrice = p;
    }

    double getPrice() {
        return icecreamPrice;
    }

    boolean equals(Icecream I) {
        return icecreamPrice == I.getPrice();
    }

    int compareTo(Icecream I) {
        if (icecreamPrice > I.getPrice()) {
            return 1;
        } else if (icecreamPrice == I.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }

    String display() {
        return "Icecream Type: " + icecreamType + ", Icecream Company: " + icecreamCompany + ", Icecream Pice: "
                + icecreamPrice;
    }
}

public class Searching {

    static Icecream[] IcecreamArray = new Icecream[5];

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        Icecream I1 = new Icecream();

        System.out.print("Enter the icecream type: ");
        String type = inp.nextLine();
        System.out.print("Enter the icecream company name: ");
        String com = inp.nextLine();
        System.out.print("Enter the icecream price: ");
        double price = inp.nextDouble();
        I1.setCompany(com);
        I1.setType(type);
        I1.setPrice(price);
        System.out.println(I1.display());

        inp.nextLine();
        System.out.print("Enter the icecream type: ");
        type = inp.nextLine();
        System.out.print("Enter the icecream company name: ");
        com = inp.nextLine();
        System.out.print("Enter the icecream price: ");
        price = inp.nextDouble();
        Icecream I2 = new Icecream(type, com, price);
        System.out.println(I2.display());

        System.out.println(I1.equals(I2));
        System.out.println(I1.compareTo(I2));
        for (int i = 0; i < IcecreamArray.length; i++) {
            IcecreamArray[i] = new Icecream();

            inp.nextLine();
            System.out.print("Enter the icecream type: ");
            String t = inp.nextLine();
            System.out.print("Enter the icecream company name: ");
            String c = inp.nextLine();
            System.out.print("Enter the icecream price: ");
            double p = inp.nextDouble();
            IcecreamArray[i].setCompany(c);
            IcecreamArray[i].setType(t);
            IcecreamArray[i].setPrice(p);
            System.out.println(IcecreamArray[i].display());
        }
        inp.nextLine();
        System.out.print("Enter a company name to search with: ");
        String name = inp.nextLine();
        System.out.println(name);
        searchByCompany(name);
    }

    static void searchByCompany(String name) {
        for (int i = 0; i < IcecreamArray.length; i++) {
            if (name.equals(IcecreamArray[i].getCompany())) {
                System.out.println(IcecreamArray[i].display());
            }
        }
    }
}
