package fd;

import java.util.Arrays;

public class Combo extends Item {

    //template
    private Food food;
    private Drink drink;
    private float discount;
    private int[] priceBySize;

    //constructor
    public Combo(String name, boolean isBestSeller, Food food, Drink drink, float discount) {
        super(name, isBestSeller);
        this.food = food;
        this.drink = drink;
        this.discount = discount;
        this.priceBySize = calculatePrice();
    }

    //getters & setters
    public int[] getPriceBySize() {
        return priceBySize;
    }

    public void setPrice(int[] price) {
        this.priceBySize = price;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder addOn = new StringBuilder();
        for (int i : priceBySize) {
            addOn.append(String.format("%6d ", i));
        }
        return super.toString() + addOn.toString();
    }

    //behaviour
    ///calculate price
    private int[] calculatePrice() {
        int[] result = Arrays.copyOf(drink.getPriceBySize(), drink.getPriceBySize().length);
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) ((result[i] + food.getPrice()) * (1 - discount));
        }
        return result;
    }
}
