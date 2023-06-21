import java.util.HashMap;

public class CashRegister {
    HashMap<Integer, Integer> bills = new HashMap<>();
    HashMap<Integer, Integer> coins = new HashMap<>();
    HashMap<Integer, Integer> centavoes = new HashMap<>();
    //Money[] money = new Money[8];
     //TO DO: IMPLEMENT THE CONSTRUCTOR AND THE REST OF THE METHODS

    public CashRegister() {
        /*IM NOT SURE IF KASAMA CENTAVOES RAGHH
        centavoes.put(5, 0);
        centavoes.put(25, 0);
        centavoes.put(50, 0);*/

        coins.put(1, 0);
        coins.put(5, 0);
        coins.put(10, 0);

        bills.put(20, 0);
        bills.put(50, 0);
        bills.put(100, 0);
        bills.put(200, 0);
        bills.put(500, 0);
        bills.put(1000, 0);
    }

    public HashMap<Integer, Integer> getChangeDenomination(){
        HashMap<Integer, Integer> d = new HashMap<>();
        //I NEED HALP 
        //abe: IDK WHAT TO DO EITHER
        return d;
    }

    public void addBillQty(int qty, int key){
        int totalQty = qty + bills.get(key);
        bills.put(key, totalQty);
    }

    public void addCoinQty(int qty, int key){
        int totalQty = qty + coins.get(key);
        coins.put(key, totalQty);
    }

    public void addCentavoeQty(int qty, int key){
        int totalQty = qty + centavoes.get(key);
        centavoes.put(key, totalQty);
    }
   
}
