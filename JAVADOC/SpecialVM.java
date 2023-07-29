/**
 * This class extends the abstract class Vending Machine and represents one special vending machine
 */
public class SpecialVM extends VendingMachine{
    /**
     * This constructor creates an instance of SpecialVM
     * @param numSlots the number of slots in the special vending machine
     * @param slotCapacity the capacity of each slot in the special vending machine
     */
    public SpecialVM(int numSlots, int slotCapacity){
        super(numSlots, slotCapacity);
    }
   
    //the int array corresponds to the quantities purchased by user per slot
    //returns string u can print
    /**
     * This method prepares the customized product for the user
     * @param slotsQty the purchased quantity of each slot item
     * @return the String containing preparations for the customizable product
     */
    public String prepareOrder(int[] slotsQty){
        String orderStr = "";
        for (int i = 0; i < slotsQty.length; i++){    
            if (slotsQty[i] > 0){   
                Item item = getSlotItem(i);
                orderStr += item.getPreparation() + " " + slotsQty[i] +" orders of"+ item.getName() + "...\n";
                for (int j = 0; j < slotsQty[i]; j++){
                    String s = dispenseItem(i);
                }
            }
        }
        orderStr += "Plating your order...\n";
        orderStr += "Order calories: " + computeTotalCalories(slotsQty);
        return orderStr;
    }
    /**
     * This method computes for the total calories of the order
     * @param slotsQty the purchased quantity of each slot item
     * @return the total calorie count
     */
    public double computeTotalCalories(int[] slotsQty){
        double total = 0;
        for (int i = 0; i < slotsQty.length; i++){    
            if (slotsQty[i] > 0){   
                Item item = getSlotItem(i);
                total += item.getCalories() * slotsQty[i];;
            }
        }
        return total;
    }
    /**
     * This method computes the total price of the order
     * @param slotsQty integer array containing purchased quantities corresponding to each slot
     * @return the total price of the order
     */
    public double computeOrderTotal(int[] slotsQty){
        double orderTotal = 0;
        for (int i = 0; i < slotsQty.length; i++){    
            if (slotsQty[i] > 0){   
                Item item = getSlotItem(i);
                orderTotal += item.getPrice() * slotsQty[i];
            }
        }
        return orderTotal;
    }
    /**
     * This method returns a boolean value based on whether or not an item in a specified slot is sold separately
     * @param slotIndex the slot index of the item to check
     * @return true if the item in the given slot index is sold separately, false if not
     */
    public boolean isItemSoldSeparately(int slotIndex){
        Item item = getSlotItem(slotIndex);
        return item.getIsSoldAlone();
    }
    /**
     * This method processes user purchase in a special vending machine
     * @param moneyInserted integer array containing inserted money quantities corresponding to each money type
     * @param slotsQty integer array containing purchased Item quantities corresponding to each slot
     * @return String containing result of purchase attempt
     */
    public String processPurchase(int[] moneyInserted, int slotsQty[]){
        CashRegister cashReg = getCashRegister();
        double subtotal = computeOrderTotal(slotsQty);
        int insertedAmnt = cashReg.computeInsertedAmount(moneyInserted);
        cashReg.computeChangeDenomination(insertedAmnt, (int)subtotal, 8);
        updateCashRegister(cashReg.getMoneyTally(), cashReg.getDenoTally(), cashReg.getMoney());
        if (insertedAmnt == 0)
            return "Purchase Cancelled";
        
        else if (cashReg.computeTotalChange()>0 && insertedAmnt > 0)
        {
            cashReg.addMoney(moneyInserted);   
            return prepareOrder(slotsQty) + "\n" + cashReg.dispenseTotalChange() + "Total Change: PHP" + cashReg.computeTotalChange();
        }
        else if (insertedAmnt == (int)subtotal)
            return prepareOrder(slotsQty)  + "\n";
        else
            return "Change not enough, dispensing inserted amount...\n" + cashReg.toStringAmount(moneyInserted);
    }
}
