package itemModel;

import java.util.HashMap;
import java.util.Map;
import model.Item;

public class Combo extends Item {  // Combo class extends Item, representing a combination of food and drink

    // Declaration of class variables
    private final Map<Size, Integer> price;  // A map to store the price of the combo based on size
    private Food foodCombo;  // Food component of the combo
    private Drink drinkCombo;  // Drink component of the combo
    private double discount;  // Discount applied to the combo
    private final boolean isFaulty;  // Indicates if the combo is faulty (based on the drink status)

    // Constructor to initialize a Combo with a name, bestseller status, food item, drink item, and discount
    public Combo(String name, boolean bestSeller, Food foodCombo, Drink drinkCombo, double discount) {
        super(name, bestSeller);  // Call the parent constructor to set the name and bestseller status
        this.foodCombo = foodCombo;
        this.drinkCombo = drinkCombo;
        this.discount = discount;

        // Calculate the price for the combo based on the drink's sizes
        this.price = CalculatePrice(Drink.getSize());
        this.isFaulty = this.drinkCombo.getStatus();  // Set the faulty status based on the drink
    }

    // Getter methods
    public boolean getStatus() {
        return isFaulty;  // Return the faulty status
    }

    public Map<Size, Integer> getPrice() {
        return price;  // Return the map of prices for the combo
    }

    public Food getFoodCombo() {
        return foodCombo;  // Return the food item of the combo
    }

    public Drink getDrinkCombo() {
        return drinkCombo;  // Return the drink item of the combo
    }

    public double getDiscount() {
        return discount;  // Return the discount applied to the combo
    }

    // Setter methods
    public void setFoodCombo(Food foodCombo) {
        this.foodCombo = foodCombo;  // Set the food item of the combo
    }

    public void setDrinkCombo(Drink drinkCombo) {
        this.drinkCombo = drinkCombo;  // Set the drink item of the combo
    }

    public void setDiscount(double discount) {
        this.discount = discount;  // Set the discount applied to the combo
    }

    // Override the toString method to display the combo details, including the price
    @Override
    public String toString() {
        return String.format("%s%s",  // Combine the string from the parent class and price format
                super.toString(),
                priceFormat());
    }

    // Calculate the price of the combo based on the sizes of the drink and food
    private Map<Size, Integer> CalculatePrice(Size[] size) {
        Map<Size, Integer> result = new HashMap<>();
        result.putAll(this.drinkCombo.getPrice());  // Start with the drink's price map
        int totalPrice;
        for (Size x : size) {  // Iterate through each size and calculate the total price
            totalPrice = result.get(x) + foodCombo.getPrice();  // Add food price to the drink price
            totalPrice -= (int) (totalPrice * discount);  // Apply the discount
            result.put(x, totalPrice);  // Store the total price for this size
        }
        return result;  // Return the map of prices for each size
    }

    // Get the price of the combo for a specific size
    public int getPriceBySize(Size size) {
        return price.get(size);  // Return the price for the given size
    }

    // Format the prices for each size into a string
    private String priceFormat() {
        StringBuilder str = new StringBuilder();
        for (Size x : Size.getSize()) {  // Loop through each size
            str.append(String.format("%2d ", getPriceBySize(x)));  // Append the price for each size
        }
        return str.toString();  // Return the formatted price string
    }

}
