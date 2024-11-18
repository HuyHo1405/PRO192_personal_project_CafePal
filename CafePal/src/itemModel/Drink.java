package itemModel;

import java.util.HashMap;
import java.util.Map;
import model.Item;

public class Drink extends Item {  // Drink class extends Item, representing a drink item with different sizes and prices

    // Declaration of class variables
    private final Map<Size, Integer> price;  // A map to store the price of the drink based on size
    private final boolean isFaulty;  // A flag to indicate if the drink has mismatched size and price arrays
    private final Size[] size = Drink.getSize();  // The sizes available for the drink (from the static method)

    // Constructor to initialize a Drink with name, bestseller status, and an array of prices
    public Drink(String name, boolean bestSeller, int[] price) {
        super(name, bestSeller);  // Call the parent constructor to set the name and bestseller status
        this.price = new HashMap<>();  // Initialize the price map

        // Populate the price map with sizes and corresponding prices from the input array
        for (int i = 0; i < size.length; i++) {
            this.price.put(size[i], price[i]);
        }

        // Check if the size and price arrays match in length, indicating a valid drink
        if (size.length != price.length) {
            this.isFaulty = true;  // Mark as faulty if there's a mismatch
        } else {
            this.isFaulty = false;  // Otherwise, the drink is valid
        }
    }

    // Getter methods
    public Map<Size, Integer> getPrice() {
        return price;  // Return the map of prices based on size
    }

    public boolean getStatus() {
        return isFaulty;  // Return whether the drink is faulty (mismatch between size and price arrays)
    }

    // Override the toString method to display the drink details, including the price for each size
    @Override
    public String toString() {
        return String.format("%s%s",  // Combine the string from the parent class and price format
                super.toString(),
                priceFormat());
    }

    // Method to get the price of the drink for a specific size
    public int getPriceBySize(Size size) {
        return price.get(size);  // Return the price corresponding to the given size
    }

    // Format the prices for each size into a string
    private String priceFormat() {
        StringBuilder str = new StringBuilder();
        for (Size x : Size.getSize()) {  // Loop through each size
            str.append(String.format("%2d ", getPriceBySize(x)));  // Append the price for each size
        }
        return str.toString();  // Return the formatted price string
    }

    // Static method to get the available sizes for the drink
    public static Size[] getSize() {
        return Size.getSize();  // Return the available sizes from the Size class
    }
}
