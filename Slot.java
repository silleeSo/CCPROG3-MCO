public class Slot {
    //KINDA FINISHED ISH TOO
    final int QUANTITY_LIMIT = 10;
    final int SLOT_NUMBER;
    private int quantityStored;
    private Item itemInSlot;

    public Slot(int slotNum, Item itemToStore, int quantityStored) {
        this.SLOT_NUMBER = slotNum;
        if(quantityStored >= 10)
            this.quantityStored = quantityStored;
        else
            this.quantityStored = 10;
        this.itemInSlot = itemToStore;
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
        System.out.println("Quantity: " + quantityStored);
    }

    public String getItemInfo() {
        return itemInSlot.toString();
    }
}
