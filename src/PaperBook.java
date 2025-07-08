public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int publicationYear, double price, int stock) {
        super(isbn, title, author, publicationYear, price);
        this.stock = stock;
        setForSale(true);
    }

    public PaperBook(String isbn) {
        super(isbn);
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void shipBook(String isbn, String address){
        System.out.println("Still working on shipping details");
    }

    @Override
    public String toString() {
        return super.toString() +
                " ,stock = " + stock;
    }


}
