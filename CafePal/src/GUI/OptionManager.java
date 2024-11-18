package GUI;

import itemModel.*;
import java.util.concurrent.TimeUnit;
import model.*;
import util.*;
import orderModel.*;

public class OptionManager {

    private final Option option = new Option();  // Option object stores the list of possible user actions
    private final OrderedList orderedlist = new OrderedList();  // OrderedList handles the items in the user's order
    private final Menu menu = new Menu();  // Menu object to display available items and sections

    // Method to get the user's choice from the available options
    public int getUserChoice() {
        // Prompt the user to input a choice from the available options (0 to option.size() - 1)
        int choice = IO.inputAnInteger(
                "Please enter your choice [0.." + (option.size() - 1) + "]: ", // Prompt message
                "Invalid option! Please re-do.", // Error message for invalid input
                0, option.size() - 1);  // Valid range for choices
        System.out.println("You choose: " + option.get(choice) + "\n");  // Display the selected option
        return choice;  // Return the user's chosen option
    }

    // Method to handle actions based on the user's choice
    public void handleOption(int choice) {
        // Use a switch-case structure to perform different actions depending on the choice
        switch (choice) {
            case 1:  // Show current order
                showOrderedList();
                break;
            case 2:  // Add a new item to the order
                addPurchasedItem();
                break;
            case 3:  // Remove an item from the order
                removePurchasedItem();
                break;
            case 4:  // Cancel the current order
                cancelOrder();
                break;
            case 5:  // Pay the bill and finalize the order
                payTheBill();
                break;
        }
    }

    // Main method that runs the OptionManager, repeatedly asking for user input until they choose to exit
    public void run() {
        menu.displayMenu();  // Display the menu with available items and sections
        int choice = 0;  // Variable to store user's choice
        do {
            // If the user selects option 5 (pay), wait for 3 seconds before redisplaying the menu
            if (choice == 5) {
                try {
                    TimeUnit.SECONDS.sleep(3);  // Pause for 3 seconds before displaying the menu again
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                menu.displayMenu();   // Display the menu after the pause
            }
            option.displayOption();  // Display the list of available actions (options)
            choice = getUserChoice();  // Get the user's choice
            if (choice != 0) {  // If the user does not choose to exit, process their option
                handleOption(choice);
            }
        } while (choice != 0);  // Continue until the user chooses to exit (option 0)
    }

    // Display the list of items currently in the order
    public void showOrderedList() {
        orderedlist.display();  // Display all the items in the current order
    }

    // Method to add a purchased item to the order
    public void addPurchasedItem() {
        String id;  // ID of the selected item
        Section section = null;  // The section that contains the item
        Item item;  // The selected item
        PurchasedItem t;  // The converted PurchasedItem object

        // Repeatedly ask for the item ID until a valid section is found
        do {
            id = getId();  // Get the item ID from the user
            section = menu.getSectionByID(id);  // Retrieve the section based on the ID
        } while (section == null);  // If the section is invalid, ask for input again

        // Retrieve the item from the selected section
        item = getItem(section);

        // Convert the selected item to a PurchasedItem object and add it to the order
        t = toPurchasedItem(
                String.format("%s-%02d", id, section.indexOf(item)),  // Create a unique ID for the item
                item,  // The selected item
                getSize(item),  // Size for non-food items
                getQuantity()  // Quantity of the item
        );
        orderedlist.addPurchasedItem(t);  // Add the item to the order list
    }

    // Method to remove an item from the order
    public void removePurchasedItem() {
        orderedlist.removePurchasedItem();  // Remove the item from the ordered list
    }

    // Method to cancel the entire order, removing all items from the list
    public void cancelOrder() {
        orderedlist.removeAll();  // Clear the entire order
    }

    // Display the receipt and finalize the order with a friendly message
    public void payTheBill() {
        orderedlist.displayReceipt();  // Display the receipt with order details
        System.out.println("Have a good day!\n");  // Print a farewell message to the user
    }

    // Method to get the quantity of an item, ensuring it is within a valid range
    private int getQuantity() {
        return IO.inputAnInteger(
                "Please enter the quantity[0..50]: ",  // Prompt for the item quantity
                "Invalid quantity! Please re-do.",  // Error message for invalid input
                0, 50  // Valid quantity range (0 to 50)
        );
    }

    // Method to get the size of the item (only for non-Food items)
    private Size getSize(Item item) {
        if (!(item instanceof Food)) {  // Only ask for size if the item is not a Food item
            // Display available size options for non-food items
            for (Size x : Size.getSize()) {
                System.out.println(String.format(
                        "%d. Size:%1c",  // Display the index and size
                        x.ordinal(),
                        x.name().charAt(0))  // Display size (first character)
                );
            }
            int choice = IO.inputAnInteger(
                    "Please Choose the size[0.." + (Size.values().length - 1) + "]: ",  // Prompt for size choice
                    "Invalid size! Please re-do!",  // Error message for invalid input
                    0, Size.values().length - 1);  // Valid size range
            return Size.values()[choice];  // Return the selected size
        } else {
            return null;  // No size is needed for food items
        }
    }

    // Method to get the item ID from the user, displaying available section categories
    private String getId() {
        // Display the available section categories to the user
        for (SectionCategory x : SectionCategory.values()) {
            System.out.println(String.format(
                    "~ %s", x));  // Display each category
        }
        return IO.inputAString(
                "Please enter the item ID: ",  // Prompt for item ID input
                "Invalid ID! Please re-do.");  // Error message for invalid input
    }

    // Method to get the item from a section based on the user's input
    private Item getItem(Section section) {
        section.display();  // Display the items available in the selected section
        int index = IO.inputAnInteger(
                "Please enter the item index[0.." + (section.size() - 1) + "]: ",  // Prompt for item index
                "Invalid index! Please re-do.",  // Error message for invalid input
                0, section.size() - 1);  // Valid range for item index
        return section.get(index);  // Return the selected item
    }

    // Method to convert an item into a PurchasedItem, setting its ID, size, quantity, and price
    private PurchasedItem toPurchasedItem(String id, Item item, Size size, int quantity) {
        int price;
        // Determine the price based on the item type (Food, Drink, Combo)
        if (item instanceof Food) {
            price = ((Food) item).getPrice();  // Price for Food item
        } else if (item instanceof Drink) {
            price = ((Drink) item).getPriceBySize(size);  // Price for Drink item (size-dependent)
        } else if (item instanceof Combo) {
            price = ((Combo) item).getPriceBySize(size);  // Price for Combo item (size-dependent)
        } else {
            return null;  // Return null if the item type is unrecognized
        }
        // Create and return a new PurchasedItem object with the calculated price
        return new PurchasedItem(id, item.getName(), quantity, size, price * quantity);  // Finalize the purchased item
    }
}
