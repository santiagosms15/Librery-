import java.io.Console;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Console console = System.console();

        if (console == null) {
            System.out.println("No console available.");
            System.exit(1);
        }

        int option = 0;
        do {
            console.printf("%nLibrary Management System%n");
            console.printf("------------------------%n");
            console.printf("1. Add a book to the library%n");
            console.printf("2. Borrow a book%n");
            console.printf("3. Return a book%n");
            console.printf("4. Display available books%n");
            console.printf("5. Exit%n");
            console.printf("------------------------%n");
            console.printf("Enter your choice: ");

            option = Integer.parseInt(console.readLine());

            switch (option) {
                case 1:
                    addBookToLibrary(console, library);
                    break;
                case 2:
                    borrowBookFromLibrary(console, library);
                    break;
                case 3:
                    returnBookToLibrary(console, library);
                    break;
                case 4:
                    displayAvailableBooks(console, library);
                    break;
                case 5:
                    console.printf("Exiting Library Management System.%n");
                    break;
                default:
                    console.printf("Invalid choice. Please enter a number between 1 and 5.%n");
            }
        } while (option != 5);
    }

    private static void addBookToLibrary(Console console, Library library) {
        console.printf("Enter book ID: ");
        int id = Integer.parseInt(console.readLine());

        console.printf("Enter book title: ");
        String title = console.readLine();

        console.printf("Enter book author: ");
        String author = console.readLine();

        console.printf("Enter publication year: ");
        int publicationYear = Integer.parseInt(console.readLine());

        console.printf("Enter number of pages: ");
        int numberOfPages = Integer.parseInt(console.readLine());

        Book newBook = new Book(id, title, author, publicationYear, numberOfPages);
        library.addBook(newBook);

        console.printf("Book added successfully.%n");
    }

    private static void borrowBookFromLibrary(Console console, Library library) {
        console.printf("Enter the ID of the book you want to borrow: ");
        int id = Integer.parseInt(console.readLine());

        library.borrowBook(id);
        console.printf("Book borrowed successfully.%n");
    }

    private static void returnBookToLibrary(Console console, Library library) {
        console.printf("Enter book ID: ");
        int id = Integer.parseInt(console.readLine());

        console.printf("Enter book title: ");
        String title = console.readLine();

        console.printf("Enter book author: ");
        String author = console.readLine();

        console.printf("Enter publication year: ");
        int publicationYear = Integer.parseInt(console.readLine());

        console.printf("Enter number of pages: ");
        int numberOfPages = Integer.parseInt(console.readLine());

        Book returnedBook = new Book(id, title, author, publicationYear, numberOfPages);
        library.returnBook(returnedBook);

        console.printf("Book returned successfully.%n");
    }

    private static void displayAvailableBooks(Console console, Library library) {
        List<Book> availableBooks = library.getAllBooks();

        if (availableBooks.isEmpty()) {
            console.printf("No books available in the library.%n");
        } else {
            console.printf("Available books in the library:%n");
            for (Book book : availableBooks) {
                console.printf("ID: %d, Title: %s, Author: %s, Publication Year: %d, Number of Pages: %d%n",
                        book.getId(), book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getNumberOfPages());
            }
        }
    }
}
