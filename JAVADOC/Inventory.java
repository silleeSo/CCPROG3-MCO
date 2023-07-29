/**
 * This class represents the inventory information of a slot in a vending machine.
 * @author So, Chrysille 
 * @author Chen, Abraham
 */
public class Inventory {
    private String itemName;
    private double itemPrice;
    private int qtyEndInv;
    private int qtyAdded;
    private int qtySold;
    /**
     * This method creates an instance of Inventory.
     * @param itemName the item name to be stored in this inventory record
     * @param itemPrice the item price to be stored in this inventory record
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
        String name = "Item name: " + itemName + "\n";
        String price = "Price: " + itemPrice + "\n";
        String qtyAdded = "Restock amount: " + this.qtyAdded + "\n";
        //String qtyStart = "Amount before restocking: " + qtyStartInv + "\n";
        String qtyEnd = "Amount after restocking: " + (qtyEndInv+qtySold) + "\n";
        String qtyCurr = "Current stock: " + qtyEndInv + "\n";
        double profit = qtySold * itemPrice;
        
        String qtySold = "Total quantity sold: " + this.qtySold + "\n";
        String amountCollected = "Amount collected since last restock: " + profit + "\n";

        return name + price + qtyAdded + qtyEnd + qtyCurr + qtySold + amountCollected;
    }
}
