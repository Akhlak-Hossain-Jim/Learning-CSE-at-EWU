package lab5;

import java.util.Scanner;

class Book {
    private int isbn, numberOfPages;
    private static int count;
    String bookTitle;

    public Book(int is, String ti, int n) {
        this.isbn = is;
        this.bookTitle = ti;
        this.numberOfPages = n;
        updateCount();
    }

    public Book() {
        updateCount();
    }

    static private void updateCount() {
        count++;
    }

    String display() {
        return "Book Name: " + bookTitle + "\nISBN: " + isbn + "\nNumber of Pages: " + numberOfPages;
    }

    int compareTo(Book b) {
        if (this.numberOfPages > b.numberOfPages)
            return 1;
        else if (this.numberOfPages == b.numberOfPages)
            return 0;
        else
            return -1;
    }

    static int getCount() {
        return count;
    }

    int getNumberOfPages() {
        return numberOfPages;
    }
}

public class Prob2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the total number of book information you want to add: ");
        int n = inp.nextInt();
        Book[] bookArray = new Book[n];
        for (int i = 0; i < bookArray.length; i++) {
            inp.nextLine();
            System.out.print("Enter the " + (i + 1) + "th Book's name: ");
            String na = inp.nextLine();
            System.out.print("Enter the " + (i + 1) + "th Book's ISBN: ");
            int isbn = inp.nextInt();
            System.out.print("Enter the " + (i + 1) + "th Book's total pages: ");
            int pages = inp.nextInt();
            bookArray[i] = new Book(isbn, na, pages);
        }
        displayAll(bookArray);
        System.out.println("Compareing 1st and second book page information.");
        System.out.println(bookArray[0].compareTo(bookArray[1]));
        System.out.println("Chaking if the 3rd book is heavier.");
        System.out.println(isHeavier(bookArray[3]));
    }

    static void displayAll(Book[] ba) {
        for (int i = 0; i < ba.length; i++) {
            System.out.println(ba[i].display());
        }
    }

    static boolean isHeavier(Book b) {
        return b.getNumberOfPages() > 500;
    }
}
