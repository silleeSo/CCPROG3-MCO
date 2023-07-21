/**
 * This class represents a regular vending machine.
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class RegularVM {
    private final int NUM_SLOTS;
    private Slot[] slots;
    private CashRegister cashReg;
    /**
     * This method creates an instance of RegularVM. It sets the NUM_SLOTS attribute to 8, instantiates the slots array, and creates an instance of CashRegister for this instance of RegularVM
     */
    public RegularVM() {
        NUM_SLOTS = 8;
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
    }
    /**
     * This method process the purchase of the user.
     * @param moneyInserted the integer array containing the quantities of each type of bill and coin the user has inserted
     * @param slotIndex the slot index of the users choice
     */
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
            //cashReg.deductChangeFromMoney();   no need, since nagmiminus na sa computeFinalDeno 
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
    /**
     * This method instantiates a slot from slots array in this instance of RegularVM. This is method is used during the initialization of a vending machine by user.
     * @param index the slot index to instantiate
     * @param item the item to add to the selected slot
     * @param qty the quantity of the item to add
     */
    public void initializeSlot(int index, Item item, int qty) {
        slots[index] = new Slot(item, qty);
    }
    /**
     * This method checks if a specific slot is empty using the slot index. It returns true if it is empty and false if it is not.
     * @param index the slot index of the slot to check
     * @return the state of the slot, true for empty and false for not empty 
     */
    public boolean isSlotEmpty(int index){
        Slot slotToCheck = slots[index];
        if (slotToCheck == null)
            return true;
        else if(slotToCheck.isEmpty())
            return true;
        return slotToCheck.isEmpty();     
    }
    /**
     * This method checks if a given slot number is valid. Valid numbers include numbers 1 to 8.
     * @param number the given slot number
     * @return true if the number is valid, false if it is not
     */
    public boolean isSlotNumValid(int number){
        if (number < 1 || number > NUM_SLOTS)
            return false;
        return true;
    }
    /**
     * This method simulates the dispensing of an item in a regular vending machine.
     * @param slotIndex the slot index of the slot to dispense from
     */
    public void dispenseItem(int slotIndex) {
        if(slotIndex < slots.length && slots[slotIndex] != null) {
            Item item = slots[slotIndex].getItemInSlot();
            System.out.println("Dispensing " + item.toString() + "...");
            slots[slotIndex].decrementQtyStored();
            slots[slotIndex].getInventory().incrementQtySold();
            slots[slotIndex].getInventory().decrementQtyEnd();
        }
    }
    /**
     * This method refills the CashRegister of this instance of RegularVM given an integer array containing the quantities of each bill and coin.
     * @param denominations the integer array containing the quantities of each bill and coin.
     */
    public void refillMoney(int[] denominations) {
        cashReg.addMoney(denominations);
    }
    /**
     * This method returns the item of a slot given the slot index.
     * @param slotIndex the given slot index
     * @return the item in the specified slot
     */
    public Item getSlotItem(int slotIndex) {
        if(slotIndex < slots.length) {
            Slot slot = slots[slotIndex];
            return slot.getItemInSlot();
        }
        else
            return null;
    }
    /**
     * This method restocks a slot given a specified slot index and a quantity
     * @param index the slot index of slot to restock
     * @param qty the quantity to add to the specified slot
     */
    public void restockSlot(int index, int qty) {
        if(slots[index] != null)
            slots[index].restockItem(qty);
    }
    /**
     * This method checks if a given item already exists in this instance of vending machine.
     * @param item the given item to check
     * @return true if item is duplicate, false if it is not.
     */
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
    /**This method displays the information of all slots in this instance of RegularVM */
    public void displaySlots() {
        int i = 1;
        for(Slot slot : slots){
            if(slot != null) {
                System.out.println("SLOT " + i++);
                System.out.println(slot.toString());
            }
        }
    }
    /**
     * This method returns the CshRegister of thsi instance of RegularVM
     * @return the CashRegister of this vending machine
     */
    public CashRegister getCashRegister(){
        return cashReg;
    }
    /**
     * This method displays the all item information in this RegularVM
     */
    public void displayInventory() {
        for(Slot slot : slots)
            if(slot != null)
                System.out.println(slot.getItemInfo());
    }
    /**
     * This method collects all money stored in the CashRegister of this instance of RegularVM. It clears the CashRegister and dispenses it.
     */
    public void collectMoney(){
        cashReg.displayAmount(cashReg.getMoneyQty());
        cashReg.clearCashRegister();
        System.out.println("Cash Register is now empty.");
    }
    /**
     * This method displays the money stored in the CashRegister of this RegularVM. It specifies the kind of bill or coin and their quantities.
     */
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
    /**
     * This method replaces the item assigned to a slot in this RegularVM given a slot index and an item. 
     * @param index the given slot index
     * @param item the new item that replaces to current one
     * @return true if replacement was successful, false if it is not
     */
    public boolean replaceItemInSlot(int index, Item item) {
        Slot slot = slots[index];
        if (slot!=null && slot.isEmpty()){
             slots[index].replaceItem(item);
             return true;
        }
        else
            return false;
    }
    /**
     * This method displays the inventory information of all slots in this RegualrVM.
     */
    public void displayAllInvInfo() {
        for(Slot slot : slots)
            if(slot != null)
                System.out.println(slot.getInvInfo());
    }
    /**
     * This method display the transaction history for all slots since last restocking in this RegularVM
     */
    public void displayAllInvQtySold() {
        for(Slot slot : slots)
            if(slot != null)
                System.out.println(slot.getInvQtySold());
    }
}
