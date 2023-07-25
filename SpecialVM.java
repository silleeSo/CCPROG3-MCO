public class SpecialVM extends VendingMachine{
    private Item customizableItem;
    public SpecialVM(int numSlots){
        super(numSlots);
    }
    public void setCustomizableItem(String itemName, double price, double calories){
        customizableItem = new Item(itemName, price, calories, true);
    }
    //@Override
    public String processPurchase(int[] moneyInserted, int slotsQty[]){
        return null;
    }
    public String dispenseCustomizableItem(){
        getCashRegister();
    }
}
