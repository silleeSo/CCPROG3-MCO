package ccprog3_mco;
import java.util.ArrayList;
/**
 * This class represents a single slot in a vending machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class Slot {
    /**This attribute contains the capacity of this slot*/
    private final int QUANTITY_LIMIT;
    /**This attribute contains the number of items stored in this slot*/
    private int quantityStored;
    /**This attribute represents the item name label on this slot*/
    private String itemName;
    /**This attribute represents the item price label on this slot*/
    private double itemPrice;
    /**This attribute represents the item calorie count label on this slot*/
    private double itemCalories;
    /**This attribute represents the slot inventory for this slot*/
    private Inventory inventory;
    /**This attribute contains the preparation information for the item in this slot*/
    private String preparation;
    /**This attribute represents the stand-alone vendibility label on this slot*/
    private boolean isSoldAlone;
    /**This attribute contains the instances of Item stored in this slot */
    private ArrayList<Item> itemsInSlot;
    /**
     * This constructor creates an instance of Slot.
     * @param slotCapacity the maximum capacity of the slot
     */
    public Slot(int slotCapacity){
        QUANTITY_LIMIT = slotCapacity;
        this.inventory = new Inventory(itemName, itemPrice);
        itemsInSlot = new ArrayList<Item>();
        itemName = null;
        itemPrice = 0;
        itemCalories = 0;
        quantityStored = 0;
        preparation = null;
        isSoldAlone = false;

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
                itemsInSlot.add(new Item(itemName, itemPrice, itemCalories, isSoldAlone, preparation));
            
        }
    }
    
    /**
     * This method replaces the item info labeled on this slot
     * @param item new item to be stored in this slot
     */
    public void replaceItem(Item item) {
        String newItemName = item.getName();

        itemName = newItemName;
        itemPrice = item.getPrice();
        itemCalories = item.getCalories();
        isSoldAlone = item.getIsSoldAlone();
        preparation = item.getPreparation();
        inventory = null;
        inventory = new Inventory(item.getName(), item.getPrice());
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
        Item itemInSlot = new Item(itemName, itemPrice, itemCalories, isSoldAlone, preparation);
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
        inventory.setPrice(price);
        for (Item item : itemsInSlot){
            item.setPrice(price);
        }
    }
    /**
     * This method returns the stand-alone vendibility of the item assigned to this slot
     * @return true if item assigned can be sold alone, false if not
     */
    public boolean getIsSoldAlone(){
        return isSoldAlone;
    }
    /**
     * This method returns the preparation method of the item assigned to this slot
     * @return preparation attribute of item assigned to this slot
     */
    public String getPreparation(){
        return preparation;
    }
}
