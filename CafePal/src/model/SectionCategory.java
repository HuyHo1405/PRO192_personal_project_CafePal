package model;

import itemModel.Food;
import itemModel.Drink;
import itemModel.Combo;

public enum SectionCategory {
    // Enum constants for different sections of the menu, each associated with a category (Drink, Food, Combo)
    CFF("Traditional Coffee", Drink.class),  // Drink section for Traditional Coffee
    PHD("Phindi", Drink.class),              // Drink section for Phindi
    TEA("Tea", Drink.class),                 // Drink section for Tea
    FRZ("Freeze", Drink.class),              // Drink section for Freeze
    SWE("Sweet Pastry", Food.class),         // Food section for Sweet Pastry
    SAV("Savory Pastry", Food.class),        // Food section for Savory Pastry
    CMB("Combo", Combo.class);               // Combo section for Combo items

    // Instance variables for the enum
    private final String name;  // Name of the section (e.g., "Traditional Coffee")
    private final Class<? extends Item> itemType;  // Class type of the items in this section (Drink, Food, Combo)

    // Constructor for initializing the name and item type for each enum constant
    private SectionCategory(String name, Class<? extends Item> itemType) {
        this.name = name;  // Assign the section name (e.g., "Traditional Coffee")
        this.itemType = itemType;  // Assign the corresponding class type (e.g., Drink.class)
    }

    // Getter for the itemType, which returns the class type of items in this section
    public Class<? extends Item> getItemType() {
        return itemType;
    }

    // Getter for the name of the section (e.g., "Traditional Coffee")
    public String getName() {
        return name;
    }

    // Getter for the ID of the section, which is simply the enum constant name (e.g., "CFF")
    public String getID() {
        return this.name();  // Returns the enum constant name as a string
    }
}
