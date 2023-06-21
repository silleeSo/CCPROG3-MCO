public class regularVM {
    //I NEED HELP IM KINDA CONFUSED
    int numberOfSlots;
    final int MAX_SLOTS = 8;
    Slot[] slots = new Slot[MAX_SLOTS];
    CashRegister cashReg;

    //TO DO: IMPLEMENT REGULARVM CONSTRUCTOR AND METHODS
    public regularVM(int numberOfSlots) {
        if(numberOfSlots >= 8)
            this.numberOfSlots = numberOfSlots;
        else
            this.numberOfSlots = 8;
    }
    
    // abe : sorry i have no idea what this is supposed to do
    public int getItemSlot() {
        return 1;
    }

    public Slot[] getSlots() {
        return slots;
    }

    public void displaySlots() {
        for(Slot slot : slots)
            System.out.println(slot.toString());
    }

    public void processPurchase() {

    }

    public void printTransactionSummary() {
        
    }

    public void displayInventory() {
        for(Slot slot : slots) {
            System.out.println(slot.getItemInfo());
        }
    }

    public void assignSlotToItem(int index, Item item, int quantity) {
        slots[index] = new Slot(index+1, item, quantity);
    }

    public void restockSlot(int index, int qty) {
        slots[index].restockSlot(qty);
    }

}
