public class Slot {
    private final int QUANTITY_LIMIT = 10;
    private int quantityStored;
    private Item itemInSlot;
    private Inventory inventory;

    public Slot(Item itemToStore, int quantityStored) {
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
    
     public Inventory getInventory() {
        return inventory;
    }

    public int getQuantityStored() {
        return quantityStored;
    }

    public Item getItemInSlot() {
        return itemInSlot;
    }

    public void decrementQtyStored() {
        quantityStored--;
    }

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

    public void replaceItem(Item item) {

        if(!itemInSlot.equals(item)) {

            this.itemInSlot = item;
            inventory = new Inventory(item);
        }
    }
    public boolean isFull() {
        if (quantityStored == QUANTITY_LIMIT)
            return true;
        return false;
    }
    
    public boolean isEmpty() {
        if (itemInSlot == null || quantityStored == 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String item = "Item: " + itemInSlot.getName() + "\n";
        String calories = "Calories: " + itemInSlot.getCalories() + "\n";
        String price = "Price: " + itemInSlot.getPrice() + "\n";
        String quantity = "Quantity: " + quantityStored + "\n";

        return item + calories + price + quantity;
    }

    public String getItemInfo() {
        return itemInSlot.toString();
    }

    public String getInvInfo() {
        return getInventory().toString();
    }

    public String getInvQtySold() {
        return getInventory().getQtySold();
    }
}
