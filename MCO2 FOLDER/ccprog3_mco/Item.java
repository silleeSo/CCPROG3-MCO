package ccprog3_mco;

/**
 * This class represents a single item in a vending machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class Item {
    /**
     * This attribute contains the name of this item.
     */
    private String name;
    /**
     * This attribute contains the price of this item.
     */
    private double price;
    /**
     * This attribute contains the calorie count of this item.
     */
    private double calorieCount;
    /**
     * This attribute contains the stand-alone vendibility of this item.
     */
    private boolean isSoldAlone;
    /**
     * This attribute contains the preparation method of this item.
     */
    private String preparation;

    /**
     * This constructor creates an instance of Item.
     * @param name name of item
     * @param price price of item
     * @param calorieCount calorie count of item
     */
    public Item(String name, double price, double calorieCount){
        this.name = name;
        this.price = price;
        this.calorieCount = calorieCount;
        isSoldAlone = true;
        preparation = null;
    }
    /**
     * This constructor creates an instance of Item.
     * @param name name of item
     * @param price price of item
     * @param calorieCount calorie count of item
     * @param isSoldAlone stand-alone vendibility of item
     * @param preparation description of preparation for item
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
     * This method sets the price of this item.
     * @param price the new price to set to
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * This method returns the preparations of this item.
     * @return String containing preparation method
     */
    public String getPreparation(){
        return preparation;
    }
    /**
     * This method returns the calorie count of this item.
     * @return the calorieCount attribute
     */
    public double getCalories() {
        return calorieCount;
    }
    /**
     * This method returns the stand-alone vendibility of this item.
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