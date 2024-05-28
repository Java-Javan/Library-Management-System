import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int selection = 0;

        while(selection != 5) {

            System.out.println("\nEnter a number between 1 - 5 to access the function you would like to use. \n");
            System.out.println("1) Add a new book to the records");
            System.out.println("2) Remove a book from the records");
            System.out.println("3) Update a book");
            System.out.println("4) Display all books in the records");
            System.out.println("5) Exit app\n");

            System.out.print("Enter your selection(1 - 5): ");
            selection = scanner.nextInt();
            System.out.println();


            switch(selection) {

                case 1 -> addBook(scanner);
                case 2 -> removeBook(scanner);
                case 3 -> updateBooks(scanner);
                case 4 -> allBooks();
                case 5 -> exitMessage();

            }
        }


    } //end main() method

    //Adding a book into the database
    public static void addBook(Scanner scanner) {

        int id;
        String title, author, genre;

       try{

           System.out.print("Enter the book ID: ");
           id = scanner.nextInt();
           scanner.nextLine();
           System.out.println();

           System.out.print("Enter the title of the book: ");
           title = scanner.nextLine();
           System.out.println();

           System.out.print("Enter the authors name: ");
           author = scanner.nextLine();
           System.out.println();

           System.out.print("Enter the books Genre: ");
           genre = scanner.nextLine();
           System.out.println();

           Book book1 = new Book(id, title, author, genre);

           bookCRUD.addBook(book1);

           System.out.println("The book has been Added...\n");

       }catch(Exception e) {

           e.printStackTrace();

       }
    }

    //remove books from the database
    public static void removeBook(Scanner scanner) {

        int id;

        try {

            System.out.print("Enter the ID of the book you would like to remove: ");
            id = scanner.nextInt();

            bookCRUD.removeBook(id);

            System.out.println("\nThe book has been removed...\n");

        }catch(Exception e) {

            e.printStackTrace();
        }
    }

    //Update a book in the database
    public static void updateBooks(Scanner scanner) {

        int id;
        String title, author, genre;

        try {

            System.out.print("Enter the ID update: ");
            id = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            System.out.print("Enter the Title update: ");
            title = scanner.nextLine();
            System.out.println();

            System.out.print("Enter the author update: ");
            author = scanner.nextLine();
            System.out.println();

            System.out.print("Enter the genre update: ");
            genre = scanner.nextLine();

            Book updateBook = new Book(id, title, author, genre);

            bookCRUD.updateBook(updateBook);

            System.out.println("Your book had been updated...\n");

        }catch(Exception e) {

            e.printStackTrace();
        }
    }

    // Display all books
    public static void allBooks() {

        try{
            //Print all books from out List using for each loop
            for(Book books : bookCRUD.allBooks()) {

                System.out.println(books);

            }
            System.out.println();

        }catch(Exception e) {

            e.printStackTrace();

        }

    }

    //Exit the app
    public static void exitMessage() {

        System.out.println("Library Closed....\n");

    }

} // end Main class