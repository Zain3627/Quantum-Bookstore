public abstract class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private double price;
    private boolean isForSale;

    public Book(String isbn, String title, String author, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public String getIsbn() {
        return isbn;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book:\n" +
                "isbn: '" + isbn + '\'' +
                ", title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", publicationYear = " + publicationYear +
                ", price = " + price;
    }

}
