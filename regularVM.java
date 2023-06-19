
public class regularVM {
    int numberOfSlots;
    final int NUM_OF_SLOTS = 8;
    Slot[] slots = new Slot[NUM_OF_SLOTS];
    CashRegister cashReg;

     //TO DO: IMPLEMENT REGULARVM CONSTRUCTOR AND METHODS

    public regularVM()
    {
        
    }
    
    public int getItemSlot()
    {
        return 1;
    }

    public void displaySlots()
    {

    }

    public void processPurchase ()
    {

    }

    public void printTransactionSummary()
    {

    }

    public void displayInventory()
    {

    }

    public void assignSlotToItem(int index, Item item)
    {
        slots[index] = new Slot(index+1, item);
    }

    public void restockSlot(int index, int qty)
    {
        slots[index].restockSlot(qty);
    }

}
