/**
 * This class represents a single slot in a vending machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
import java.util.ArrayList;
public class Slot {
    private final int QUANTITY_LIMIT;
    private int quantityStored;
    private String itemName;
    private double itemPrice;
    private double itemCalories;
    private Inventory inventory;
    private ArrayList<Item> itemsInSlot;
    /**
     * This method creates an instance of Slot. If the quantity passed is greater than 10, quantityStored is automatically set to 10. If quantity passed is negative, quantityStored is automatically set to 0. Otherwise, quantity passed is copied to quantityStored. 
     * @param itemToStore the item to be stored in this Slot
     * @param quantityStored the quantity passed
     */
    public Slot(String itemName, double itemPrice, double itemCalories, int quantityStored) {
        QUANTITY_LIMIT = 10;
        if(quantityStored > 10)
            this.quantityStored = 10;
        else if (quantityStored < 0)
            this.quantityStored = 0;
        else
            this.quantityStored = quantityStored;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCalories = itemCalories;
        this.inventory = new Inventory(itemName, itemPrice);
        inventory.registerRestock(quantityStored);//update in transactions

        //initialize arrayList
        itemsInSlot = new ArrayList<Item>();
        for (int i = 0; i < quantityStored;i++)
            itemsInSlot.add(new Item(itemName,itemPrice, itemCalories));
    }
    /**
     * This method returns the Inventory of this slot.
     * @return the Inventory attribute of this Slot instance.
     */
     public Inventory getInventory() {
        return inventory;
    }
    /**
     * This method returns the quantity of items stored in this slot.
     * @return the quantity stored
     */
    public int getQuantityStored() {
        return quantityStored;
    }
    /**
     * This method returns the item stored in this Slot
     * @return the item stored in slot
     */
    public String getItemNameInSlot() {
        return itemName;
    }
    public double getItemPriceInSlot() {
        return itemPrice;
    }
    public double getItemCaloriesInSlot() {
        return itemCalories;
    }
    /**
     * This method decrements the quantity of item stored in this Slot
     */
    public void decrementQtyStored() {
        quantityStored--;
        itemsInSlot.remove(0);
        //simulates the first item in slot falling out of the slot 
    }
    /**
     * This method adds to the quantity stored in this Slot. If quantity exceeds slot limit, quantity stored is set to 10 by default.
     * @param qty the quantity to add
     */
    //need to test
    public void restockItem(int qty) {
        int total = qty + quantityStored;
        if (!isFull() && total <= QUANTITY_LIMIT){
            quantityStored = total;
            inventory.registerRestock(qty);
            
        }
        else {
            qty = 10 - quantityStored;
            quantityStored = QUANTITY_LIMIT;
            inventory.registerRestock(qty);
        }
        for (int i = 0; i < qty; i++)
                itemsInSlot.add(new Item(itemName, itemPrice, itemCalories));
    }
    /**
     * This method replces the item stored in this slot
     * @param item the new item to replace the current one
     */
    public void replaceItem(String name, double price, double calories) {

        if(!itemName.equals(name)) {

            this.itemName = name;
            this.itemPrice = price;
            this.itemCalories = calories;
            inventory = null;
            inventory = new Inventory(name, price);
        }
    }
    /**
     * This method checks if this Slot is full or not
     * @return true if quantity stored is equal to 10, false if not
     */
    public boolean isFull() {
        if (quantityStored == QUANTITY_LIMIT)
            return true;
        return false;
    }
    /**
     * This method checks if this Slot is empty or not
     * @return true if quantity stored is equal to 0, false if not
     */
    public boolean isEmpty() {
        if (itemName == null || quantityStored == 0)
            return true;
        return false;
    }

    @Override
    /**
     * This method returns a String containing the information of the item stored in this Slot
     * @return String containing item name, calorie count, price, and quantity
     */
    public String toString() {
        String item = "Item: " + itemName + "\n";
        String calories = "Calories: " + itemCalories + "\n";
        String price = "Price: " + itemPrice + "\n";
        String quantity = "Quantity: " + quantityStored + "\n";

        return item + calories + price + quantity;
    }
    /**
     * This method returns the string containing item information stored in this slot
     * @return  string containing item information
     */
    
    public String getItemInfo() {
        Item itemInSlot = new Item(itemName, itemPrice, itemCalories);
        return itemInSlot.toString();
    }
    /**
     * This method returns the string containing slot inventory information
     * @return string containing slot inventory information
     */
    public String getInvInfo() {
        return getInventory().toString();
    }
}
