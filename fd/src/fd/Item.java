package fd;

import myTools.IO;

public abstract class Item {
    //template
    protected String name;
    protected boolean isBestSeller;

    //constructor
    public Item(String name, boolean isBestSeller) {
        this.name = IO.capitalize(name);
        this.isBestSeller = isBestSeller;
    }
    

    //getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsBestSeller() {
        return isBestSeller;
    }

    public void setIsBestSeller(boolean isBestSeller) {
        this.isBestSeller = isBestSeller;
    }
    
    //toString
    @Override
    public String toString() {
        return String.format(" %-20s ",name + ((isBestSeller)? " *": ""));
    }
    
    //behaviour
    ///display
    public void displayInfo(){
        System.out.println(toString());
    }

    
}
