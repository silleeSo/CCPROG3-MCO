import java.util.ArrayList;
import java.util.HashMap;
abstract class VendingMachine {
    private final int NUM_SLOTS;
    private Slot[] slots;
    private CashRegister cashReg;
    private ArrayList<Item> itemPool;
    private int slotCapacity;
    
    /**
     * This constructor initializes the attributes of this abstract class
     * @param numSlots the number of slots in the vending machine
     * @param slotCapacity the capacity of each slot in the vending machine
     */
    public VendingMachine(int numSlots, int slotCapacity) {
        NUM_SLOTS = numSlots;
        slots = new Slot[NUM_SLOTS];
        cashReg = new CashRegister();
        this.slotCapacity = slotCapacity;
        for (Slot slot : slots)
            slot = new Slot(slotCapacity);
    }
    /**
     * This method updates the information of a specified slot
     * @param index the index of the slot to edit;
     * @param name the item name labeled on the slot
     * @param price the item price labeled on the slot
     * @param calories the item calories labeled on the slot
     * @param qty the item quantity of the slot
     */
    public void updateSlot(int index, String name, double price, double calories, int qty) {
        slots[index].updateSlot(name, price, calories, qty);
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
     * @return String indicating the dispensing of an item
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
     * This method refills the CashRegister of this instance of RegularVM given a money type and a quantity.
     * @param moneyType the type of money to replenish
     * @param qty the money quantity to add to vending machine cash register
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
            return new Item(itemName,price,calories);
        }
        else
            return null;
    }
    /**
     * This method restocks a slot given a specified slot index and a quantity
     * @param index the slot index of slot to restock
     * @param qty the quantity to add to the specified slot
     * @return true if restocking was successful, false if not
     */
    public boolean restockSlot(int index, int qty) {
        int newTotal = slots[index].getQuantityStored() + qty;
        if (newTotal > slotCapacity || slots[index].isFull() ||  slots[index] == null) //exceed capacity or is full
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
    /**T
     * his method displays the information of all slots in this instance of RegularVM 
     * @return String containing slot information
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
     * This method returns the CshRegister of thsi instance of RegularVM
     * @return the CashRegister of this vending machine
     */
    public CashRegister getCashRegister(){
        return cashReg;
    }
    
    /**
     * This method creates a string containing the item information for each slot in this RegularVM
     * @return string with item informations
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
     * This method collects all money stored in the CashRegister. It clears the CashRegister and dispenses it.
     * @return String indicating successful collection
     */
    public String collectAllMoney(){
        cashReg.clearCashRegister();
        return cashReg.toStringAmount(cashReg.getMoneyQty()) + "\nCash Register is now empty.";
    }
    /**
     * This method collects money from the CashRegister given the quantities of each money type
     * @param qty integer array containing quantities corresponding to each money type
     * @return String containing dispensed amount
     */
    public String collectMoney(int[] qty){
        cashReg.collectMoney(qty);
        return cashReg.toStringAmount(qty) + "\nDispensed Amount.";
    }
    //alternative to using an int array
    /**
     * This method collects money from the CashRegister given a specified amount
     * @param amount the amount to collect from CashRegister
     * @return String indicating result of collection attempt
     */
    public String collectMoney(int amount){
        if (cashReg.gatherMoney(amount))
            return cashReg.dispenseTotalChange();
        return "Not enough money in vending machine.";
    }
    /**
     * This method creates a string containing the stored quantity of each money type
     * @return String containing information of the stored money
     */
    public String displayMoneyQty(){
        int[] moneyQty = cashReg.getMoneyQty();
        String finalStr = "";
        finalStr += "1 peso coins: " + moneyQty[0] + "\n";
        finalStr += "5 peso coins: " + moneyQty[1] + "\n";
        finalStr += "10 peso coins: " + moneyQty[2] + "\n";
        finalStr += "20 peso coins: " + moneyQty[3] + "\n";
        finalStr += "50 peso coins: " + moneyQty[4] + "\n";
        finalStr += "100 peso coins: " + moneyQty[5] + "\n";
        finalStr += "200 peso coins: " + moneyQty[6] + "\n";
        finalStr += "500 peso coins: " + moneyQty[7] + "\n";
        finalStr += "1000 peso coins: " + moneyQty[8] + "\n";
        return finalStr;
    }
    /**
     * This method replaces the item assigned to a slot in this RegularVM given a slot index and an item. 
     * @param slotIndex the given slot index
     * @param itemPoolIndex the item pool index of new item that replaces to current one
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
     * This method creates a String containing the inventory information of all slots in this RegularVM.
     * @return String containing inventory information
     */
    public String displayAllInvInfo() {
        String finalStr = "";
        for(Slot slot : slots)
            if(slot != null)
                finalStr += slot.getInvInfo() + "\n";
        return finalStr;
    }
    /**
     * This method creates a String containing the transaction history of this RegularVM.
     * @return String containing transaction history
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
    /**
     * This method initialize the item pool from which the user may select from
     */
    public void initializeItemPool(){
        itemPool.add(new Item("Sausage",15,55, true, "frying"));
        itemPool.add(new Item("Fried Egg",15,20, true, "frying"));
        itemPool.add(new Item("Asado Pork",40,105, false, "simmering"));
        itemPool.add(new Item("Beef Brisket",40,70, false, "boiling"));
        itemPool.add(new Item("Chicken Leg",50,75, true, "marinating"));
        itemPool.add(new Item("Duck Leg", 65,80, true, "marinating"));
        itemPool.add(new Item("Vegtables",60,45, false, "chopping"));
        itemPool.add(new Item("Noodle base",60,45, true, "blanching and seasoning"));
    }
    /**
     * This method creates a new instance of Item and adds it to the pre-existing itemPool
     * @param itemName name of new Item
     * @param price price of new Item
     * @param calories calorie count of new Item
     * @param isSoldAlone standalone vendability of new Item
     * @param preparations preparation procedure of new Item
     * @return true if item creation was successful, false if not
     */
    public boolean createNewItem(String itemName, double price, double calories, boolean isSoldAlone, String preparations){
        Item item = new Item(itemName, price, calories, isSoldAlone, preparations);
        if (!isItemDuplicate(item)){
            itemPool.add(new Item(itemName, price, calories));
            return true;
        }
        return false;
            
    }
    /**
     * This method reprices an item given the slot index and the new price
     * @param newPrice new price of Item
     * @param slotIndex slot index of Item to reprice
     * @return true if repricing was successful, false if not
     */
    public boolean repriceItem(double newPrice, int slotIndex){
        if (newPrice == Math.floor(newPrice) && newPrice >= 0){//checks if newPrice has centavoes
            slots[slotIndex].setItemPrice(newPrice);
            return true;
        }
            return false;
    }
    /**
     * This method updates the CashRegister given the tally for money, tally for denominations, and container of Money
     * @param moneyTally HashMap containing tally for money stored
     * @param denominationsTally HashMap containg tally for denominations computed or allocated
     * @param money ArrayList containing instances of Money objects
     */
    public void updateCashRegister(HashMap<Integer,Integer> moneyTally, HashMap<Integer, Integer> denominationsTally, ArrayList<Money> money){
        cashReg.updateMoneyTally(moneyTally);
        cashReg.updateDenominationsTally(denominationsTally);
        cashReg.updateMoney(money);
    }
    /**
     * This method checks if a slot is assigned to an item given a slot index
     * @param slotIndex the slot index of the slot to check
     * @return true if specified slot is assigned to an Item, false if not
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
     * This method returns the pre-existing item pool
     * @return ArrayList of items, known as itemPool
     */
    public ArrayList<Item> getItemPool(){
        return itemPool;
    }
    /**
     * This method checks if a number is positive and is not a decimal value
     * @param num the number to be checked
     * @return true if the number is both positive and is not a decimal value, false if not
     */
    public boolean isNumberValid(int num){
        return cashReg.isMoneyQtyValid(num) && num == Math.floor(num);
    }
}


