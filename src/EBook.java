public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, int publicationYear, double price, String fileType) {
        super(isbn, title, author, publicationYear, price);
        this.fileType = fileType;
        setForSale(true);
    }

    public EBook(String isbn) {
        super(isbn);
    }

    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public void mailEBook(String recipient, String ISBN){
        System.out.println("Still working on email details");
    }

    @Override
    public String toString() {
        return super.toString() +
                " ,fileType: '" + fileType + '\'';
    }


}
