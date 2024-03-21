public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private int numberOfPages;

    public Book(int id, String title, String author, int publicationYear, int numberOfPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
