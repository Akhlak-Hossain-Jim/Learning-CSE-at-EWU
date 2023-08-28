package LabTest;

import java.util.ArrayList;
import java.util.Scanner;

class Author {

    private int authorId;
    private String authorName;
    private String authorCountry;

    public Author() {
    }

    public Author(int i, String an, String ac) {
        this.authorId = i;
        this.authorName = an;
        this.authorCountry = ac;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public String toString() {
        return "\nAuthor Information\nAuthor ID: " + this.authorId + "\nAuthor Name: " + this.authorName
                + "\nAuthor Country: " + this.authorCountry;
    }
}

class Book {

    private int ISBN;
    private String BookTitle;
    private double BookPrice;
    private ArrayList<Author> authorList = new ArrayList<Author>();
    private Publisher publisher;
    private int numberOfAuthors = 0;

    public Book() {
    }

    public Book(int isbn, String t, double p) {
        this.ISBN = isbn;
        this.BookTitle = t;
        this.BookPrice = p;
    }

    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    public void setBookTitle(String bookTitle) {
        BookTitle = bookTitle;
    }

    public void setBookPrice(double bookPrice) {
        BookPrice = bookPrice;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public double getBookPrice() {
        return BookPrice;
    }

    public int getNumberOfAuthors() {
        return numberOfAuthors;
    }

    public void addAuthor(Author author) {
        this.authorList.add(author);
        numberOfAuthors++;
    }

    public void addPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void dropAuthor(int id) {
        for (int i = 0; i < authorList.size(); i++) {
            if (this.authorList.get(i).getAuthorId() == id) {
                this.authorList.remove(i);
                numberOfAuthors--;
                break;
            }
        }
    }

    public void dropPublisher() {
        this.publisher = null;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public ArrayList<Author> getAuthorList() {
        return authorList;
    }

    public String printPublisher() {
        if (this.publisher != null) {
            return this.publisher.toString();
        } else
            return "No publisher added yet.";
    }

    public String printAuthorList() {
        String s = "";
        for (int i = 0; i < authorList.size(); i++) {
            s += authorList.get(i).toString();
        }
        return s;
    }

    public String toString() {
        return "\nBook Information\nISBN: " + this.ISBN + "\nBook Title: " + this.BookTitle + "\nBook Price: "
                + this.BookPrice;
    }
}

class Publisher {

    private int PublisherID;
    private String PublisherName, PublisherCountry;

    public Publisher() {
    }

    public Publisher(int id, String n, String c) {
        this.PublisherID = id;
        this.PublisherName = n;
        this.PublisherCountry = c;
    }

    public void setPublisherID(int publisherID) {
        PublisherID = publisherID;
    }

    public void setPublisherName(String publisherName) {
        PublisherName = publisherName;
    }

    public void setPublisherCountry(String publisherCountry) {
        PublisherCountry = publisherCountry;
    }

    public int getPublisherID() {
        return PublisherID;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public String getPublisherCountry() {
        return PublisherCountry;
    }

    public String toString() {
        return "\nPublisher Information\nPublisher ID: " + this.PublisherID + "\nPublisher Name: " + this.PublisherName
                + "\nPublisher Country: " + this.PublisherCountry;
    }

}

public class LabTest_aklhak {

    public static Scanner input = new Scanner(System.in);

    public static ArrayList<Author> Authors = new ArrayList<Author>();
    public static ArrayList<Book> Books = new ArrayList<Book>();
    public static ArrayList<Publisher> Publishers = new ArrayList<Publisher>();

    public static void main(String[] args) {
        System.out.println("Welcome to the book store.");
        System.out.print("How many authors you want to add: ");
        int AuthorCount = input.nextInt();
        for (int i = 0; i < AuthorCount; i++) {
            System.out.print("Enter Author's ID: ");
            int aid = input.nextInt();
            System.out.print("Enter Author's Name: ");
            input.nextLine();
            String aName = input.nextLine();
            System.out.print("Enter Author's Country: ");
            String aCountry = input.nextLine();
            Authors.add(new Author(aid, aName, aCountry));
            System.out.println((i + 1) + "th Author successfully added");
        }
        System.out.print("How many Publishers you want to add: ");
        int PublisherCount = input.nextInt();
        for (int i = 0; i < PublisherCount; i++) {
            System.out.print("Enter Publisher's ID: ");
            int id = input.nextInt();
            System.out.print("Enter Publisher's Name: ");
            input.nextLine();
            String Name = input.nextLine();
            System.out.print("Enter Publisher's Country: ");
            String Country = input.nextLine();
            Publishers.add(new Publisher(id, Name, Country));
            System.out.println((i + 1) + "th Publisher successfully added");
        }
        System.out.print("How many Books you want to add: ");
        int BookCount = input.nextInt();
        for (int i = 0; i < BookCount; i++) {
            System.out.print("Enter Book's ISBN: ");
            int id = input.nextInt();
            System.out.print("Enter Book's Title: ");
            input.nextLine();
            String Name = input.nextLine();
            System.out.print("Enter Book's Price: ");
            double price = input.nextDouble();
            Books.add(new Book(id, Name, price));

            System.out.print("Enter Author's Id: ");
            int aid = input.nextInt();
            boolean f = false;
            for (int j = 0; j < Authors.size(); j++) {
                if (Authors.get(j).getAuthorId() == aid) {
                    f = true;
                    System.out.println("Author Found");
                    Books.get(i).addAuthor(Authors.get(j));
                    System.out.println("Author successfully added to the book");
                    break;
                }
            }
            if (!f) {
                System.out.println("No author found with the ID of: " + aid);
            }
            System.out.println((i + 1) + "th Book successfully added");
        }

        // test
        for (int i = 0; i < Authors.size(); i++) {
            System.out.println(Authors.get(i).toString());
        }
        for (int i = 0; i < Publishers.size(); i++) {
            System.out.println(Publishers.get(i).toString());
        }
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i).toString());
            System.out.println(Books.get(i).printAuthorList());
        }

        // code
        System.out.print("Enter a book ISBN to drop author: ");
        int bID = input.nextInt();
        for (int i = 0; i < Publishers.size(); i++) {
            if (Books.get(i).getISBN() == bID) {
                System.out.println("Book Found");
                System.out.print("Enter a Author ID to drop author: ");
                int aid = input.nextInt();
                for (int j = 0; j < Authors.size(); j++) {
                    if (Authors.get(j).getAuthorId() == aid) {
                        System.out.println("Author Found");
                        Books.get(i).dropAuthor(aid);
                        System.out.println("Author successfully droped from the book");
                        break;
                    }
                }
                break;
            }
        }

        // test
        for (int i = 0; i < Authors.size(); i++) {
            System.out.println(Authors.get(i).toString());
        }
        for (int i = 0; i < Publishers.size(); i++) {
            System.out.println(Publishers.get(i).toString());
        }
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i).toString());
            System.out.println(Books.get(i).printAuthorList());
            System.out.println(Books.get(i).printPublisher());
        }

        // code
        System.out.print("Enter a book ISBN to add Publisher: ");
        bID = input.nextInt();
        for (int i = 0; i < Publishers.size(); i++) {
            if (Books.get(i).getISBN() == bID) {
                System.out.println("Book Found");
                System.out.print("Enter a Publisher ID to add Publisher: ");
                int aid = input.nextInt();
                for (int j = 0; j < Publishers.size(); j++) {
                    if (Publishers.get(j).getPublisherID() == aid) {
                        System.out.println("Publisher Found");
                        Books.get(i).addPublisher(Publishers.get(j));
                        System.out.println("Publisher successfully added to the book");
                        break;
                    }
                }
                break;
            }
        }

        // test
        for (int i = 0; i < Authors.size(); i++) {
            System.out.println(Authors.get(i).toString());
        }
        for (int i = 0; i < Publishers.size(); i++) {
            System.out.println(Publishers.get(i).toString());
        }
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i).toString());
            System.out.println(Books.get(i).printAuthorList());
            System.out.println(Books.get(i).printPublisher());
        }

        // code
        System.out.print("Enter a book ISBN to drop Publisher: ");
        bID = input.nextInt();
        for (int i = 0; i < Publishers.size(); i++) {
            if (Books.get(i).getISBN() == bID) {
                System.out.println("Book Found");
                System.out.print("Enter a Publisher ID to drop Publisher: ");
                int aid = input.nextInt();
                for (int j = 0; j < Publishers.size(); j++) {
                    if (Publishers.get(j).getPublisherID() == aid) {
                        System.out.println("Publisher Found");
                        Books.get(i).dropPublisher();
                        System.out.println("Publisher successfully droped from the book");
                        break;
                    }
                }
                break;
            }
        }

        // test
        for (int i = 0; i < Authors.size(); i++) {
            System.out.println(Authors.get(i).toString());
        }
        for (int i = 0; i < Publishers.size(); i++) {
            System.out.println(Publishers.get(i).toString());
        }
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i).toString());
            System.out.println(Books.get(i).printAuthorList());
            System.out.println(Books.get(i).printPublisher());
        }

        // code
        System.out.print("Enter a book ISBN to search: ");
        bID = input.nextInt();
        searchBooks(bID);

        System.out.print("Enter a publisher's ID to search books: ");
        bID = input.nextInt();
        showBooksByPublisher(bID);

        System.out.print("Enter a author's ID to update: ");
        bID = input.nextInt();
        updateAuthor(bID);

        // test
        for (int i = 0; i < Authors.size(); i++) {
            System.out.println(Authors.get(i).toString());
        }
        for (int i = 0; i < Publishers.size(); i++) {
            System.out.println(Publishers.get(i).toString());
        }
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i).toString());
            System.out.println(Books.get(i).printAuthorList());
            System.out.println(Books.get(i).printPublisher());
        }
    }

    public static void searchBooks(int ISBN) {
        boolean f = false;
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).getISBN() == ISBN) {
                System.out.println("Book Found");
                System.out.println(Books.get(i).toString());
                System.out.println(Books.get(i).printAuthorList());
                System.out.println(Books.get(i).printPublisher());
                f = true;
                break;
            }
        }
        if (!f) {
            System.out.println("No book found with the ISBN of: " + ISBN);
        }
    }

    public static void showBooksByPublisher(int pID) {
        System.out.println("Found Books:");
        int in = 0;
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).getPublisher().getPublisherID() == pID) {
                System.out.print("Books ISBN: ");
                System.out.println(Books.get(i).getISBN());
                System.out.print("Books Title: ");
                System.out.println(Books.get(i).getBookTitle());
                in++;
            }
        }
        if (in == 0) {
            System.out.println("No published book found by the publisher.");
        }
    }

    public static void updateAuthor(int aID) {
        boolean f = false;
        for (int i = 0; i < Publishers.size(); i++) {
            if (Authors.get(i).getAuthorId() == aID) {
                f = true;
                System.out.println("Author Found");
                System.out.print("Enter Author's new Name: ");
                input.nextLine();
                String name = input.nextLine();
                Authors.get(i).setAuthorName(name);
                System.out.print("Enter Author's new Country: ");
                String country = input.nextLine();
                Authors.get(i).setAuthorCountry(country);
                System.out.println("Author's name & country successfully updated");
                break;
            }
        }
        if (!f) {
            System.out.println("No author found with the ID of: " + aID);
        }
    }
}
