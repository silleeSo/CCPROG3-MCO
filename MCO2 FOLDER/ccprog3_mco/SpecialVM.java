package ccprog3_mco;
/**
 * This class represents one Special Vending Machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class SpecialVM extends VendingMachine{
    /**
     * This constructor creates an instance of SpecialVM
     * @param numSlots the number of slots in this SpecialVM
     * @param slotCapacity the maximum capacity per slot in this SpecialVM
     */
    public SpecialVM(int numSlots, int slotCapacity){
        super(numSlots, slotCapacity);
    }
   
    /**
     * This method simulates the order preparations for a customized item
     * @param slotsQty the list of purchased quantities corresponding to each slot
     * @return String detailing order preparation process
     */
    public String prepareOrder(int[] slotsQty){
        String orderStr = "";
        for (int i = 0; i < slotsQty.length; i++){
            if (slotsQty[i] > 0){
                Item item = getSlotItem(i);
                orderStr += item.getPreparation() + " " + slotsQty[i] + " orders of " + item.getName() + "...\n";
                for (int j = 0; j < slotsQty[i]; j++){
                    String s = dispenseItem(i);
                }
            }
        }
        orderStr += "Plating your order...\n";
        orderStr += "Dispensing your customized item...\n";
        orderStr += "Total Calories: " + computeOrderCalories(slotsQty) + "\n";

        return orderStr;
    }
    /**
     * This method computes for the total calories in a customized order
     * @param slotsQty the list of purchased quantities corresponding to each slot
     * @return the total calories of the order
     */
    public double computeOrderCalories(int[] slotsQty){
        double totalCal = 0;
        for (int i = 0; i < slotsQty.length; i++){    
            if (slotsQty[i] > 0){   
                Item item = getSlotItem(i);
                totalCal += item.getCalories();
            }
        }
        return totalCal;
    }
    /**
     * This method computes the total price of an order
     * @param slotsQty the list of purchased quantities corresponding to each slot
     * @return the total price of purchase
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
     * This method returns the stand-alone vendability of an item in a slot 
     * @param slotIndex the slot index of the item to check
     * @return true if item in specified slot is sold alone, false if not
     */
    public boolean isItemSoldSeparately(int slotIndex){
        Item item = getSlotItem(slotIndex);
        return item.getIsSoldAlone();
    }
    /**
     * This method process the purchase of the user.
     * @param moneyInserted the integer array containing the quantities of each type of bill and coin the user has inserted
     * @param slotsQty the list of purchased quantities corresponding to each slot
     * @return a String containing the result of purchase attempt
     */
    public String processPurchase(int[] moneyInserted, int slotsQty[]){
        CashRegister cashReg = getCashRegister();
        double subtotal = computeOrderTotal(slotsQty);
        int insertedAmnt = cashReg.computeInsertedAmount(moneyInserted);
        cashReg.addMoney(moneyInserted);
        cashReg.computeChangeDenomination(insertedAmnt, (int)subtotal, 8);
        updateCashRegister(cashReg.getMoneyTally(), cashReg.getDenoTally(), cashReg.getMoney());
        if (insertedAmnt == 0)
            return "Purchase Cancelled";

        else if (cashReg.computeTotalChange()>0 && insertedAmnt > 0)
            return prepareOrder(slotsQty) + "\n" + cashReg.dispenseTotalChange() + "Total Change: PHP" + cashReg.computeTotalChange();
        
        else if (insertedAmnt == (int)subtotal)
            return prepareOrder(slotsQty)  + "\n";
        
        else{
            int[] minMoney = moneyInserted;
            for (int i = 0; i < moneyInserted.length; i++)
                minMoney[i]*= (-1);
            cashReg.addMoney(minMoney);
            updateCashRegister(cashReg.getMoneyTally(), cashReg.getDenoTally(), cashReg.getMoney());
            return "Change not enough, dispensing inserted amount...\n" + cashReg.toStringAmount(moneyInserted);
        }
            
    }
    /**
     * This method validates a prucahse attempt by checking if the quantity stored in slot is enough and if non-vendable items are bought along with stand-alone vendable ones
     * @param slotPurchaseQtys the list of purchased quantities corresponding to each slot
     * @return true if purchase attempte is valid, false if not
     */
    public boolean isPurchaseValid(int[] slotPurchaseQtys){
        boolean valid = false;
        boolean enoughStock = true;
        Slot[] slots = getSlots();
        for (int i = 0; i < slotPurchaseQtys.length; i++){
            if(slotPurchaseQtys[i] > 0){
                if (isItemSoldSeparately(i))   //checks if there is at least 1 item that is sold separately
                    valid = true;
                if (slots[i].getQuantityStored() - slotPurchaseQtys[i] < 0) //checks if there is enough stock
                    enoughStock = false;
            }
        }
         return enoughStock && valid;
    }
}
