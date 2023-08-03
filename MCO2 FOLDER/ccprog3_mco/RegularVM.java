package ccprog3_mco;
/**
 * This class represents one Regular Vending Machine
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class RegularVM extends VendingMachine{
    /**
     * This constructor creates an instance of RegularVM
     * @param numSlots the number of slots in this RegularVM
     * @param slotCapacity the maximum capacity per slot in this RegularVM
     */
    public RegularVM(int numSlots, int slotCapacity){
        super(numSlots, slotCapacity);
    }
    
    /**
     * 
     *This method process the purchase of the user.
     * @param moneyInserted the integer array containing the quantities of each type of bill and coin the user has inserted
     * @param slotIndex the slot index of the users choice
     * @return a String containing the result of purchase attempt
     */
    public String processPurchase(int[] moneyInserted, int slotIndex){
        CashRegister cashReg = getCashRegister();
        Item item = getSlotItem(slotIndex);
        int insertedAmnt = cashReg.computeInsertedAmount(moneyInserted);
        cashReg.addMoney(moneyInserted);
        cashReg.computeChangeDenomination(insertedAmnt, (int)item.getPrice(), 8);
        updateCashRegister(cashReg.getMoneyTally(), cashReg.getDenoTally(), cashReg.getMoney());
        if (insertedAmnt == 0)
            return "Purchase Cancelled";
        
        else if (cashReg.computeTotalChange()>0 && insertedAmnt > 0)          
            return dispenseItem(slotIndex) + "\n" + cashReg.dispenseTotalChange() + "Total Change: PHP" + cashReg.computeTotalChange();
        
        else if (insertedAmnt == (int)item.getPrice())       
             return dispenseItem(slotIndex)  + "\n";
        
        else{
            int[] minMoney = moneyInserted;
            for (int i = 0; i < moneyInserted.length; i++)
                minMoney[i]*= (-1);
            cashReg.addMoney(minMoney);
            updateCashRegister(cashReg.getMoneyTally(), cashReg.getDenoTally(), cashReg.getMoney());
            return "Change not enough, dispensing inserted amount...\n" + cashReg.toStringAmount(moneyInserted);
        }
            

    }
}