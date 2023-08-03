package ccprog3_mco;

/**
 * This class represents the inventory information of a slot in a vending machine.
 * @author So, Chrysille 
 * @author Chen, Abraham
 */
public class Inventory {
    /**
     * itemName contains the name of the item recorded in this Inventory.
     */
    private String itemName;
    /**
     * itemPrice contains the price of the item recorded in this Inventory.
     */
    private double itemPrice;
    /**
     * qtyEndInv contains the quantity of the slot following restock
     */
    private int qtyEndInv;
    /**
     * qtyAdded contains the quantity of the restock
     */
    private int qtyAdded;
    /**
     * qtySold contains the quantity of items sold since the last restock
     */
    private int qtySold;
 
    /**
     * This method creates an instance of Inventory. It sets the item attribute to the item passed and sets the rest of the attributes to 0
     * @param itemName the name of the item recorded in this inventory
     * @param itemPrice the price of the item recorded in this inventory
     */
    public Inventory(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.qtyAdded = 0;
        this.qtyEndInv = 0;
        this.qtySold = 0;
    }
    /**
     * This method registers the restock information to the inventory by updating all attributes based on the given quantity.
     * @param qty the quantity of restock
     */
    public void registerRestock(int qty) {
        qtyEndInv += qty;
        qtyAdded = qty;
        qtySold = 0;
    }
    /**
     * This method decrements the attribute containing the quantity at the end of a restock.
     */
    public void decrementQtyEnd() {
        this.qtyEndInv--;
    }
    /**
     * This method increments the attribute containing the quantity sold.
     */
    public void incrementQtySold() {
        this.qtySold++;
    }

    @Override
    /**
     * This method returns a String containing restock information stored in the inventory.
     * @return the Sting containing item name, quantity added, quantity before restock, quantity after restock, and current quantity in stock
     */
    public String toString() {
        String name = "Item name: " + itemName + "     ";
        String price = "Price: " + itemPrice + "     ";
        String qtyAdded = "Restock amount: " + this.qtyAdded + "     ";
        String qtyEnd = "Amount after restocking: " + (qtyEndInv+qtySold) + "     ";
        String qtyCurr = "Current stock: " + qtyEndInv + "     ";
        double profit = qtySold * itemPrice;

        String qtySold = "Total quantity sold: " + this.qtySold + "     ";
        String amountCollected = "Amount collected since last restock: " + profit + "     ";

        return name + price + qtyAdded + qtyEnd + qtyCurr + qtySold + amountCollected;
    }
    /**
     * This item sets the recorded item price to a given number
     * @param price the new price to replace the previously recorded one
     */
    public void setPrice(double price){
        this.itemPrice = price;
    }
}
