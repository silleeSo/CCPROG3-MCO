public class RegularVM extends VendingMachine{
    public RegularVM(int numSlots, int slotCapacity){
        super(numSlots, slotCapacity);
    }
    
    /**
     * This method process the purchase of the user.
     * @param moneyInserted the integer array containing the quantities of each type of bill and coin the user has inserted
     * @param slotIndex the slot index of the users choice
     */
    //NOTE: THIS NOW RETURNS THE STRING INSTEAD OF PRINTING
    public String processPurchase(int[] moneyInserted, int slotIndex){
        CashRegister cashReg = getCashRegister();
        Item item = getSlotItem(slotIndex);
        int insertedAmnt = cashReg.computeInsertedAmount(moneyInserted);
        cashReg.computeChangeDenomination(insertedAmnt, (int)item.getPrice(), 8);
        updateCashRegister(cashReg.getMoneyTally(), cashReg.getDenoTally(), cashReg.getMoney());
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
}