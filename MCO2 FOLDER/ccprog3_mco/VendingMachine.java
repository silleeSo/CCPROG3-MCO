package ccprog3_mco;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * This abstract class contains all the commone attributes and methods of a Vending Machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public abstract class VendingMachine {
    /**This attribute contains the number of slots in a vending */
    private final int NUM_SLOTS;
    /**This attribute represents the slots in a vending machine*/
    private Slot[] slots;
    /**This attribute represents the cash register in a vending machine*/
    private CashRegister cashReg;
    /**This attribute contains the sample, modifiable selection of items the user may select from*/
    private ArrayList<Item> itemPool;
    /**This attribute contains the maximum slot capacity for each slot in a vending machine*/
    private int SLOT_CAP;
    
    /**
     * This constructor represents the creation of a vending machine
     * @param numSlots the number of slots in a vending machine
     * @param slotCapacity the maximum slot capacity of a vending machine
     */
    public VendingMachine(int numSlots, int slotCapacity) {
        NUM_SLOTS = numSlots;
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
        for(int i = 0; i <= numSlots - 1; i++)
            slots[i] = new Slot(slotCapacity);
        itemPool = new ArrayList<Item>();
        this.SLOT_CAP = slotCapacity;
    }
    
    /**
     * This method checks if a specific slot is empty using the slot index. It returns true if it is empty and false if it is not.
     * @param index the slot index of the slot to check
     * @return the state of the slot, true for empty and false for not empty 
     */
    public boolean isSlotEmpty(int index){
        Slot slotToCheck = slots[index];
        return slotToCheck.isEmpty();     
    }
    /**
     * This method checks if a given slot number is valid. 
     * @param number the given slot number
     * @return true if the number is valid, false if it is not
     */
    public boolean isSlotNumValid(int number){
        if (number < 1 || number > NUM_SLOTS)
            return false;
        return true;
    }
    /**
     * This method simulates the dispensing of an item in a vending machine
     * @param slotIndex the slot index of the slot to dispense from
     * @return String containing result of dispense item attempt
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
     * This method refills the CashRegister of a vending machine given a money type and a quantity
     * @param moneyType the kind of money to refill with
     * @param qty the quantity of the specified money type
     */
    public void refillMoney(int moneyType, int qty) {
        cashReg.addBill(moneyType, qty);
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
            boolean isSoldAlone = slot.getIsSoldAlone();
            String preparation = slot.getPreparation();
            return new Item(itemName,price,calories, isSoldAlone, preparation);
        }
        else
            return null;
    }
    /**
     * This method restocks a slot given a specified slot index and a quantity
     * @param index the slot index of slot to restock
     * @param qty the quantity to add to the specified slot
     * @return true if slock was successfully restocked, false if now
     */
    public boolean restockSlot(int index, int qty) {
        int newTotal = slots[index].getQuantityStored() + qty;
        if (newTotal > SLOT_CAP || slots[index].isFull() || slots[index] == null) //exceed capacity or is full
            return false;
        else {
            for (int i = 0; i < NUM_SLOTS; i++){
                if(i == index)
                    slots[i].restockItem(qty);
                else
                    slots[i].restockItem(0);
            }         
            return true;    //successful restock
        }
        
    }
    /**
     * This method checks if a given item already exists in a vending machine.
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
    /**This method returns a String containing the information of all slots in a vending machine
     * @return the String containing all slot information
    */
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
     * This method returns the CashRegister of a vending machine
     * @return the CashRegister of this vending machine
     */
    public CashRegister getCashRegister(){
        return cashReg;
    }
    /**
     * This method displays the all item information in a vending machine
     * @return String containing item information for all slots
     */
    public String displayAllItemInfo() {
        String finalStr = "";
        for(Slot slot : slots)
            if(slot != null)
                finalStr += (slot.getItemInfo() + "\n");
                //System.out.println(slot.getItemInfo());
            return finalStr;
    }
    /**
     * This method collects all money stored in the CashRegister of a vending machine.
     * @return String containing dispensed amount and message signifying an empty cash register
     */
    public String collectAllMoney(){
        cashReg.clearCashRegister();
        return cashReg.toStringAmount(cashReg.getMoneyQty()) + "\nCash Register is now empty.";
    }

    /**
     * This method collects a specified amount from a vending machine
     * @param amount the amount to gather in denominations
     * @return the String detailing result of money collection
     */
    public String collectMoney(int amount){
        if (cashReg.gatherMoney(amount))
            return cashReg.dispenseTotalChange();
        return "Not enough money in vending machine.";
    }
    /**
     * This method displays the money stored in the CashRegister of a vending machine. It specifies the kind of bill or coin and their quantities.
     * @return the stored quantities per money type in CashRegister
     */
    public String displayMoneyQty(){
        int[] moneyQty = cashReg.getMoneyQty();
        String finalStr = "";
        finalStr += "1 peso coins: " + moneyQty[0] + "     ";
        finalStr += "5 peso coins: " + moneyQty[1] + "     ";
        finalStr += "10 peso coins: " + moneyQty[2] + "     ";
        finalStr += "20 peso coins: " + moneyQty[3] + "     ";
        finalStr += "50 peso bills: " + moneyQty[4] + "     ";
        finalStr += "100 peso bills: " + moneyQty[5] + "     ";
        finalStr += "200 peso bills: " + moneyQty[6] + "     ";
        finalStr += "500 peso bills: " + moneyQty[7] + "     ";
        finalStr += "1000 peso bills: " + moneyQty[8] + "     ";
        return finalStr;
    }
    /**
     * This method replaces the item assigned to a slot in a vending machine given a slot index and an item. 
     * @param slotIndex the given slot index
     * @param item the new item that replaces to current one
     * @return true if replacement was successful, false if it is not
     */
    public boolean replaceItemInSlot(int slotIndex, Item item) {
        Slot slot = slots[slotIndex];
        if (slot!=null && slot.isEmpty()){
             slots[slotIndex].replaceItem(item);
             return true;
        }
        else
            return false;
    }
    /**
     * This method displays the inventory information of all slots in a vending machine
     * @return String containing inventory information of all slots
     */
    public String displayAllInvInfo() {
        String finalStr = "";
        for(Slot slot : slots)
            if(slot != null)
                finalStr += slot.getInvInfo() + "\n";
        return finalStr;
    }
    
    /**
     * This method initializes the item pool from which the user may select from
     */
    public void initializeItemPool(){
        itemPool.add(new Item("Sausage",15,55, true, "frying"));
        itemPool.add(new Item("Fried Egg",15,20, true, "frying"));
        itemPool.add(new Item("Asado Pork",40,105, false, "simmering"));
        itemPool.add(new Item("Beef Brisket",40,70, false, "boiling"));
        itemPool.add(new Item("Chicken Leg",50,75, true, "marinating"));
        itemPool.add(new Item("Duck Leg", 65,80, true, "marinating"));
        itemPool.add(new Item("Vegetables",60,45, false, "chopping"));
        itemPool.add(new Item("Noodle Base",60,45, true, "blanching and seasoning"));
    }
    /**
     * This method creates a new item to be added to itemPool
     * @param itemName name of new item
     * @param price price of new item
     * @param calories calorie count of new item
     * @param isSoldAlone stand-alone vendibility of new item
     * @param preparations preparation method of new item
     * @return true if item was successfully created and added to itemPool, false if not
     */
    public boolean createNewItem(String itemName, double price, double calories, boolean isSoldAlone, String preparations){
        Item item = new Item(itemName, price, calories, isSoldAlone, preparations);
        if (!isItemDuplicate(item)){
            itemPool.add(new Item(itemName, price, calories, isSoldAlone, preparations));
            return true;
        }
        return false;

    }
    /**
     * This method reprices the item in a specified slot.
     * @param newPrice the new price of the item
     * @param slotIndex the slot index of the item
     * @return true if item was successfully repriced, false if not
     */
    public boolean repriceItem(double newPrice, int slotIndex){
        if (newPrice == Math.floor(newPrice) && newPrice >= 0){//checks if newPrice has centavoes
            slots[slotIndex].setItemPrice(newPrice);
            return true;
        }
            return false;
    }
    /**
     * This method updates the CashRegister of a vending machine.
     * @param moneyTally the quantities of each money type in the form of a HashMap
     * @param denominationsTally the quantities of each money type upon computing denominations in the form of a HashMap
     * @param money the ArrayList of Money in a CashRegister
     */
    public void updateCashRegister(HashMap<Integer,Integer> moneyTally, HashMap<Integer, Integer> denominationsTally, ArrayList<Money> money){
        cashReg.updateMoneyTally(moneyTally);
        cashReg.updateDenominationsTally(denominationsTally);
        cashReg.updateMoney(money);
    }
    /**
     * This method checks if a specified slot is assigned or labeled to an item
     * @param slotIndex the index of the slot to check
     * @return true if the slot is assigned to an item, false if not
     */
    public boolean isSlotAssigned(int slotIndex){
        if (slotIndex > NUM_SLOTS-1)
            return false;
        if (slots[slotIndex].isSlotAssigned())
            return true;
        else
            return false;
    }
    /**
     * This method returns the itemPool of a vending machine
     * @return itemPool ArrayList
     */
    public ArrayList<Item> getItemPool(){
        return itemPool;
    }
    /**
     * This method checks if a number is a valid amount for price (in the context of a vending machine)
     * @param num the number to check
     * @return true if number is valid (non-negative, and no decimal places), false if not
     */
    public boolean isNumberValid(int num){
        return cashReg.isMoneyQtyValid(num) && num == Math.floor(num);
    }
    /**
     * This method returns the slots of a vending machine
     * @return ArrayList of Slots
     */
    public Slot[] getSlots() {
        return slots;
    }
}