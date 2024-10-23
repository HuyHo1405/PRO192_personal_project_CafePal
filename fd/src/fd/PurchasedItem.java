package fd;

public class PurchasedItem extends Item {

    private final String id;
    private final int index;
    private final int price;
    private final SizeByOz size;
    

    public PurchasedItem(String id, int index, String name, int price, SizeByOz size) {
        super(name, false);
        this.id = id;
        this.index = index;
        this.price = price;
        this.size = size;
    }

    public PurchasedItem(String id, int index, String name, int price) {
        super(name, false);
        this.id = id;
        this.index = index;
        this.price = price;
        this.size = null;
    }

    public String getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public int getPrice() {
        return price;
    }

    public SizeByOz getSize() {
        return size;
    }

    @Override
    public String toString() {
        return 
            String.format(
                "- %-3s-%02d %-20s %6d", 
                id, 
                index, 
                name + ((size == null)? "": "(" + size.getOz() + "oz)"), 
                price
            )
        ;
    }

}
