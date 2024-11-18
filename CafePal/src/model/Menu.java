package model;

import itemModel.Food;
import itemModel.Drink;
import itemModel.Combo;
import java.util.ArrayList;

public class Menu extends ArrayList<Section> {

    // Name of the menu
    private final String name = "MENU";

    // Constructor that loads the saved menu with sections and items
    public Menu() {
        this.loadSavedMenu();
    }

    // This method loads the sections and their respective items (Drinks, Foods, Combos) into the menu
    private void loadSavedMenu() {
        // Section for Traditional Coffee drinks
        Section dr1 = new Section(SectionCategory.CFF);
        dr1.addItem(new Drink("phin sữa đá", true, new int[]{29, 39, 45}));
        dr1.addItem(new Drink("phin đen đá", false, new int[]{29, 35, 39}));
        dr1.addItem(new Drink("bạc xỉu", false, new int[]{29, 39, 45}));
        this.add(dr1);

        // Section for Phindi drinks
        Section dr2 = new Section(SectionCategory.PHD);
        dr2.addItem(new Drink("PhinDi hạnh nhân", true, new int[]{29, 39, 45}));
        dr2.addItem(new Drink("PhinDi kem sữa", false, new int[]{29, 35, 39}));
        dr2.addItem(new Drink("PhinDi choco", false, new int[]{29, 39, 45}));
        this.add(dr2);

        // Section for Tea drinks
        Section dr3 = new Section(SectionCategory.TEA);
        dr3.addItem(new Drink("trà sen vàng", true, new int[]{45, 55, 65}));
        dr3.addItem(new Drink("trà thạch đào", true, new int[]{45, 55, 65}));
        dr3.addItem(new Drink("trà thanh đào", false, new int[]{45, 55, 65}));
        dr3.addItem(new Drink("trà thạch vãi", false, new int[]{45, 55, 65}));
        dr3.addItem(new Drink("trà xanh đậu đỏ", false, new int[]{45, 55, 65}));
        this.add(dr3);

        // Section for Freeze drinks
        Section dr4 = new Section(SectionCategory.FRZ);
        dr4.addItem(new Drink("freeze trà xanh", true, new int[]{55, 65, 69}));
        dr4.addItem(new Drink("caramel phin freeze", false, new int[]{55, 65, 69}));
        dr4.addItem(new Drink("cookies & cream", false, new int[]{55, 65, 69}));
        dr4.addItem(new Drink("freeze sô-cô-la", false, new int[]{55, 65, 69}));
        dr4.addItem(new Drink("classic phin freeze", false, new int[]{55, 65, 69}));
        this.add(dr4);

        // Section for Sweet Pastry foods
        Section fd1 = new Section(SectionCategory.SWE);
        fd1.addItem(new Food("bánh chuối", false, 29));
        fd1.addItem(new Food("phô mai chanh dây", false, 29));
        fd1.addItem(new Food("bánh xu kem", false, 29));
        fd1.addItem(new Food("triramisu", false, 35));
        fd1.addItem(new Food("mousse đào", false, 35));
        fd1.addItem(new Food("mousse cacao", false, 35));
        fd1.addItem(new Food("phô mai trà xanh", false, 35));
        fd1.addItem(new Food("phô mai caramel", false, 35));
        fd1.addItem(new Food("sô-cô-la highlands", false, 35));
        fd1.addItem(new Food("sữa chua phô mai", false, 39));
        this.add(fd1);

        // Section for Savory Pastry foods
        Section fd2 = new Section(SectionCategory.SAV);
        fd2.addItem(new Food("patê", false, 19));
        fd2.addItem(new Food("gà phô mai", false, 19));
        fd2.addItem(new Food("bò sốt phô mai", false, 25));
        this.add(fd2);

        // Section for Combo meals
        Section cb1 = new Section(SectionCategory.CMB);
        cb1.addItem(new Combo("hứng khởi", false, (Food) fd2.get(0), (Drink) dr1.get(0), 0.18f));
        cb1.addItem(new Combo("truyện trò", false, (Food) fd1.get(9), (Drink) dr3.get(0), 0.19f));
        this.add(cb1);
    }

    // Method to display the entire menu
    public void displayMenu() {
        System.out.println(name);  // Print the name of the menu
        for (Section x : this) {
            x.display();  // Display each section of the menu
        }
    }

    // Method to retrieve a section by its ID
    public Section getSectionByID(String id) {
        for (Section x : this) {
            if (x.getId().equalsIgnoreCase(id)) {  // Compare IDs case-insensitively
                return x;  // Return the section if IDs match
            }
        }
        return null;  // Return null if no section with the given ID is found
    }
}
