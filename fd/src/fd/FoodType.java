
package fd;

public enum FoodType {
    SWEET_PASTRY("SWE"),
    SAVORY_PASTRY("SAV");
    
    private final String id;

    private FoodType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    
    
}
