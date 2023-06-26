public class RegularVM {
    //I NEED HELP IM KINDA CONFUSED
    private final int NUM_SLOTS = 8;
    private Slot[] slots;
    private CashRegister cashReg;

    // abe: hopefully these constructors arent too many
    public RegularVM() {
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
        
    }
    
    public void purchaseItem(int slotNum) {
        for(Slot slot : slots)
            if(slot.getSlotNum() == slotNum && !slot.isEmpty())
                slot.setQuantityStored(slot.getQuantityStored() - 1);
    }
    public void initializeSlot(int index, Item item, int qty) {
        slots[index] = new Slot(index, item, qty);
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
        cashReg.addMoney(denominations);
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

    public void displaySlots() {
       /*  for(Slot slot : slots)
            System.out.println(slot.toString());*/
            
            for (int i = 0; i < 8; i++){
                 Slot slot = slots[i];
                slot.displayInfo();
            }
    }

    public void displayInventory() {
        for(Slot slot : slots) {
            System.out.println(slot.getItemInfo());
        }
    }
    public void displayMoneyQty(){
        int[] moneyQty = cashReg.getMoneyQty();

        System.out.println("--MONEY STORED--");
        System.out.println("1 peso coins: " + moneyQty[0]);
        System.out.println("5 peso coins: " + moneyQty[1]);
        System.out.println("10 peso coins: " + moneyQty[2]);
        System.out.println("20 peso bills: " + moneyQty[3]);
        System.out.println("50 peso bills: " + moneyQty[4]);
        System.out.println("100 peso bills: " + moneyQty[5]);
        System.out.println("200 peso bills: " + moneyQty[6]);
        System.out.println("500 peso bills: " + moneyQty[7]);
        System.out.println("1000 peso bills: " + moneyQty[8]);
    }
}
