public class Slot {
    //KINDA FINISHED ISH TOO
    private final int QUANTITY_LIMIT = 10;
    private int quantityStored;
    private Item itemInSlot;

    public Slot(Item itemToStore, int quantityStored) {
        if(quantityStored > 10)
            this.quantityStored = 10;
        else
            this.quantityStored = quantityStored;
        this.itemInSlot = itemToStore;
    }

    public Slot(Item itemToStore) {
        this(itemToStore, 0);
    }

    public int getQuantityStored() {
        return quantityStored;
    }

    public Item getItemInSlot() {
        return itemInSlot;
    }

    public void setQuantityStored(int quantityStored) {
        this.quantityStored = quantityStored;
    }

    public void setItemInSlot(Item itemInSlot) {
        this.itemInSlot = itemInSlot;
    }

    public boolean restockItem(int qty) {
        int total = qty + quantityStored;
        if (!isFull() && total <= QUANTITY_LIMIT){
            quantityStored = total;
            return true;
        }
        return false;
    }

    public void replaceItemInSlot(Item item) {
        if(!item.equals(itemInSlot) && quantityStored == 0)
            this.itemInSlot = item;
    }

    public boolean isFull() {
        if (quantityStored == QUANTITY_LIMIT)
            return true;
        return false;
    }
    
    public boolean isEmpty() {
        if (quantityStored == 0)
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
}