import java.util.HashMap;

public class CashRegister {
    HashMap<Integer, Integer> money;
    //Money[] money = new Money[8];
     //TO DO: IMPLEMENT THE CONSTRUCTOR AND THE REST OF THE METHODS

    public CashRegister() {
        money = new HashMap<>();
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

    public HashMap<Integer, Integer> getChangeDenomination(){
        HashMap<Integer, Integer> d = new HashMap<>();
        
        return d;
    }

    public void money(int qty, int key){
        int totalQty = qty + money.get(key);
        money.put(key, totalQty);
    }
   
}
