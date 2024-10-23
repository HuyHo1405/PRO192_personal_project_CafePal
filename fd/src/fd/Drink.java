package fd;

public class Drink extends Item {
    private int[] priceBySize;
    private final static SizeByOz[] SIZE = SizeByOz.getSizeByOz();
    
    
    //constructor
    public Drink(String name, boolean isBestSeller, int[] priceBySize) {
        super(name, isBestSeller);
        this.priceBySize = priceBySize;
    }

    //getters & setters
    public int[] getPriceBySize() {
        return priceBySize;
    }

    public void setPriceBySize(int[] priceBySize) {
        this.priceBySize = priceBySize;
    }
    
    public static SizeByOz[] getSIZE() {
        return SIZE;
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
    
    
}
