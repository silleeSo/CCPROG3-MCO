public class RegularVM {
    private final int NUM_SLOTS = 8;
    private Slot[] slots;
    private CashRegister cashReg;

    public RegularVM() {
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
    }
    
    public void purchaseItem(int index) {
        if(index <= slots.length && slots[index] != null && !slots[index].isEmpty()) {
            slots[index].decrementQtyStored();
            System.out.println(slots[index].getItemInfo());
        }
    }

    public void initializeSlot(int index, Item item, int qty) {
        slots[index] = new Slot(item, qty);
    }

    public void dispenseItem(Item item) {
        for(Slot slot : slots)
            if(slot != null && !slot.isEmpty() && slot.getItemInSlot().equals(item)) {
                System.out.printf("Dispensed item: %s\n", item.toString());
                slot.decrementQtyStored();
            }
    }

    public void refillMoney(int[] denominations) {
        cashReg.addMoney(denominations);
    }

    public void swapSlotItems(int index1, int index2) {
        Item temp = null;

        if(index1 <= slots.length && slots[index1] != null &&
           index2 <= slots.length && slots[index2] != null) {
            temp = slots[index1].getItemInSlot();
            slots[index1].setItemInSlot(slots[index2].getItemInSlot());
            slots[index2].setItemInSlot(temp);
        }
    }

    public void setSlotItem(int index, Item item) {
        if(!isItemDuplicate(item) && index <= NUM_SLOTS - 1)
            slots[index].setItemInSlot(item);
    }
    
    public void setItemQuantity(int index, int quantity) {
        if(quantity <= 10)
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
        for(Slot slot : slots)
            System.out.println(slot.toString());
    }

    public void displayInventory() {
        for(Slot slot : slots) 
            System.out.println(slot.getItemInfo());
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