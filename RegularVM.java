
public class RegularVM {
    private final int NUM_SLOTS;
    private Slot[] slots;
    private CashRegister cashReg;

    public RegularVM() {
        NUM_SLOTS = 8;
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
    }

    public void processPurchase(int[] moneyInserted, int slotIndex){
        Item item = getSlotItem(slotIndex);
        int insertedAmnt = cashReg.computeInsertedAmount(moneyInserted);
        cashReg.computeFinalDenominations((int)item.getPrice(), insertedAmnt);
        
        if (insertedAmnt == 0){
            System.out.println("Purchase Cancelled.");
        }
        else if (cashReg.computeTotalChange()>0 && insertedAmnt > 0)
        {
            cashReg.addMoney(moneyInserted);   
            dispenseItem(slotIndex);   
            cashReg.dispenseTotalChange();  
            cashReg.deductChangeFromMoney();    
            System.out.println("Total Change: PHP" + cashReg.computeTotalChange());
        }
        else if (insertedAmnt == (int)item.getPrice()){
            dispenseItem(slotIndex);
        }
        else{
            System.out.println("Change not enough, dispensing inserted amount...");
            cashReg.displayAmount(moneyInserted);
        }
    }

    public void initializeSlot(int index, Item item, int qty) {
        slots[index] = new Slot(item, qty);
    }

    public boolean isSlotEmpty(int index){
        Slot slotToCheck = slots[index];
        if (slotToCheck == null)
            return true;
        else if(slotToCheck.isEmpty())
            return true;
        return slotToCheck.isEmpty();     
    }

    public boolean isSlotNumValid(int number){
        if (number < 1 || number > NUM_SLOTS)
            return false;
        return true;
    }

    public void dispenseItem(int slotIndex) {
        if(slotIndex < slots.length && slots[slotIndex] != null) {
            Item item = slots[slotIndex].getItemInSlot();
            System.out.println("Dispensing " + item.toString() + "...");
            slots[slotIndex].decrementQtyStored();
            slots[slotIndex].getInventory().incrementQtySold();
            slots[slotIndex].getInventory().decrementQtyEnd();
        }
    }

    public void refillMoney(int[] denominations) {
        cashReg.addMoney(denominations);
    }

    public Item getSlotItem(int slotIndex) {
        if(slotIndex < slots.length) {
            Slot slot = slots[slotIndex];
            return slot.getItemInSlot();
        }
        else
            return null;
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
        int i = 1;
        for(Slot slot : slots){
            if(slot != null) {
                System.out.println("SLOT " + i++);
                System.out.println(slot.toString());
            }
        }
    }
    public CashRegister getCashRegister(){
        return cashReg;
    }

    public void displayInventory() {
        for(Slot slot : slots)
            if(slot != null)
                System.out.println(slot.getItemInfo());
    }

    public void collectMoney(){
        cashReg.displayAmount(cashReg.getMoneyQty());
        cashReg.clearCashRegister();
        System.out.println("Cash Register is now empty.");
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

    public boolean replaceItemInSlot(int index, Item item) {
        Slot slot = slots[index];
        if (slot!=null && slot.isEmpty()){
             slots[index].replaceItem(item);
             return true;
        }
        else
            return false;
    }

    public void displayAllInvInfo() {
        for(Slot slot : slots)
            if(slot != null)
                System.out.println(slot.getInvInfo());
    }

    public void displayAllInvQtySold() {
        for(Slot slot : slots)
            if(slot != null)
                System.out.println(slot.getInvQtySold());
    }
}
