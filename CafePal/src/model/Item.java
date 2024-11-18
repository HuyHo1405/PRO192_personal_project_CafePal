package model;

import util.IO;

public abstract class Item {

    // Declaration of properties
    protected String name;        // Name of the item (e.g., drink name, food name)
    protected boolean bestSeller; // Flag indicating if the item is a bestseller

    // Default constructor
    public Item() {
    }

    // Constructor with parameters for name and bestseller status
    public Item(String name, boolean bestSeller) {
        this.name = IO.capitalize(name);
        this.bestSeller = bestSeller;
    }

    // Getter for the name of the item
    public String getName() {
        return name;
    }

    // Setter for the name of the item
    public void setName(String name) {
        this.name = IO.capitalize(name);
    }

    // Getter for checking if the item is a bestseller
    public boolean isBestSeller() {
        return bestSeller;
    }

    // Setter for the bestseller flag
    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    // Override toString() to provide a formatted string representing the item
    @Override
    public String toString() {
        return String.format(" %-20s ",  // Format the string to be 20 characters wide
                name + (bestSeller ? " *" : "")); // If it's a bestseller, append "*" to the name
    }

}
