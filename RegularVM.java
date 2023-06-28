public class RegularVM {
    private final int NUM_SLOTS;
    private Slot[] slots;
    private CashRegister cashReg;

    public RegularVM() {
        NUM_SLOTS = 8;
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
    }
    // denominations inserted,
    public void processPurchase(int[] moneyInserted, int slotIndex){
        Item item = getSlotItem(slotIndex);
        int insertedAmnt = cashReg.computeInsertedAmount(moneyInserted);
        cashReg.computeFinalDenominations((int)item.getPrice(), insertedAmnt);
        
        if (insertedAmnt == 0){
            System.out.println("Purchase Cancelled.");
        }
        else if (cashReg.computeTotalChange()>0 && insertedAmnt > 0)
        {
            cashReg.addMoney(moneyInserted);    //WORKING
            dispenseItem(slotIndex);    //WORKING
            cashReg.dispenseTotalChange();  //NOT WORKING
            cashReg.deductChangeFromMoney();      //NOT WORKING
            //add the inserted to money, subtract denomination from money
        }
        else{
            System.out.println("Change not enough, dispensing inserted amount...");
            cashReg.displayAmount(moneyInserted);
        }
        /*
         * 1. compute amount inserted
         * 2. compute final denominations(using itemPrice and inserted amnt)
         * **if change is not enought tlga, magiging zero yung denominations
         *      - if this happens, dispense the amount inserted, do not add to money, do not dispense item
         * ** if denominations = 0 and amntinserted = 0, cancel, do not dispense item, 
         * ** if denominations = 0 and amntinserted > 0, dispense amount inserted, do not dispense item
         * **  and change is enough, dispense item, dispense change, add to money the excess
         */
    }
    public void purchaseItem(int index) {
        if(index <= slots.length && slots[index] != null && !slots[index].isEmpty()) {
            slots[index].decrementQtyStored();
            slots[index].getInventory().incrementQtySold();
            System.out.println(slots[index].getItemInfo());
        }
    }

    public void initializeSlot(int index, Item item, int qty) {
        slots[index] = new Slot(item, qty);
    }
    public boolean isSlotEmpty(int index){
        Slot slotToCheck = slots[index];
        if (slotToCheck == null)
            return true;
        return slotToCheck.isEmpty();
            
    }
    public boolean isSlotNumValid(int number){
        if (number < 1 || number > NUM_SLOTS)
            return false;
        return true;
    }
    //baka di magamit
    public void dispenseItem(Item item) {
        for(Slot slot : slots)
            if(slot != null && !slot.isEmpty() && slot.getItemInSlot().equals(item)) {
                System.out.printf("Dispensed item: %s\n", item.toString());
                slot.decrementQtyStored();
                slot.getInventory().incrementQtySold();
            }
    }

    public void dispenseItem(int slotIndex) {
            Slot slot = slots[slotIndex];
            Item item = slot.getItemInSlot();
            System.out.println("Dispensing "+ item.toString() + "...");
            slot.decrementQtyStored();
            slot.getInventory().incrementQtySold();
            slots[slotIndex] = slot;
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

    public Item getSlotItem(int slotIndex){
        Slot slot = slots[slotIndex];
        return slot.getItemInSlot();
    }

    public void setItemQuantity(int index, int quantity) {
        if(slots[index] != null && quantity <= 10) {
            slots[index].setQuantityStored(quantity);

            if(slots[index].getQuantityStored() < quantity) {
                int diff = quantity - slots[index].getQuantityStored();
                slots[index].getInventory().registerRestock(diff);
            }
        }
    }

    public void restockSlot(int index, int qty) {
        if(slots[index] != null)
            slots[index].restockItem(qty);
    }

    public boolean isItemDuplicate(Item item) {
        boolean isNull = false;
        for(Slot slot : slots){
            isNull = false;
            if (slot == null)
                isNull = true;
            if(!isNull && item.equals(slot.getItemInSlot()))
                return true;
        }
            
        return false;
    }

    public void displaySlots() {
        for(Slot slot : slots)
            System.out.println(slot.toString());
    }
    public CashRegister getCashRegister(){
        return cashReg;
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