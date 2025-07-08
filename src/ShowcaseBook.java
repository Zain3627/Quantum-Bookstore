public class ShowcaseBook extends Book{
    public ShowcaseBook(String isbn, String title, String author, int publicationYear, double price) {
        super(isbn, title, author, publicationYear, price);
        setForSale(false);
    }

    public ShowcaseBook(String isbn) {
        super(isbn);
    }

    @Override
    public String toString() {
        return super.toString() +
                " ,is not for sale";
    }
}
