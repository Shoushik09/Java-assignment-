abstract class LibraryItem {

    protected String title;
    protected int itemId;
    protected boolean isIssued;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isIssued = false;
    }

    // Abstract method
    abstract int calculateFine(int daysLate);

    // Concrete method
    public void displayInfo() {
        System.out.println("Title : " + title);
        System.out.println("Item ID : " + itemId);
        System.out.println("Issued : " + isIssued);
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }
}


// Interface
interface Issuable {

    void issueItem();

    void returnItem();
}


// Book class
class Book extends LibraryItem implements Issuable {

    public Book(String title, int itemId) {
        super(title, itemId);
    }

    @Override
    int calculateFine(int daysLate) {
        return daysLate * 5;
    }

    @Override
    public void issueItem() {
        isIssued = true;
    }

    @Override
    public void returnItem() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " (Book)";
    }
}


// Magazine class
class Magazine extends LibraryItem implements Issuable {

    public Magazine(String title, int itemId) {
        super(title, itemId);
    }

    @Override
    int calculateFine(int daysLate) {
        return daysLate * 2;
    }

    @Override
    public void issueItem() {
        isIssued = true;
    }

    @Override
    public void returnItem() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " (Magazine)";
    }
}


// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Book book1 = new Book("Java Programming", 101);
        Book book2 = new Book("Clean Code", 102);

        Magazine magazine1 = new Magazine("National Geographic", 201);
        Magazine magazine2 = new Magazine("Time Magazine", 202);

        // Issue items
        book1.issueItem();
        book2.issueItem();
        magazine1.issueItem();
        magazine2.issueItem();

        // Polymorphic array
        LibraryItem[] items = {
                book1,
                magazine1,
                book2,
                magazine2
        };

        int[] lateDays = {4, 4, 2, 2};

        // Runtime polymorphism
        for (int i = 0; i < items.length; i++) {

            int fine = items[i].calculateFine(lateDays[i]);

            System.out.println(
                    "Item : " + items[i]
                    + " | Fine for " + lateDays[i]
                    + " days late : Rs." + fine
            );
        }

        // Return items
        book1.returnItem();
        book2.returnItem();
        magazine1.returnItem();
        magazine2.returnItem();
    }
}