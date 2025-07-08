public class QuantumBookstoreTest {
    public static void main(String[] args) {
        System.out.println("------------------------Quantum Bookstore Test------------------------\n");
        InventoryManagement inventory = InventoryManagement.getInstance();
        System.out.println("1) Test Book Addition\n");
        try {
            PaperBook paperBook1 = new PaperBook("1", "Fawry first book", "Zain Tamer", 2017, 40.15, 50);
            PaperBook paperBook2 = new PaperBook("2", "Fawry second book", "Ahmed Ahmed", 2004, 59.99, 25);
            inventory.addBook(paperBook1);
            inventory.addBook(paperBook2);

            EBook eBook1 = new EBook("3", "Fawry third book", "Mohammed Mahmoud", 2013, 29.99, "PDF");
            inventory.addBook(eBook1);

            ShowcaseBook showcaseBook1 = new ShowcaseBook("4", "Fawry fourth book", "Charles Dickens", 2005, 42.99);
            inventory.addBook(showcaseBook1);

            System.out.println("\nTotal books in inventory: " + inventory.getBooks().size());
        } catch (BookStoreException e) {
            System.out.println("Error adding books: " + e.getMessage());
        }

        System.out.println("\n2) Test Duplicate Book addition\n");

        try {
            PaperBook duplicateBook = new PaperBook("1", "Duplicate Book", "Test Author", 2020, 25.99, 10);
            inventory.addBook(duplicateBook);
        } catch (BookStoreException e) {
            System.out.println("Expected error caught: " + e.getMessage());
        }

        System.out.println("\n3) Test Book Search\n");
        Book find1 = inventory.findBook("1");
        Book find2 = inventory.findBook("10");

        System.out.println("\n4) Test Book Purchase");
        try {
            System.out.println("a)  Buy PaperBook");
            double paperBookCost = inventory.buyBook("1", 3, "zaintamer10@gmail.com", "Alexandria");
            System.out.println("Paper book total cost: $" + paperBookCost);

            System.out.println("b)  Buy EBook");
            double eBookCost = inventory.buyBook("3", 1, "Ahmed@email.com", "Tanta");
            System.out.println("EBook total cost: $" + eBookCost);

            try {
                inventory.buyBook("4", 1, "Mohammed@email.com", "Cairo");
            } catch (BookStoreException e) {
                System.out.println("Expected error for showcase book: " + e.getMessage());
            }

            try {
                inventory.buyBook("1", 30, "zaintamer10@gmail.com", "Alexandria");
            } catch (BookStoreException e) {
                System.out.println("Expected error for insufficient stock: " + e.getMessage());
            }

            try {
                inventory.buyBook("3", -1, "Zeyad@email.com", "Giza");
            } catch (BookStoreException e) {
                System.out.println("Expected error for negative quantity: " + e.getMessage());
            }

        } catch (BookStoreException e) {
            System.out.println("Error during purchase: " + e.getMessage());
        }

        System.out.println("\n5) Test Removing Outdated Books\n");

        try {
            System.out.println("Removing books published before 2010");
            inventory.removeOutdatedBook(2010);
            System.out.println("Books remaining in inventory: " + inventory.getBooks().size());

            try {
                inventory.removeOutdatedBook(-1);
            } catch (BookStoreException e) {
                System.out.println("Expected error for invalid year: " + e.getMessage());
            }

        } catch (BookStoreException e) {
            System.out.println("Error removing outdated books: " + e.getMessage());
        }

        // Test 6: Remove Specific Book
        System.out.println("\n6) Test Book removal by using ISBN");
        try {
            inventory.removeBook("1");

            try {
                inventory.removeBook("4");
            } catch (BookStoreException e) {
                System.out.println("Expected error for non-existent book: " + e.getMessage());
            }

        } catch (BookStoreException e) {
            System.out.println("Error during book removal: " + e.getMessage());
        }

        // Test 7: Final Inventory Status
        System.out.println("\n7) Final Inventory Stats\n");

        System.out.println("Final inventory size: " + inventory.getBooks().size());
        System.out.println("\nRemaining books:");
        for (Book book : inventory.getBooks()) {
            System.out.println("- " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
        }

        System.out.println("\n------------------------Test Complete------------------------");
    }
}