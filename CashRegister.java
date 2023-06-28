import java.util.HashMap;

public class CashRegister{
    private HashMap<Integer, Integer> money;
    private HashMap<Integer, Integer> denominations;
    
    //constructor: instantiates hashmaps and initializes everything to zero
    public CashRegister(){
        money = new HashMap<>();
        denominations = new HashMap<>();

        clearCashRegister();
        resetDenominations();
    }

    //accepts an integer array containing quantity of coins/bills and adds it to current qty (calls addBill)
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

    //adds to the qty of a single type of coin or bill
    public void addBill(int key, int qty){
        int currentQty = money.get(key);
        money.put(key, currentQty + qty);
    }
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

    //deducts the qty of a single type of coin or bill
    public void deductBill(int key, int qty){
        int currentQty = money.get(key);
        money.put(key, currentQty - qty);
    }
    //returns an integer array containing the qty of each type of bill/coin
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
    
    /*public int[] getChangeQty(){
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
        
    }*/
    public boolean isMoneyQtyValid(int qty){
        if (qty < 0)
            return false;
        return true;
    }
    //gets the denomination using a given key (type of bill) and the total Amount to achieve
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
    //computes for the total change based on denomination hashmap, can be used for comparison and checking
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
    public int computeInsertedAmount(int[] inserted){
        int insertedAmnt = 0;
       
        for (int i = 0; i < 9; i++)
            insertedAmnt += inserted[i];
        return insertedAmnt;
        
    }
    
    //subtotal = the amount charged to the user, amountInserted, the amount user gives
    // this class updates the hashmap denominations
    public void computeFinalDenominations(int subtotal, int amountInserted){
        int change = amountInserted - subtotal;
        //what if the user inserts less?? = call boolean is
        //get denominations, check money hash
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
        //displayTotalChange();
    }

    //resets all denominations to zero; used after completing a purchase
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

    //clears the values of money hashmap (sets qty of all bills/coins to 0)
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

    //checks if change is enough, params subtotal(charged sa user) and amount (given by user)
    //assume that amount  > subtotal is confirmed
    public boolean isChangeEnough(int subtotal, int amountInserted){
        int change = amountInserted - subtotal;
        int totalChange = computeTotalChange();
        if (totalChange < change)
            return false;
        return true;
    }
    //checks if cash reg is empty
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
    //checks if amount inserted by user is enough to cover his subtotal
    public boolean isAmountInsertedEnough(int subtotal, int amount){
        if (amount < subtotal)
            return false;
        return true;
    }
    //displays the denomination for 1 type of bill/coin; used in displayTotalChange
    public void displayBillDenomination(double key, int qty){
        if (qty > 0)
            //System.out.println(key + " * " + qty + " = " + key*qty);
            System.out.println("Dispensing " + qty + "*" + key + "pesos...");
    }

    //displays the total change
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
        
           

        //decrement
        //add total to money, subtract denominations from
        
    }
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