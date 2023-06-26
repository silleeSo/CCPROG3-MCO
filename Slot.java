public class Slot {
    //KINDA FINISHED ISH TOO
    private final int QUANTITY_LIMIT = 10;
    private final int SLOT_NUMBER;
    private int quantityStored;
    private Item itemInSlot;
    private int startQtyRestock;
    private int endQtyRestock;

    public Slot(int slotNum, Item itemToStore, int quantityStored) {
        this.SLOT_NUMBER = slotNum;
        if(quantityStored > 10)
            this.quantityStored = 10;
        else
            this.quantityStored = quantityStored;
        this.itemInSlot = itemToStore;
    }

    public Slot(int slotNum, Item itemToStore) {
        this(slotNum, itemToStore, 0);
    }

    public int getQuantityStored() {
        return quantityStored;
    }

    public Item getItemInSlot() {
        return itemInSlot;
    }

    public int getSlotNum() {
        return SLOT_NUMBER;
    }

    public int getStartQtyRestock() {
        return startQtyRestock;
    }

    public int getEndQtyRestock() {
        return endQtyRestock;
    }

    public void setQuantityStored(int quantityStored) {
        this.quantityStored = quantityStored;
    }

    public void setItemInSlot(Item itemInSlot) {
        this.itemInSlot = itemInSlot;
    }

    public boolean restockSlot(int qty) {
        int total = qty + quantityStored;
        if (!isFull() && total <= QUANTITY_LIMIT){
            quantityStored = total;
            return true;
        }
        return false;
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

    public void displayInfo() {
        System.out.println("- Slot number " + SLOT_NUMBER + " -");
        System.out.println("Item: " + itemInSlot.getName());
        System.out.println("Calories: " + itemInSlot.getCalories());
        System.out.println("Calories: " + itemInSlot.getPrice());
        System.out.println("Quantity: " + quantityStored);
    }

    public String getItemInfo() {
        return itemInSlot.toString();
    }
}
