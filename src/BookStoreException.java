public class BookStoreException extends Exception {
    private String message;

    public BookStoreException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
