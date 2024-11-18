package itemModel;

import model.Item;

public class Food extends Item {  // Food class extends Item, representing a food item with a price

    // Declaration of class variables
    private int price;  // The price of the food item

    // Default constructor (no parameters)
    public Food() {
    }

    // Constructor to initialize a food item with name, bestseller status, and price
    public Food(String name, boolean bestSeller, int price) {
        super(name, bestSeller);  // Call the parent constructor to set the name and bestseller status
        this.price = price;  // Set the price of the food item
    }

    // Getter for price
    public int getPrice() {
        return price;  // Return the price of the food item
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;  // Set the price of the food item
    }

    // Override the toString method to display the food item details, including the price
    @Override
    public String toString() {
        return String.format("%s%2d ",  // Combine the string from the parent class with the price
                super.toString(),
                price);
    }

}
