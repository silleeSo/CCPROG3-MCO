import java.util.HashMap;
/**
 * This class represents the cash register inside a regular vending machine.
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class CashRegister{
    private HashMap<Integer, Integer> money;
    private HashMap<Integer, Integer> denominations;
    
    /**
     * This method creates an instance of CashRegister. It instantiates hashmaps attributes money and denominations then initializes all their values to zero
     */
    public CashRegister(){
        money = new HashMap<>();
        denominations = new HashMap<>();

        clearCashRegister();
        resetDenominations();
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
     * @param key the key to use as reference in money HashMap
     * @param qty the quantity to add to the value at specified key in money HashMap
     */
    public void addBill(int key, int qty){
        int currentQty = money.get(key);
        money.put(key, currentQty + qty);
    }
    /**
     * This method deducts the corresponding values in denominations HashMap from the values stored in money HashMap
     */
    public void deductChangeFromMoney(){       
        deductBill(1, denominations.get(1));
        deductBill(5, denominations.get(5));
        deductBill(10, denominations.get(10));
        deductBill(20, denominations.get(20));
        deductBill(50, denominations.get(50));
        deductBill(100, denominations.get(100));
        deductBill(200, denominations.get(200));
        deductBill(500, denominations.get(500));
        deductBill(1000, denominations.get(1000));
    }

    /**
     * This method deducts the qty of a single type of coin or bill given the money HashMap key and a quantity
     * @param key the given key to use as reference in money HashMap
     * @param qty the quantity to add the value stored in the given key in money HashMap
     */
    public void deductBill(int key, int qty){
        int currentQty = money.get(key);
        money.put(key, currentQty - qty);
    }
    /**
     * This method returns an integer array containing the quantity of each type of bill and coin stored in money HashMap
     * @return the integer array containing quantities
     */
    public int[] getMoneyQty(){
        int[] qty = new int[9];

        qty[0] += money.get(1);
        qty[1] += money.get(5);
        qty[2] += money.get(10);
        qty[3] += money.get(20);
        qty[4] += money.get(50);
        qty[5] += money.get(100);
        qty[6] += money.get(200);
        qty[7] += money.get(500);
        qty[8] += money.get(1000);

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
     * This method gets the denomination using a given key (type of bill) for money HashMap and the total amount to achieve in denominations
     * @param key the key to use for money HashMap
     * @param totalAmount the total amount to achieve in denominations
     * @return the remaining amount left the achieve in denominations after deducting the key from original amount as much as possible
     */
    public int getDenominationForKey(int key, int totalAmount) {
        
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
     * This method computes for the total change based on denomination HashMap. 
     * @return the total change based on the  quantities stored in denomination HashMap
     */
    public int computeTotalChange(){
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
     * This method computes the final denominations for change given the user's subtotal and total inserted amount. This method updates the denominations HashMap in the process.
     * @param subtotal the user's subtotal or price of the item he purchased
     * @param amountInserted the total amount inserted by the user
     */
    public void computeFinalDenominations(int subtotal, int amountInserted){
        int change = amountInserted - subtotal;
        HashMap<Integer, Integer> originalMoney = money;
        getDenominationStartingFrom(1000, change);   
        if (!isChangeEnough(subtotal,amountInserted))
            getDenominationStartingFrom(500, change);
        if (!isChangeEnough(subtotal,amountInserted))
            getDenominationStartingFrom(200, change);
        if (!isChangeEnough(subtotal,amountInserted))
            getDenominationStartingFrom(100, change);    
        if (!isChangeEnough(subtotal,amountInserted))  
            getDenominationStartingFrom(50, change);  
        if (!isChangeEnough(subtotal,amountInserted))
            getDenominationStartingFrom(20, change); 
         if (!isChangeEnough(subtotal,amountInserted))
            getDenominationStartingFrom(10, change);    
         if (!isChangeEnough(subtotal,amountInserted))
           getDenominationStartingFrom(5, change);   
         if (!isChangeEnough(subtotal,amountInserted))
            getDenominationStartingFrom(1, change);
        if (!isChangeEnough(subtotal, amountInserted)){
            resetDenominations();
            money = originalMoney;
        }
    }

    /**
     * This method resets all denominations to zero, and used after completing a purchase.
     */
    public void resetDenominations(){
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

    /**
     * This method clears the values of money hashmap by setting the quantity of all bills and coins to 0
     */
    public void clearCashRegister(){
        money.put(1, 0);
        money.put(5, 0);
        money.put(10, 0);
        money.put(20, 0);
        money.put(50, 0);
        money.put(100, 0);
        money.put(200, 0);
        money.put(500, 0);
        money.put(1000, 0);
    
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
        total += money.get(1);
        total += money.get(5);
        total += money.get(10);
        total += money.get(20);
        total += money.get(50);
        total += money.get(100);
        total += money.get(200);
        total += money.get(500);
        total += money.get(1000);
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
    public void displayBillDenomination(double key, int qty){
        if (qty > 0)
            //System.out.println(key + " * " + qty + " = " + key*qty);
            System.out.println("Dispensing " + qty + "*" + key + "pesos...");
    }

    /**
     * This method displays the total change after a purchase.
     */
    public void dispenseTotalChange(){
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
    /**
     * This method displays the quantity of all bill and coin types given an integer array containing the corresponding quantities
     * @param amount he integer array containing the quantities for each bill and coin
     */
    public void displayAmount(int[] amount){
        displayBillDenomination(1, amount[0]);
        displayBillDenomination(5, amount[1]);
        displayBillDenomination(10, amount[2]);
        displayBillDenomination(20, amount[3]);
        displayBillDenomination(50, amount[4]);
        displayBillDenomination(100, amount[5]);
        displayBillDenomination(200, amount[6]);
        displayBillDenomination(500, amount[7]);
        displayBillDenomination(1000, amount[8]);
        
    }
}