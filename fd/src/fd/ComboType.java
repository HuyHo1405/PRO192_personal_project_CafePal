
package fd;

public enum ComboType {
    FOOD_AND_DRINK("CMB");
    
    private final String id;

    private ComboType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
