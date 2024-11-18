package GUI;

import java.util.ArrayList;

public class Option extends ArrayList<String> {  // Option class extends ArrayList to hold a list of menu options

    private final String name = "OPTION";  // The name of this option list (not used further in the code)

    // Constructor initializes the Option list by loading predefined options
    public Option() {
        this.loadSavedOption();  // Load saved options when an Option object is created
    }

    // Private method to load predefined options into the list
    private void loadSavedOption() {
        // Add each option to the list (these are the menu choices)
        this.add("Close menu");
        this.add("Show ordered list");
        this.add("Add purchased item");
        this.add("Remove purchased item");
        this.add("Cancel order");
        this.add("Pay the bill");
    }

    // Method to display all the options in the list with their index
    public void displayOption() {
        System.out.println("OPTIONS");
        // Loop through the list and print each option with its index
        for (int i = 0; i < this.size(); i++) {
            System.out.println(String.format("%d. %s.", i, this.get(i)));
        }
    }

    // Static method to create and return a new Option object
    public static Option getOption() {
        return new Option();  // Return a new Option object
    }
}
