import java.util.ArrayList;

public class InventoryManagement {
    private ArrayList<Book> books;
    private static InventoryManagement instance;

    private InventoryManagement() {
        books = new ArrayList<Book>();
    }

    public static InventoryManagement getInstance() {
        if (instance == null) {
            instance = new InventoryManagement();
        }
        return instance;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) throws BookStoreException {
            if(book == null) {
                throw new BookStoreException("Book cannot be null");
            }
            for(int i=0; i<getInstance().getBooks().size();i++){
                if(getInstance().getBooks().get(i).getIsbn().equals(book.getIsbn())) {
                    throw new BookStoreException("Book with ISBN " + book.getIsbn() + " already exists in the inventory");
                }
            }
            getInstance().getBooks().add(book);
            System.out.println("Successfully added the following book to the inventory \n" + book);
    }
    public void removeBook(String isbn) throws BookStoreException {
        if(isbn == null) {
            throw new BookStoreException("this book is not found in the inventory");
        }
        for(int i = 0; i < getInstance().getBooks().size(); i++) {
            if (getInstance().getBooks().get(i).getIsbn().equals(isbn)) {
                System.out.println("Successfully removed the following book from the inventory \n" + getInstance().getBooks().get(i));
                getInstance().getBooks().remove(i);
                return;
            }
        }
        throw new BookStoreException("Book with ISBN " + isbn + " not found in the inventory");

    }

    public ArrayList<Book> removeOutdatedBook(int year) throws BookStoreException {
        if(year <= 0) {
            throw new BookStoreException("Year should be a valid positive value");
        }
        ArrayList<Book> outDatedBooks = new ArrayList<Book>();
        for(int i = getInstance().getBooks().size()-1; i >= 0 ; i--) {
            if (getInstance().getBooks().get(i).getPublicationYear() < year) {
                outDatedBooks.add(getInstance().getBooks().get(i));
                System.out.println("Successfully removed the following book from the inventory \n" + getInstance().getBooks().get(i));
                getInstance().getBooks().remove(i);
            }
        }
        if(outDatedBooks.isEmpty()) {
            System.out.println("No outdated books found in the inventory");
            return null;
        }
        else {
            return outDatedBooks;
        }
    }

    public Book findBook(String isbn){
        for(int i=0; i< getInstance().getBooks().size();i++){
            if(getInstance().getBooks().get(i).getIsbn().equals(isbn)) {
                System.out.println("Found book with " + isbn);
                System.out.println(getInstance().getBooks().get(i).toString());
                return getInstance().getBooks().get(i);
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found in the inventory");
        return null;
    }
    public double buyBook(String isbn, int quantity, String email, String address) throws BookStoreException {
        if (quantity <= 0) {
            throw new BookStoreException("Can't purchase a book with negative value");
        }
        for(int i=0; i < getInstance().getBooks().size(); i++){
            if(getInstance().getBooks().get(i).getIsbn().equals(isbn)) {
                Book book = getInstance().getBooks().get(i);
                if(book instanceof PaperBook){
                    PaperBook paperBook = (PaperBook) book;
                    if(paperBook.getStock() < quantity){
                        throw new BookStoreException("Not enough stock available for book with ISBN: " + book.getIsbn());
                    }
                    else {
                        paperBook.setStock(paperBook.getStock() - quantity);
                        ShippingService.send(paperBook.getIsbn(), address);
                        System.out.println("Successfully bought " + quantity + " copies of the book: " + book.getTitle() + " to be shipped to " + address);
                        return book.getPrice() * quantity;
                    }
                }
                else if(book instanceof EBook){
                        EBook eBook = (EBook) book;
                        MailService.send(email, eBook.getIsbn());
                        System.out.println("Successfully bought " + quantity + " copies of the book: " + eBook.getTitle() + " to be emailed to " + email);
                        return eBook.getPrice() * quantity;

                }
                else if(book instanceof ShowcaseBook){
                    throw new BookStoreException("Cannot buy a Showcase/Demo book");
                }
                else {
                    throw new BookStoreException("Invalid book type");
                }
            }
        }
        throw new BookStoreException("Book with ISBN " + isbn + " not found in the inventory");
    }
}
