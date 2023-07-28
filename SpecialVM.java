
public class SpecialVM extends VendingMachine{
    
    public SpecialVM(int numSlots, int slotCapacity){
        super(numSlots, slotCapacity);
    }
   
    //the int array corresponds to the quantities purchased by user per slot
    //returns string u can print
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
        return orderStr;
    }

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
    public boolean isItemSoldSeparately(int slotIndex){
        Item item = getSlotItem(slotIndex);
        return item.getIsSoldAlone();
    }
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
