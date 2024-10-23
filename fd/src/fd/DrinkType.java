
package fd;

public enum DrinkType {
    TRADITIONAL_COFFEE("CFF"),
    PHINDI("PHD"),
    TEA("TEA"),
    FREEZE("FRZ");
    
    private final String id;

    private DrinkType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    
    
}
