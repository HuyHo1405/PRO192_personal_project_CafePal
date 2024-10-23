package fd;

import java.util.ArrayList;
import myTools.IO;

public class Section {

    //template
    private String name;
    private final FoodType ft;
    private final DrinkType dt;
    private final ComboType ct;
    private final String id;
    private ArrayList<Item> items;

    //constructor - food section
    public Section(String name, FoodType ft, ArrayList<Item> items) {
        this.name = name;
        this.ft = ft;
        this.dt = null;
        this.ct = null;
        this.id = ft.getId();
        this.items = items;
    }

    //constructor - drink section
    public Section(String name, DrinkType dt, ArrayList<Item> items) {
        this.name = name;
        this.ft = null;
        this.dt = dt;
        this.ct = null;
        this.id = dt.getId();
        this.items = items;
    }

    //constructor - combo section
    public Section(String name, ComboType ct, ArrayList<Item> items) {
        this.name = name.toUpperCase();
        this.ft = null;
        this.dt = null;
        this.ct = ct;
        this.id = ct.getId();
        this.items = items;
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public FoodType getFt() {
        return ft;
    }

    public DrinkType getDt() {
        return dt;
    }

    public ComboType getCt() {
        return ct;
    }

    public String getId() {
        return id;
    }

    //behaviour
    ///array list func
    public void addItem(Item i) {
        items.add(i);
    }

    public Item getItemByIndex(int index) {
        return items.get(index);
    }

    ///display header-body-footer
    public void displayInfo() {
        //header = name =====
        System.out.println(IO.header(name.toUpperCase(), addID(0).length(), '='));
        
        //add oz to the priceBySize(oz)
        if (items.get(0) instanceof Drink || items.get(0) instanceof Combo) {
            System.out.print(String.format(" %6s %20s ", "", ""));
            for (SizeByOz x : Drink.getSIZE()) {
                System.out.print(
                        String.format(" %-5s ", 
                                String.format("%.0f%s", x.getOz(), "oz")));
            }
            System.out.println("");
        }

        //body
        for (Item i : items) {
            System.out.println(addID(items.indexOf(i)));
        }
        
        //footer ------------\n\n
        System.out.println(IO.footer(addID(0).length(), '-') + "\n");
    }
    
    ///add id to toString
    private String addID(int index) {
        //declaration
        StringBuilder result = new StringBuilder();

        //add id
        result.append(" " + id);
        while (result.length() != 5)//only work under 100 items 
        {
            result.append('-');
        }
        result.append(String.format("%02d", index));

        //add toString
        result.append(items.get(index).toString());

        //return
        return result.toString();
    }
}
