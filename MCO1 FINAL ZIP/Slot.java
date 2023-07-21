/**
 * This class represents a single slot in a vending machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class Slot {
    private final int QUANTITY_LIMIT;
    private int quantityStored;
    private Item itemInSlot;
    private Inventory inventory;
    /**
     * This method creates an instance of Slot. If the quantity passed is greater than 10, quantityStored is automatically set to 10. If quantity passed is negative, quantityStored is automatically set to 0. Otherwise, quantity passed is copied to quantityStored. 
     * @param itemToStore the item to be stored in this Slot
     * @param quantityStored the quantity passed
     */
    public Slot(Item itemToStore, int quantityStored) {
        QUANTITY_LIMIT = 10;
        if(quantityStored > 10)
            this.quantityStored = 10;
        else if (quantityStored < 0)
            this.quantityStored = 0;
        else
            this.quantityStored = quantityStored;
        this.itemInSlot = itemToStore;
        this.inventory = new Inventory(itemToStore);
        inventory.registerRestock(quantityStored);
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
    public Item getItemInSlot() {
        return itemInSlot;
    }
    /**
     * This method decrements the quantity of item stored in this Slot
     */
    public void decrementQtyStored() {
        quantityStored--;
    }
    /**
     * This method adds to the quantity stored in this Slot. If quantity exceeds slot limit, quantity stored is set to 10 by default.
     * @param qty the quantity to add
     */
    public void restockItem(int qty) {
        int total = qty + quantityStored;
        if (!isFull() && total <= QUANTITY_LIMIT){
            quantityStored = total;
            inventory.registerRestock(qty);
            
        }
        else {
            qty = 10 - quantityStored;
            inventory.registerRestock(qty);
        }
    }
    /**
     * This method replces the item stored in this slot
     * @param item the new item to replace the current one
     */
    public void replaceItem(Item item) {

        if(!itemInSlot.equals(item)) {

            this.itemInSlot = item;
            inventory = new Inventory(item);
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
        if (itemInSlot == null || quantityStored == 0)
            return true;
        return false;
    }

    @Override
    /**
     * This method returns a String containing the information of the item stored in this Slot
     * @return String containing item name, calorie count, price, and quantity
     */
    public String toString() {
        String item = "Item: " + itemInSlot.getName() + "\n";
        String calories = "Calories: " + itemInSlot.getCalories() + "\n";
        String price = "Price: " + itemInSlot.getPrice() + "\n";
        String quantity = "Quantity: " + quantityStored + "\n";

        return item + calories + price + quantity;
    }
    /**
     * This method returns the string containing item information stored in this slot
     * @return  string containing item information
     */
    public String getItemInfo() {
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
     * This method returns the string containing transaction history for this slot
     * @return string containing transaction history
     */
    public String getInvQtySold() {
        return getInventory().getQtySold();
    }
}
