/**
 * This class represents a single item in a vending machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class Item {
    private String name;
    private double price;
    private double calorieCount;
    private boolean isSoldAlone;
    private String preparation;

    /**
     * This method creates an instance of Item.
     * @param name name of item
     * @param price price of item
     * @param calorieCount calorie count of item
     */
    public Item(String name, double price, double calorieCount){
        this.name = name;
        this.price = price;
        this.calorieCount = calorieCount;
        isSoldAlone = true;
        preparation = "preparing";
    }
    /**
     * This method creates an instance of Item.
     * @param name name of item
     * @param price price of item
     * @param calorieCount calorie count of item
     * @param isSoldAlone standalone vendability of item
     * @param preparation preparation method of item
     */
    public Item(String name, double price, double calorieCount, boolean isSoldAlone, String preparation){
        this.name = name;
        this.price = price;
        this.calorieCount = calorieCount;
        this.isSoldAlone = isSoldAlone;
        this.preparation = preparation;
    }
    /**
     * This method returns the name of this item
     * @return the name attribute
     */
    public String getName() {
        return name;
    }
    /**
     * This method returns the price of this item
     * @return the price attribute
     */
    public double getPrice() {
        return price;
    }
    /**
     * This method reprices an Item
     * @param price the new price of the Item
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * This method returns the preparation method of an Item
     * @return the String preparations
     */
    public String getPreparation(){
        return preparation;
    }
    /**
     * This method returns the calorie count of this item
     * @return the calorieCount attribute
     */
    public double getCalories() {
        return calorieCount;
    }
    /**
     * This method returns the a boolean value based on whether or not an item can be sold alone
     * @return true if item can be sold alone, false if not
     */
    public boolean getIsSoldAlone(){
        return isSoldAlone;
    }
    /**
     * 
     * This method returns a String containing item information
     * @return String containing item name, item price, and item calorie count
     */
    @Override
    public String toString() {
        return name + " - PHP" + price + " - " + calorieCount + " calories";
    }
    /**
     * This method checks if one item is equal to another
     * @param item the item to compare this instance with
     * @return true if the two items have the same attribute values, false if not
     */
    public boolean equals(Item item) {
        return item.name == name && item.price == price && item.calorieCount == calorieCount;

    }
}