package model;

import itemModel.Size;
import itemModel.Drink;
import itemModel.Combo;
import java.util.ArrayList;
import util.IO;

public class Section extends ArrayList<Item> {

    // Declaration of instance variables
    private SectionCategory category;  // The category this section belongs to (e.g., Drink, Food, Combo)
    private Class<?> itemType;         // The class type of the items in this section (e.g., Drink.class, Food.class)
    private String name;               // Name of the section (e.g., "Traditional Coffee")
    private String id;                 // ID of the section (e.g., "CFF" for Traditional Coffee)

    // Constructor that initializes the section using a SectionCategory
    public Section(SectionCategory category) {
        this.category = category;  // Set the category of the section
        this.itemType = this.category.getItemType();  // Set the item type based on the category
        this.name = this.category.getName();  // Set the name of the section
        this.id = this.category.getID();  // Set the ID of the section
    }

    // Method to display the items in this section
    public void display() {
        // Declare variable to store the length for formatting
        int len;

        // If the section has items, display them with the header and footer
        if (!this.isEmpty()) {
            // Calculate the length for formatting based on the first item in the section
            len = (String.format(" %3s-%02d%s", id, 0, this.get(0))).length();

            // Print the section header
            System.out.println(IO.header(name, len, '='));

            // If the items in this section are Drinks or Combos, display the size options (Small, Medium, Large)
            if (itemType == Drink.class || itemType == Combo.class) {
                System.out.println(
                        String.format(" %6s %20s %2s %2s %2s ",
                                "", "",
                                Size.getShortName(Size.SMALL),
                                Size.getShortName(Size.MEDIUM),
                                Size.getShortName(Size.LARGE)
                        ));
            }

            // Print each item in the section, formatted with an ID and index
            for (Item x : this) {
                System.out.println(String.format(" %3s-%02d%s", id, this.indexOf(x), x));
            }

            // Print the section footer
            System.out.println(IO.footer(len, '-'));

        } else {
            // If the section is empty, display a "N/A" message
            len = 10;
            System.out.println(IO.header(name, len, '='));
            System.out.println(" N/A");
            System.out.println(IO.footer(len, '-'));
        }
    }

    // Method to add an item to the section
    public void addItem(Item item) {

        // Check if the item is of the correct type (based on itemType)
        if (itemType.isInstance(item)) {
            // If the item is a Drink, ensure it is not faulty
            if (item instanceof Drink) {
                if (!((Drink) item).getStatus()) {
                    this.add(item);  // Add the item if it is valid
                }
            }
            // If the item is a Combo, ensure it is not faulty
            else if (item instanceof Combo) {
                if (!((Combo) item).getStatus()) {
                    this.add(item);  // Add the item if it is valid
                }
            }
            // If the item is neither a Drink nor a Combo, just add it directly
            else {
                this.add(item);
            }
        }
    }

    // Getter for the category of the section
    public SectionCategory getCategory() {
        return category;
    }

    // Getter for the item type of the section (Drink, Food, Combo, etc.)
    public Class<?> getItemType() {
        return itemType;
    }

    // Getter for the name of the section
    public String getName() {
        return name;
    }

    // Getter for the ID of the section
    public String getId() {
        return id;
    }

    // Setter for the ID of the section
    public void setId(String id) {
        this.id = id;
    }

    // Setter for the name of the section
    public void setName(String name) {
        this.name = name;
    }

    // Setter for the category of the section
    public void setCategory(SectionCategory category) {
        this.category = category;
    }

}
