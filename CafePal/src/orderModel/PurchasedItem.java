package orderModel;

import itemModel.*;
import java.util.Objects;

public class PurchasedItem extends Food {  // PurchasedItem extends the Food class to inherit food-related properties

    private String id;  // Unique identifier for the purchased item
    private int quantity;  // Quantity of the purchased item
    private Size size;  // Size of the purchased item, if applicable (for items like drinks or combos)

    // Default constructor
    public PurchasedItem() {
    }

    // Constructor to initialize a purchased item with id, name, quantity, size, and price
    public PurchasedItem(String id, String name, int quantity, Size size, int price) {
        super(name, false, price);  // Call the superclass constructor to initialize food properties
        this.id = id;
        this.quantity = quantity;
        this.size = size;
    }

    // Setters and getters for the properties
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Size getSize() {
        return size;
    }

    // Method to return a string representation of the purchased item
    @Override
    public String toString() {
        return String.format(
                " %-6s %-20s %8s %02d %d ",  // Format: ID, name, size (if applicable), quantity, price
                id,
                name,
                (size == null)
                        ? ""  // If no size, leave blank
                        : String.format("[Size:%s]", Size.getShortName(size)),  // Format size if applicable
                quantity,
                super.getPrice()  // Call superclass method to get the price
        );
    }

    // Override equals() to compare two PurchasedItem objects based on id, size, and name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {  // Check if the objects are the same
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {  // Check if the object is null or of a different class
            return false;
        }
        PurchasedItem other = (PurchasedItem) obj;
        // Check if the id, size, and name are the same for both items
        return id.equals(other.id) && size == other.size && name.equals(other.name);
    }

    // Override hashCode() to generate a hash based on id, size, and name
    @Override
    public int hashCode() {
        return Objects.hash(id, size, name);  // Generate hash code using id, size, and name
    }

    // Method to format the item details for removal (used when displaying items to remove from the order)
    public String removingInfo() {
        return String.format(
                " %-20s %8s %02d %d ",  // Format: name, size (if applicable), quantity, price
                name,
                (size == null)
                        ? ""  // If no size, leave blank
                        : String.format("[Size:%s]", Size.getShortName(size)),  // Format size if applicable
                quantity,
                super.getPrice()  // Call superclass method to get the price
        );
    }

    // Method to return a short description of the item for displaying (excluding price and quantity)
    public String info() {
        return String.format(
                "%s%s",  // Format: name and size (if applicable)
                name,
                (size == null)
                        ? ""  // If no size, leave blank
                        : String.format(" [Size:%s]", Size.getShortName(size))  // Format size if applicable
        );
    }
}
