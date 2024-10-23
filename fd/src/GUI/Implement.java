package GUI;

import fd.*;
import java.util.ArrayList;
import myTools.IO;

public class Implement {
    //declaration
    private final static ArrayList<Item> ORDER = new ArrayList<>();
    private static int totalPrice = 0;

    //MENU function
    public static void displayOrderList() {
        if (ORDER.isEmpty()) {
            System.out.println("[SYSTEM]: Your order list is emty!\n");
        } else {
            //header = NAME =====
            System.out.println(IO.header("oreder list", 35, '='));
            
            //order date - not done yet
            System.out.println(" Order date: today");
            
            //body
            for (Item x : ORDER)
                System.out.println(x.toString());
            
            //total price
            calculateTotalPrice();
            System.out.println(" Total price: " + totalPrice + " vnd");
            
            //footer ------------
            System.out.println(IO.footer(35, '-') + "\n");
        }

    }
    
    public static void addPurchasedItem(ArrayList<Section> MENU) {
        //declaration
        Item item;
        String id;
        int index;

        //find item
        do {
            id = IO.inputAString(
                    "Please input the ID: ",
                    "Invalid ID! Please re-do."
            );
            index = IO.inputAnInteger(
                    "Please input the index: ",
                    "Invalid index! Please re-do.",
                    0, 9
            );
            item = findItem(id, index, MENU);
        } while (item == null);

        //add new item
        if(item instanceof Food){
            ORDER.add(new PurchasedItem(
                    id, 
                    index, 
                    item.getName(), 
                    ((Food) item).getPrice())
            );
        }else if(item instanceof Drink){
            
        }else if(item instanceof Combo){
            
        }
        
        
    }
    
    public static void removePurchasedItem(){
        
        
    }
    
    //other function
    private static void calculateTotalPrice() {
        for (Item x : ORDER) {
            totalPrice += ((PurchasedItem) x).getPrice();
        }
    }

    private static Item findItem(String id, int index, ArrayList<Section> MENU) {
        //declaration
        Section s = null;
        
        //find section by id
        for (Section x : MENU) {
            if (x.getId().equalsIgnoreCase(id)) {
                s = x;
                break;
            }
        }
        
        //if no section match return null
        if (s == null) {
            System.out.println("Unavailable ID! Please re-do.");
            return null;
        }
        
        //find item by index
        if (index < s.getItems().size()) {
            return s.getItems().get(index);
        } else {
            System.out.println("Unavailable index! Please re-do.");
            return null;
        }
    }

    private static int chooseSize(){
        SizeByOz[] size = Drink.getSIZE();
        for (int i = 0; i < size.length; i++) {
            System.out.println(
                    String.format(
                            "%2d. Size %c", 
                            i, 
                            size[i].name().charAt(0)
                    ));
        }
    }
            




}
