package itemModel;

public enum Size {  // Enum representing different sizes for items (e.g., drink or food)

    // Enum constants with associated oz values (Small, Medium, Large)
    SMALL(6.0),  // Small size with 6 oz
    MEDIUM(8.0), // Medium size with 8 oz
    LARGE(10.0); // Large size with 10 oz

    // Instance variable to store the ounce value for each size
    private final double oz;

    // Constructor for initializing the size with its corresponding ounce value
    private Size(double oz) {
        this.oz = oz;  // Set the ounce value for the size
    }

    // Getter method to retrieve the ounce value for a size
    public double getOz() {
        return oz;  // Return the ounce value of the size
    }

    // Static method to get all available sizes (Small, Medium, Large)
    public final static Size[] getSize() {
        return new Size[]{SMALL, MEDIUM, LARGE};  // Return an array of all size values
    }

    // Static method to get the short name (first letter) of a size
    public static String getShortName(Size size) {
        return size.name().charAt(0) + "";  // Return the first letter of the size name as a string
    }
}
