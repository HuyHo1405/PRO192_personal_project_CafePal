package fd;

public class Food extends Item{
    private int price;

    public Food(String name, boolean isBestSeller, int price) {
        super(name, isBestSeller);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%6d ", price);
    }
    
    
    
}
