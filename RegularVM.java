public class RegularVM {
    //I NEED HELP IM KINDA CONFUSED
    private final int NUM_SLOTS = 8;
    private Slot[] slots;
    private CashRegister cashReg;

    // abe: hopefully these constructors arent too many
    public RegularVM(int[] denominations) {
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister(denominations);
    }

    public RegularVM() {
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
    }
    
    public void purchaseItem(int slotNum) {
        for(Slot slot : slots)
            if(slot.getSlotNum() == slotNum && !slot.isEmpty())
                slot.setQuantityStored(slot.getQuantityStored() - 1);
    }

    public void dispenseItem(Item item) {
        for(Slot slot : slots)
            if(slot.getItemInSlot().equals(item) && !slot.isEmpty()) {
                System.out.printf("Dispensed item: %s\n", item.toString());
                slot.setQuantityStored(slot.getQuantityStored() - 1);
            }
    }

    public void refillMoney(int[] denominations) {
        // abe: sorry idk how to deal with this QwQ
        cashReg = new CashRegister(denominations);
    }

    public void swapSlotItems(int slotNum1, int slotNum2) {
        Item temp1 = null;
        Item temp2 = null;
        //if slotNum cant match a slot, it is swapped with null

        for(Slot slot : slots) {
            if(slot.getSlotNum() == slotNum1)
                temp1 = slot.getItemInSlot();

            if(slot.getSlotNum() == slotNum2)
                temp2 = slot.getItemInSlot();
        }

        for(Slot slot : slots) {
            if(slot.getSlotNum() == slotNum1)
                slot.setItemInSlot(temp2);

            if(slot.getSlotNum() == slotNum2)
                slot.setItemInSlot(temp1);
        }
    }

    public void setSlotItem(int index, Item item) {
        if(!isItemDuplicate(item) && index <= NUM_SLOTS - 1)
            slots[index].setItemInSlot(item);
    }

    public void setItemQuantity(int index, int quantity) {
        slots[index].setQuantityStored(quantity);
    }

    public void restockSlot(int index, int qty) {
        slots[index].restockItem(qty);
    }

    public boolean isItemDuplicate(Item item) {
        for(Slot slot : slots)
            if(slot.getItemInSlot().equals(item))
                return true;
        
        return false;
    }

    public void displayVMSlots() {
        for(Slot slot : slots)
            slot.displaySlotInfo();
    }

    public void displayInventory() {
        for(Slot slot : slots) {
            System.out.println(slot.getItemInfo());
        }
    }
}
