package orderModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import util.IO;

public class OrderedList {

    private final ArrayList<PurchasedItem> orderedList = new ArrayList<>();  // List to store purchased items
    private int totalPrice = 0;  // Total price for the order

    // Method to display the current list of ordered items
    public void display() {
        int len;
        if (!orderedList.isEmpty()) {  // Check if the ordered list is not empty
            len = orderedList.get(0).toString().length();  // Get length of the first item's string representation
            System.out.println(IO.header("Ordered List", len, '='));  // Display the header
            for (PurchasedItem x : orderedList) {
                System.out.println(x);  // Print each item in the ordered list
            }
        } else {
            len = 20;  // Default length if the list is empty
            System.out.println(IO.header("Ordered List", len, '='));  // Display the header
            System.out.println(" N/A ");  // Indicate that the list is empty
        }

        System.out.println(IO.footer(len, '-'));  // Display the footer
    }

    // Method to add a purchased item to the order list
    public void addPurchasedItem(PurchasedItem purchasedItem) {
        // Check if the item is already in the ordered list
        for (PurchasedItem x : orderedList) {
            if (x.equals(purchasedItem)) {  // If the item is already ordered, update its quantity and price
                x.setQuantity(x.getQuantity() + purchasedItem.getQuantity());
                x.setPrice(x.getPrice() + purchasedItem.getPrice());
                return;
            }
        }
        orderedList.add(purchasedItem);  // Add the item if not already in the list
        System.out.println(
                "Add item [" + purchasedItem.info() + "] successfully!\n");  // Confirm the item was added
    }

    // Private method to display items that can be removed from the order
    private void displayRemovableItem() {
        int len;
        if (!orderedList.isEmpty()) {
            len = orderedList.get(0).removingInfo().length() + 4;  // Calculate the length for the header
            System.out.println(IO.header("Removable List", len, '='));  // Display the header
            for (PurchasedItem x : orderedList) {
                System.out.println(String.format(
                        " %02d.%s",  // Print index and item info
                        orderedList.indexOf(x),
                        x.removingInfo()
                ));
            }
        } else {
            len = 20;  // Default length if the list is empty
            System.out.println(IO.header("Removable List", len, '='));  // Display the header
            System.out.println(" N/A ");  // Indicate that there are no items to remove
        }
        System.out.println(IO.footer(len, '-'));  // Display the footer
    }

    // Method to remove an item from the ordered list
    public void removePurchasedItem() {
        if (!orderedList.isEmpty()) {  // Check if the ordered list is not empty
            displayRemovableItem();  // Display items that can be removed
            int index = IO.inputAnInteger(
                    "Please enter the removing item index[0.." + (orderedList.size() - 1) + "]: ",  // Prompt for item index
                    "Invalid index! Please re-do.",  // Error message for invalid index
                    0, orderedList.size() - 1  // Valid range for index
            );

            System.out.println("Remove item [" + orderedList.get(index).info() + "] successfully!\n");  // Confirm removal
            orderedList.remove(index);  // Remove the item from the list
        } else {
            System.out.println("The ordered list is empty!\n");  // Handle case where the list is empty
        }
    }

    // Method to remove all items from the ordered list (cancel the order)
    public void removeAll() {
        orderedList.clear();  // Clear the ordered list
        System.out.println("Order canceled!\n");  // Confirm that the order has been canceled
    }

    // Method to display the receipt and finalize the order
    public void displayReceipt() {
        if (!orderedList.isEmpty()) {  // Check if the ordered list is not empty
            int len = orderedList.get(0).toString().length();  // Get the length for the header
            System.out.println(IO.header("Receipt", len, '='));  // Display the header

            // Get the current date and time in the specified format
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String formattedDateTime = currentDateTime.format(formatter);
            System.out.println(formattedDateTime);  // Display the current date and time

            totalPrice = 0;  // Reset total price
            for (PurchasedItem x : orderedList) {
                System.out.println(x);  // Display each purchased item
                totalPrice += x.getPrice();  // Add item price to the total
            }

            System.out.println("Total price: " + totalPrice + ".000 vnd");  // Display the total price
            System.out.println(IO.footer(len, '-'));  // Display the footer
            orderedList.clear();  // Clear the ordered list after payment
        } else {
            System.out.println("The ordered list is empty!\n");  // Handle case where the list is empty
        }
    }
}
