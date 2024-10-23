package GUI;

import fd.*;
import java.util.ArrayList;
import myTools.IO;

public class Menu {

    //declaration
    private final static ArrayList<String> OPTION = new ArrayList<String>();
    private final static ArrayList<Section> MENU = new ArrayList<>();

    //main
    public static void main(String[] args) {
        //declaration
        boolean condition = true;

        //load if emty
        if (MENU.isEmpty()) {
            loadSavedMenu();
        }
        if (OPTION.isEmpty()) {
            loadSavedOPTION();
        }

        //get user choice
        do {
            //display
            displayMENU();
            displayOPTION();

            //user input
            int choice = IO.inputAnInteger(
                    "Please enter your choice: ",
                    "Invalid choice! please re-do.",
                    0,
                    OPTION.size()
            );
            System.out.println("You choose: " + OPTION.get(choice) + "\n");

            //implement
            switch (choice) {
                case 0://close menu
                    condition = false;
                    System.out.println("[SYSTEM] System closes successfully!\n");
                    break;
                case 1://show order list
                    Implement.displayOrderList();
                    break;
                case 2://add purchased item to the order list
                    Implement.addPurchasedItem(MENU);
                    break;
                case 3://remove purchased item from the order list
                    Implement.removePurchasedItem();
                    break;
                case 4://cancel order

                    break;
                case 5://pay the order bill

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
            }

        } while (condition);
    }

    //load and display MENU
    public static void loadSavedMenu() {
        //
        Section fd1 = new Section("bánh", FoodType.SWEET_PASTRY, new ArrayList<>());
        fd1.addItem(new Food("bánh chuối", false, 29000));
        fd1.addItem(new Food("phô mai chanh dây", false, 29000));
        fd1.addItem(new Food("bánh xu kem", false, 29000));
        fd1.addItem(new Food("triramisu", false, 35000));
        fd1.addItem(new Food("mousse đào", false, 35000));
        fd1.addItem(new Food("mousse cacao", false, 35000));
        fd1.addItem(new Food("phô mai trà xanh", false, 35000));
        fd1.addItem(new Food("phô mai caramel", false, 35000));
        fd1.addItem(new Food("sô-cô-la highlands", false, 35000));
        fd1.addItem(new Food("sữa chua phô mai", false, 39000));
        MENU.add(fd1);

        //
        Section fd2 = new Section("bánh mì que", FoodType.SAVORY_PASTRY, new ArrayList<>());
        fd2.addItem(new Food("patê", false, 19000));
        fd2.addItem(new Food("gà phô mai", false, 19000));
        fd2.addItem(new Food("bò sốt phô mai", false, 25000));
        MENU.add(fd2);

        //
        Section dr1 = new Section("cà phê phin", DrinkType.TRADITIONAL_COFFEE, new ArrayList<>());
        dr1.addItem(new Drink("phin sữa đá", true, new int[]{29000, 39000, 45000}));
        dr1.addItem(new Drink("phin đen đá", false, new int[]{29000, 35000, 39000}));
        dr1.addItem(new Drink("bạc xỉu", false, new int[]{29000, 39000, 45000}));
        MENU.add(dr1);

        //
        Section dr2 = new Section("phindi", DrinkType.PHINDI, new ArrayList<>());
        dr2.addItem(new Drink("PhinDi hạnh nhân", true, new int[]{29000, 39000, 45000}));
        dr2.addItem(new Drink("PhinDi kem sữa", false, new int[]{29000, 35000, 39000}));
        dr2.addItem(new Drink("PhinDi choco", false, new int[]{29000, 39000, 45000}));
        MENU.add(dr2);

        //
        Section dr3 = new Section("trà", DrinkType.TEA, new ArrayList<>());
        dr3.addItem(new Drink("trà sen vàng", true, new int[]{45000, 55000, 65000}));
        dr3.addItem(new Drink("trà thạch đào", true, new int[]{45000, 55000, 65000}));
        dr3.addItem(new Drink("trà thanh đào", false, new int[]{45000, 55000, 65000}));
        dr3.addItem(new Drink("trà thạch vãi", false, new int[]{45000, 55000, 65000}));
        dr3.addItem(new Drink("trà xanh đậu đỏ", false, new int[]{45000, 55000, 65000}));
        MENU.add(dr3);

        //
        Section dr4 = new Section("freeze", DrinkType.FREEZE, new ArrayList<>());
        dr4.addItem(new Drink("freeze trà xanh", true, new int[]{55000, 65000, 69000}));
        dr4.addItem(new Drink("caramel phin freeze", false, new int[]{55000, 65000, 69000}));
        dr4.addItem(new Drink("cookies & cream", false, new int[]{55000, 65000, 69000}));
        dr4.addItem(new Drink("freeze sô-cô-la", false, new int[]{55000, 65000, 69000}));
        dr4.addItem(new Drink("classic phin freeze", false, new int[]{55000, 65000, 69000}));
        MENU.add(dr4);

        //
        Section cb1 = new Section("combo", ComboType.FOOD_AND_DRINK, new ArrayList<>());
        cb1.addItem(new Combo("hứng khởi", false, (Food) fd2.getItems().get(0), (Drink) dr1.getItems().get(0), 0.18f));
        cb1.addItem(new Combo("truyện trò", false, (Food) fd1.getItems().get(9), (Drink) dr3.getItems().get(0), 0.19f));
        MENU.add(cb1);
    }

    public static void displayMENU() {
        System.out.println("MENU");
        for (Section x : MENU) {
            x.displayInfo();
        }
    }

    //load and display OPTION
    public static void loadSavedOPTION() {
        OPTION.add("Close menu.");
        OPTION.add("Show order list.");
        OPTION.add("Add purchased item.");
        OPTION.add("Remove purchased item.");
        OPTION.add("Cancel order.");
        OPTION.add("Pay the bill.");

        OPTION.add("");
    }

    public static void displayOPTION() {
        System.out.println("OPTION");
        for (String x : OPTION) {
            System.out.println(String.format("%02d. %s", OPTION.indexOf(x), x));
        }
        System.out.println("");
    }
}
