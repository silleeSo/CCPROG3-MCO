public class RegularVM {
    //I NEED HELP IM KINDA CONFUSED
    private int numberOfSlots;
    private static final int MIN_SLOTS = 8;
    private Slot[] slots = new Slot[MIN_SLOTS];
    private CashRegister cashReg;

    // abe: hopefully these constructors arent too many
    public RegularVM(int[] denominations) {
        this(denominations, 8);
    }

    public RegularVM(int[] denominations, int numberOfSlots) {
        if(numberOfSlots >= 8)
            this.numberOfSlots = numberOfSlots;
        else
            this.numberOfSlots = 8;
        cashReg = new CashRegister(denominations);
    }

    public RegularVM(int numberOfSlots) {
        if(numberOfSlots >= 8)
            this.numberOfSlots = numberOfSlots;
        else
            this.numberOfSlots = 8;
        cashReg = new CashRegister();
    }

    public RegularVM() {
        this.numberOfSlots = 8;
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

    // abe: what is this supposed to do? System.out.println?
    public void dispenseChange() {

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
        if(!isItemDuplicate(item))
            slots[index].setItemInSlot(item);
    }

    public void setItemQuantity(int index, int quantity) {
        slots[index].setQuantityStored(quantity);
    }

    public void restockSlot(int index, int qty) {
        slots[index].restockSlot(qty);
    }

    public boolean isItemDuplicate(Item item) {
        for(Slot slot : slots)
            if(slot.getItemInSlot().equals(item))
                return true;
        
        return false;
    }

    public void displaySlots() {
        for(Slot slot : slots)
            System.out.println(slot.toString());
    }

    public void displayInventory() {
        for(Slot slot : slots) {
            System.out.println(slot.getItemInfo());
        }
    }
}