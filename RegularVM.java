/**
 * This class represents a regular vending machine.
 * @author So, Chrysille
 * @author Chen, Abraham
 */
import java.util.ArrayList;
public class RegularVM {
    private final int NUM_SLOTS;
    private Slot[] slots;
    private CashRegister cashReg;
    private ArrayList<Item> itemPool;
    
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
    //NOTE: THIS NOW RETURNS THE STRING INSTEAD OF PRINTING
    public String processPurchase(int[] moneyInserted, int slotIndex){
        Item item = getSlotItem(slotIndex);
        int insertedAmnt = cashReg.computeInsertedAmount(moneyInserted);
        cashReg.computeChangeDenomination(insertedAmnt, (int)item.getPrice(), 8);
        if (insertedAmnt == 0)
            return "Purchase Cancelled";
        
        else if (cashReg.computeTotalChange()>0 && insertedAmnt > 0)
        {
            cashReg.addMoney(moneyInserted);   
            return dispenseItem(slotIndex) + "\n" + cashReg.dispenseTotalChange() + "Total Change: PHP" + cashReg.computeTotalChange();
        }
        else if (insertedAmnt == (int)item.getPrice())
            return dispenseItem(slotIndex)  + "\n";
        else
            return "Change not enough, dispensing inserted amount...\n" + cashReg.toStringAmount(moneyInserted);
        
    }
    /**
     * This method instantiates a slot from slots array in this instance of RegularVM. This is method is used during the initialization of a vending machine by user.
     * @param index the slot index to instantiate
     * @param item the item to add to the selected slot
     * @param qty the quantity of the item to add
     */
    public void initializeSlot(int index, String name, double price, double calories, int qty) {
        slots[index] = new Slot(name, price, calories, qty);
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
    public String dispenseItem(int slotIndex) {
        if(slotIndex < slots.length && slots[slotIndex] != null) {
            String itemName = slots[slotIndex].getItemNameInSlot();
            slots[slotIndex].decrementQtyStored();
            slots[slotIndex].getInventory().incrementQtySold();
            slots[slotIndex].getInventory().decrementQtyEnd();
            return "Dispensing " + itemName + "...";
        }
        return null;
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
            String itemName = slot.getItemNameInSlot();
            double calories = slot.getItemCaloriesInSlot();
            double price = slot.getItemPriceInSlot();
            return new Item(itemName,price,calories);
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
        for (int i = 0; i < NUM_SLOTS; i++){
            if(i == index && slots[index] != null)
                slots[i].restockItem(qty);
            else
                slots[i].restockItem(0);
        }         
    }
    /**
     * This method checks if a given item already exists in this instance of vending machine.
     * @param item the given item to check
     * @return true if item is duplicate, false if it is not.
     */
    public boolean isItemDuplicate(Item item) {
        String itemName = item.getName();
        boolean isNull = false;
        for(Slot slot : slots){
            isNull = false;
            if (slot == null)
                isNull = true;
            if(!isNull && itemName.equals(slot.getItemNameInSlot()))
                return true;
        }
        return false;
    }
    /**This method displays the information of all slots in this instance of RegularVM */
    public String displaySlots() {
        int i = 1;
        String finalStr = "";
        for(Slot slot : slots){
            if(slot != null) {
                finalStr += "SLOT " + (i++) + "\n" + slot.toString();
            }
        }
        return finalStr;
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
    //PREVIOUSLY displayInventory
    public String displayAllItemInfo() {
        String finalStr = "";
        for(Slot slot : slots)
            if(slot != null)
                finalStr += (slot.getItemInfo() + "\n");
                //System.out.println(slot.getItemInfo());
            return finalStr;
    }
    /**
     * This method collects all money stored in the CashRegister of this instance of RegularVM. It clears the CashRegister and dispenses it.
     */
    public String collectAllMoney(){
        cashReg.clearCashRegister();
        return cashReg.toStringAmount(cashReg.getMoneyQty()) + "\nCash Register is now empty.";
    }
    public String collectMoney(int[] qty){
        cashReg.collectMoney(qty);
        return cashReg.toStringAmount(qty) + "\nDispensed Amount.";
    }
    /**
     * This method displays the money stored in the CashRegister of this RegularVM. It specifies the kind of bill or coin and their quantities.
     */
    public String displayMoneyQty(){
        int[] moneyQty = cashReg.getMoneyQty();
        String finalStr = "";
        finalStr += "1 peso coins: " + moneyQty[0] + "\n";
        finalStr += "1 peso coins: " + moneyQty[1] + "\n";
        finalStr += "1 peso coins: " + moneyQty[2] + "\n";
        finalStr += "1 peso coins: " + moneyQty[3] + "\n";
        finalStr += "1 peso coins: " + moneyQty[4] + "\n";
        finalStr += "1 peso coins: " + moneyQty[5] + "\n";
        finalStr += "1 peso coins: " + moneyQty[6] + "\n";
        finalStr += "1 peso coins: " + moneyQty[7] + "\n";
        finalStr += "1 peso coins: " + moneyQty[8] + "\n";
        return finalStr;
    }
    /**
     * This method replaces the item assigned to a slot in this RegularVM given a slot index and an item. 
     * @param index the given slot index
     * @param item the new item that replaces to current one
     * @return true if replacement was successful, false if it is not
     */
    public boolean replaceItemInSlot(int slotIndex, int itemPoolIndex) {
        Slot slot = slots[slotIndex];
        Item item = itemPool.get(itemPoolIndex);
        if (slot!=null && slot.isEmpty()){
             slots[slotIndex].replaceItem(item.getName(), item.getPrice(), item.getCalories());
             return true;
        }
        else
            return false;
    }
    /**
     * This method displays the inventory information of all slots in this RegualrVM.
     */
    public String displayAllInvInfo() {
        String finalStr = "";
        for(Slot slot : slots)
            if(slot != null)
                finalStr += slot.getInvInfo() + "\n";
        return finalStr;
    }
    /**
     * This method display the transaction history for all slots since last restocking in this RegularVM
     */
    public String displayAllInvQtySold() {
        String finalStr = "";
        for(Slot slot : slots)
            if(slot != null)
                finalStr += slot.getInvInfo() + "\n";
        return finalStr;
    }
    /*
     * fix replace item (limited to item pool)
     * add method for create new it4em in it4em pool
     * initialize item pool
     * 
     */
    public void initializeItemPool(){
        itemPool.add(new Item("Sausage",15,55));
        itemPool.add(new Item("Fried Egg",15,20));
        itemPool.add(new Item("Asado Pork",40,105));
        itemPool.add(new Item("Beef Brisket",40,70));
        itemPool.add(new Item("Chicken Leg",50,75));
        itemPool.add(new Item("Duck Leg", 65,80));
        itemPool.add(new Item("Vegtable Side",60,45));
    }
    public void createNewItem(String itemName, double price, double calories){
        itemPool.add(new Item(itemName, price, calories));
    }
}
