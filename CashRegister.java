import java.util.HashMap;
import java.util.ArrayList;
/**
 * This class represents the cash register inside a regular vending machine.
 * @author So, Chrysille
 * @author Chen, Abraham
 */
//TO DO: edit javadoc
public class CashRegister{
    private HashMap<Integer, Integer> moneyTally;
    private HashMap<Integer, Integer> denominationsTally;
    private ArrayList<Money> money;
    
    /**
     * This method creates an instance of CashRegister. It instantiates hashmaps attributes money and denominations then initializes all their values to zero
     */
    public CashRegister(){
        moneyTally = new HashMap<>();
        denominationsTally = new HashMap<>();

        clearCashRegister();
        resetDenominations();
    }
    public void computeChangeDenomination(int amntInserted, int subtotal, int n){
        int[] keys = {1,5,10,20,50,100,200,500,1000};
        int change = amntInserted - subtotal;
        HashMap<Integer, Integer> originalMoney = moneyTally;
        getDenominationStartingFrom(keys[n], change);   
        if (!isChangeEnough(subtotal,amntInserted) && n > 0){
            moneyTally = originalMoney;
            computeChangeDenomination(amntInserted, subtotal, n-1) ; 
        }
        else if (!isChangeEnough(subtotal,amntInserted) && n == 0){
            moneyTally = originalMoney;
            resetDenominations();
        }
    }
    /**
     * This method gets the denomination for a specified amount starting from a given key
     * @param key the given key to start from
     * @param number the number to achieve in denominations
     */
     public void getDenominationStartingFrom(int key, int number){
         resetDenominations();
        int amntLeft = number;
        switch(key){
            case 1000:  amntLeft = getDenominationForKey(1000, amntLeft);
            case 500:   amntLeft = getDenominationForKey(500, amntLeft);
            case 200:   amntLeft = getDenominationForKey(200, amntLeft);
            case 100:   amntLeft = getDenominationForKey(100, amntLeft);
            case 50:    amntLeft = getDenominationForKey(50, amntLeft);
            case 20:    amntLeft = getDenominationForKey(20, amntLeft);
            case 10:    amntLeft = getDenominationForKey(10, amntLeft);
            case 5:     amntLeft = getDenominationForKey(5, amntLeft);
            case 1:     amntLeft = getDenominationForKey(1, amntLeft);
                        break;
        }
    }
    /**
     * This method gets the denomination using a given key (type of bill) for money HashMap and the total amount to achieve in denominations
     * @param key the key to use for money HashMap
     * @param totalAmount the total amount to achieve in denominations
     * @return the remaining amount left the achieve in denominations after deducting the key from original amount as much as possible
     */
    public int getDenominationForKey(int key, int totalAmount) {  
        HashMap<Integer, Integer> tempHash = moneyTally;
        int billsInChange = 0;
        int tempNum = totalAmount;
        int billsInVM = tempHash.get(key);
       //loop while there are still bills in vm and amount to form is >= the certain bill
        while (billsInVM > 0 && tempNum >= key ){
            tempNum -= key;
            billsInVM--;
            billsInChange++;
            denominationsTally.put(key, billsInChange);
            tempHash.put(key, billsInVM);
        }
        moneyTally = tempHash;   // set moeny hash to updated (or not) money hash 
        return tempNum;     // return
    }
    /**
     * This method computes for the total change based on denomination HashMap. 
     * @return the total change based on the  quantities stored in denomination HashMap
     */
    public int computeTotalChange(){
        int totalChange = 0;
        totalChange += denominationsTally.get(1)*1;
        totalChange += denominationsTally.get(5)*5;
        totalChange += denominationsTally.get(10)*10;
        totalChange += denominationsTally.get(20)*20;
        totalChange += denominationsTally.get(50)*50;
        totalChange += denominationsTally.get(100)*100;
        totalChange += denominationsTally.get(200)*200;
        totalChange += denominationsTally.get(500)*500;
        totalChange += denominationsTally.get(1000)*1000;
        return totalChange;
    }
    /**
     * This method computes the total inserted amount by the user given an integer array containing the quantities of each bill and coin.
     * @param inserted the integer array containing the quantities for each bill and coin inserted by user
     * @return the total inserted amount
     */
    public int computeInsertedAmount(int[] inserted){    
        int insertedAmnt = 0;
        insertedAmnt += 1*inserted[0];
        insertedAmnt += 5*inserted[1];
        insertedAmnt += 10*inserted[2];
        insertedAmnt += 20*inserted[3];
        insertedAmnt += 50*inserted[4];
        insertedAmnt += 100*inserted[5];
        insertedAmnt += 200*inserted[6];
        insertedAmnt += 500*inserted[7];
        insertedAmnt += 1000*inserted[8];
        return insertedAmnt;
    }

    /**
     * This method resets all denominations to zero, and used after completing a purchase.
     */
    public void resetDenominations(){
        denominationsTally.put(1, 0);
        denominationsTally.put(5, 0);
        denominationsTally.put(10, 0);
        denominationsTally.put(20, 0);
        denominationsTally.put(50, 0);
        denominationsTally.put(100, 0);
        denominationsTally.put(200, 0);
        denominationsTally.put(500, 0);
        denominationsTally.put(1000, 0);
    }

    /**
     * This method clears the values of money hashmap by setting the quantity of all bills and coins to 0
     */
    public void clearCashRegister(){
        moneyTally.put(1, 0);
        moneyTally.put(5, 0);
        moneyTally.put(10, 0);
        moneyTally.put(20, 0);
        moneyTally.put(50, 0);
        moneyTally.put(100, 0);
        moneyTally.put(200, 0);
        moneyTally.put(500, 0);
        moneyTally.put(1000, 0);
        //NEW
        money.clear();
    
    }
    /**
     * This method accepts an integer array containing quantity of all coins and bills and adds it to current qty stored in money HashMap
     * @param moneyQty the integer array containing the quantities all types of bills and coins
     */
    public void addMoney(int[] moneyQty){ 
        addBill(1, moneyQty[0]);
        addBill(5, moneyQty[1]);
        addBill(10, moneyQty[2]);
        addBill(20, moneyQty[3]);
        addBill(50, moneyQty[4]);
        addBill(100, moneyQty[5]);
        addBill(200, moneyQty[6]);
        addBill(500, moneyQty[7]);
        addBill(1000, moneyQty[8]);
        
    }
  

    /**
     * This method adds to the quantity of a single type of coin or bill
     * @param key the key to use as reference in money HashMap and value to use in money instantiation
     * @param qty the quantity to add to the value at specified key in money HashMap and number of money objects to instantiate
     */
    public void addBill(int key, int qty){
        int currentQty = moneyTally.get(key);
        moneyTally.put(key, currentQty + qty);
        for (int i = 0; i < qty; i ++){
            money.add(new Money((double)key));
        }
    }
    /**
     * This method deducts the corresponding values in denominations HashMap from the values stored in money HashMap
     */
    public void deductChangeFromMoneyTally(){       
        deductBill(1, denominationsTally.get(1));
        deductBill(5, denominationsTally.get(5));
        deductBill(10, denominationsTally.get(10));
        deductBill(20, denominationsTally.get(20));
        deductBill(50, denominationsTally.get(50));
        deductBill(100, denominationsTally.get(100));
        deductBill(200, denominationsTally.get(200));
        deductBill(500, denominationsTally.get(500));
        deductBill(1000, denominationsTally.get(1000));
       
    }

    /**
     * This method deducts the qty of a single type of coin or bill given the money HashMap key and a quantity
     * @param key the given key to use as reference in money HashMap
     * @param qty the quantity to add the value stored in the given key in money HashMap
     */
    public void deductBill(int key, int qty){
        int currentQty = moneyTally.get(key);
        moneyTally.put(key, currentQty - qty);
        //NEW 
        //delete instances of Money in ArrayList money based on qty and key, must have search
         //Add the function call for destroying objects of Money, same with compute final deno, samay update money hash
         int i = 0;
         for (Money bill : money){
            if (bill.getValue() == (double)key)
                bill = null;
            else if (i == qty)
                break;
         }
            
    }
    /**
     * This method returns an integer array containing the quantity of each type of bill and coin stored in money HashMap
     * @return the integer array containing quantities
     */
    public int[] getMoneyQty(){
        int[] qty = new int[9];

        qty[0] += moneyTally.get(1);
        qty[1] += moneyTally.get(5);
        qty[2] += moneyTally.get(10);
        qty[3] += moneyTally.get(20);
        qty[4] += moneyTally.get(50);
        qty[5] += moneyTally.get(100);
        qty[6] += moneyTally.get(200);
        qty[7] += moneyTally.get(500);
        qty[8] += moneyTally.get(1000);

        return qty;     
    }
    /**
     * This method checks if a given money quantity is valid. Valid values are positive values.
     * @param qty the given quantity to check
     * @return true if the quantity is valid, false if it is not
     */
    public boolean isMoneyQtyValid(int qty){
        if (qty < 0)
            return false;
        return true;
    }

    /**
     * This method checks if the change in the vending machine is enough given the subtotal and amount inserted by the suer.
     * @param subtotal the total price the user has to pay
     * @param amountInserted the total amount the user inserted
     * @return true if change in vending machine is enough, false if it is not
     */
    public boolean isChangeEnough(int subtotal, int amountInserted){
        int change = amountInserted - subtotal;
        int totalChange = computeTotalChange();
        if (totalChange < change)
            return false;
        return true;
    }
    /**
     * This method checks if the money HashMap is empty.
     * @return true if all values in money HashMap are zero, false if not.
     */
    public boolean isCashRegEmpty(){
        int total = 0;
        total += moneyTally.get(1);
        total += moneyTally.get(5);
        total += moneyTally.get(10);
        total += moneyTally.get(20);
        total += moneyTally.get(50);
        total += moneyTally.get(100);
        total += moneyTally.get(200);
        total += moneyTally.get(500);
        total += moneyTally.get(1000);
        if (total == 0)
            return true;
        return false;
    }
    /**
     * This ethod checks if the amount inserted by user is enough to pay for his subtotal give the total amount inserted and the subtotal
     * @param subtotal the user's subtotal
     * @param amount the total amount user inserted
     * @return false if amount is less than subtotal, true otherwise
     */
    public boolean isAmountInsertedEnough(int subtotal, int amount){
        if (amount < subtotal)
            return false;
        return true;
    }
    /**
     * This method displays the denomination for one type of bill or coin. This method is used in displayTotalChange() as well.
     * @param key the type of bill or coin
     * @param qty the quantity of bill or coin
     */
    //NEW
    public String toStringBillDenomination(double key, int qty){
        if (qty > 0)
            return "Dispensing " + qty + " * " + key + " pesos...\n";
        return null;
    }

    /**
     * This method displays the total change after a purchase.
     */
    public String dispenseTotalChange(){
        String finalStr;
        finalStr = toStringBillDenomination(1, denominationsTally.get(1));
        finalStr += toStringBillDenomination(5, denominationsTally.get(5));
        finalStr += toStringBillDenomination(10, denominationsTally.get(10));
        finalStr += toStringBillDenomination(20, denominationsTally.get(20));
        finalStr += toStringBillDenomination(50, denominationsTally.get(50));
        finalStr += toStringBillDenomination(100, denominationsTally.get(100));
        finalStr += toStringBillDenomination(200, denominationsTally.get(200));
        finalStr += toStringBillDenomination(500, denominationsTally.get(500));
        finalStr += toStringBillDenomination(1000, denominationsTally.get(1000));
        return finalStr;
    }
    /**
     * This method displays the quantity of all bill and coin types given an integer array containing the corresponding quantities
     * @param amount he integer array containing the quantities for each bill and coin
     */
    public String toStringAmount(int[] amount){
        String finalStr;
        finalStr = toStringBillDenomination(1, amount[0]);
        finalStr += toStringBillDenomination(5, amount[1]);
        finalStr += toStringBillDenomination(10, amount[2]);
        finalStr += toStringBillDenomination(20, amount[3]);
        finalStr += toStringBillDenomination(50, amount[4]);
        finalStr += toStringBillDenomination(100, amount[5]);
        finalStr += toStringBillDenomination(200, amount[6]);
        finalStr += toStringBillDenomination(500, amount[7]);
        finalStr += toStringBillDenomination(1000, amount[8]);
        return finalStr;
    }
    
    
}