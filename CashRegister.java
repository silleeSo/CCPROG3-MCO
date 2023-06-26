import java.util.HashMap;

public class CashRegister{
    private HashMap<Integer, Integer> money;
    private HashMap<Integer, Integer> denominations;

    public CashRegister(){
        money = new HashMap<>();
        denominations = new HashMap<>();
        money.put(1, 5);
        money.put(5, 5);
        money.put(10, 5);
        money.put(20, 5);
        money.put(50, 5);
        money.put(100, 5);
        money.put(200, 5);
        money.put(500, 5);
        money.put(1000, 5);

        denominations.put(1, 0);
        denominations.put(5, 0);
        denominations.put(10, 0);
        denominations.put(20, 0);
        denominations.put(50, 0);
        denominations.put(100, 0);
        denominations.put(200, 0);
        denominations.put(500, 0);
        denominations.put(1000, 0);
    }

    private int getDenominationForKey(int key, int totalAmount) {
        
        HashMap<Integer, Integer> tempHash = money;
        int billsInChange = 0;
        int tempNum = totalAmount;
        int billsInVM = tempHash.get(key);
       //loop while there are still bills in vm and amount to form is >= the certain bill
        while (billsInVM > 0 && tempNum >= key ){
            tempNum -= key;
            billsInVM--;
            billsInChange++;
            denominations.put(key, billsInChange);
            tempHash.put(key, billsInVM);
        }
        money = tempHash;   // set moeny hash to updated (or not) money hash 
        return tempNum;     // return
    }
    private int computeTotalChange(){
        int totalChange = 0;
        
        totalChange += denominations.get(1)*1;
        totalChange += denominations.get(5)*5;
        totalChange += denominations.get(10)*10;
        totalChange += denominations.get(20)*20;
        totalChange += denominations.get(50)*50;
        totalChange += denominations.get(100)*100;
        totalChange += denominations.get(200)*200;
        totalChange += denominations.get(500)*500;
        totalChange += denominations.get(1000)*1000;
        return totalChange;
    }
    //subtotal = the amount charged to the user, amountInserted, the amount user gives
    // this class updates the hashmap denominations
    private void computeDenominations(int subtotal, int amountInserted){
        int change = amountInserted - subtotal;
        //what if the user inserts less?? = call boolean is
        //get denominations, check money hash
        HashMap<Integer, Integer> originalMoney = money;
        change = getDenominationForKey(1000, change);
        change = getDenominationForKey(500, change);
        change = getDenominationForKey(200, change);
        change = getDenominationForKey(100, change);
        change = getDenominationForKey(50, change);
        change = getDenominationForKey(20, change);
        change = getDenominationForKey(10, change);
        change = getDenominationForKey(5, change);
        change = getDenominationForKey(1, change);
        if (!isChangeEnough(change)){
            resetDenominations();
            money = originalMoney;
        }
        //displayTotalChange();
    }
    private void resetDenominations(){
        denominations.put(1, 0);
        denominations.put(5, 0);
        denominations.put(10, 0);
        denominations.put(20, 0);
        denominations.put(50, 0);
        denominations.put(100, 0);
        denominations.put(200, 0);
        denominations.put(500, 0);
        denominations.put(1000, 0);
    
    }

    private boolean isChangeEnough(int amount){
        
        int totalChange = computeTotalChange();
        if (totalChange < amount)
            return false;
        return true;
    }
    private void displayBillDenomination(double key, int qty){
        if (qty > 0)
            //System.out.println(key + " * " + qty + " = " + key*qty);
            System.out.println("Dispensing " + qty + "*" + key + "pesos...");
    }
    private void displayTotalChange(){

        displayBillDenomination(1, denominations.get(1));
        displayBillDenomination(5, denominations.get(5));
        displayBillDenomination(10, denominations.get(10));
        displayBillDenomination(20, denominations.get(20));
        displayBillDenomination(50, denominations.get(50));
        displayBillDenomination(100, denominations.get(100));
        displayBillDenomination(200, denominations.get(200));
        displayBillDenomination(500, denominations.get(500));
        displayBillDenomination(1000, denominations.get(1000));
    }

    private boolean isAmountInsertedEnough(int subtotal, int amount){
        if (amount < subtotal)
            return false;
        return true;
    }

}