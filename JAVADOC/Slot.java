/**
 * This class represents a single slot in a vending machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
import java.util.ArrayList;
/**
 * This constructor creates an instance of Slot
 */
public class Slot {
    private final int QUANTITY_LIMIT;
    private int quantityStored;
    private String itemName;
    private double itemPrice;
    private double itemCalories;
    private Inventory inventory;
    private ArrayList<Item> itemsInSlot;
    /**
     * This method creates an instance of Slot.
     * @param slotCapacity the maximum capacity of the slot
     */
    public Slot(int slotCapacity){
        QUANTITY_LIMIT = slotCapacity;
        this.inventory = new Inventory(itemName, itemPrice);
        itemsInSlot = new ArrayList<Item>();
        itemName = null;
        itemPrice = 0;
        itemCalories = 0;

    }
    /**
     * This method returns a boolean value based on whether this Slot is assigned to an item or not
     * @return true if Slot is assigned to an Item, false if not
     */
    public boolean isSlotAssigned(){
        if (itemName == null)
            return false;
        else
            return true;
    }
    /**
     * This method updates the attributes of this instance of Slot. 
     * @param itemName new name of Item assigned to this Slot
     * @param itemPrice new price of Item assigned to this Slot
     * @param itemCalories new calorie count of Item assigned to this Slot
     * @param quantityStored new quantity of Item assigned to this Slot
     */
    public void updateSlot(String itemName, double itemPrice, double itemCalories, int quantityStored) {
        
        if(quantityStored > 10)
            this.quantityStored = 10;
        else if (quantityStored < 0)
            this.quantityStored = 0;
        else
            this.quantityStored = quantityStored;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCalories = itemCalories;

        inventory.registerRestock(quantityStored);//update in transactions

        //initialize arrayList
       
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
     * This method returns the name of the Item stored in this Slot
     * @return the item stored in slot
     */
    public String getItemNameInSlot() {
        return itemName;
    }
    /**
     * This method returns the price of the Item assigned to this Slot
     * @return the price of item assigned to slot
     */
    public double getItemPriceInSlot() {
        return itemPrice;
    }
    /**
     * This method returns the calorie count of the item assigned to this Slot
     * @return the calorie count of item assigned to slot
     */
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
            for (int i = 0; i < qty; i++)
                itemsInSlot.add(new Item(itemName, itemPrice, itemCalories));
            
        }
        
    }
    /**
     * This method replces the item stored in this slot
     * @param name the name of the new item
     * @param price the price of the new item
     * @param calories the calorie count of the new item
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
     * @return true if quantity stored is equal to quantity limit, false if not
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
    /**
     * This method reprices the items in this slot
     * @param price the new item price
     */
    public void setItemPrice(double price){
        itemPrice = price;
        for (Item item : itemsInSlot){
            item.setPrice(price);
        }
    }
}
