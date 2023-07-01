public class Inventory {
    private Item item;
    private int qtyStartInv;
    private int qtyEndInv;
    private int qtyAdded;
    private int qtySold;

    public Inventory(Item item) {
        this.item = item;
        this.qtyAdded = 0;
        this.qtyStartInv = 0;
        this.qtyEndInv = 0;
        this.qtySold = 0;
    }

    public void registerRestock(int qty) {
        if (qty!=0){
            qtyStartInv = qtyEndInv;
            qtyEndInv += qty;
            qtyAdded = qty;
            qtySold = 0;
        }
        
    }

    public void decrementQtyEnd() {
        this.qtyEndInv--;
    }

    public void incrementQtySold() {
        this.qtySold++;
    }

    @Override
    public String toString() {
        String itemName = "Item name: " + item.getName() + "\n";
        String qtyAdded = "Restock amount: " + this.qtyAdded + "\n";
        String qtyStart = "Amount before restocking: " + qtyStartInv + "\n";
        String qtyEnd = "Amount after restocking: " + (qtyEndInv+qtySold) + "\n";
        String qtyCurr = "Current stock: " + qtyEndInv + "\n";

        return itemName + qtyAdded + qtyStart + qtyEnd + qtyCurr;
    }

    public String getQtySold() {
        double profit = qtySold * item.getPrice();

        String itemName = "Item name: " + item.getName() + "\n";
        String itemPrice = "Price: " + item.getPrice() + "\n";
        String qtySold = "Total quantity sold: " + this.qtySold + "\n";
        String amountCollected = "Amount collected since last restock: " + profit + "\n";

        return itemName + itemPrice + qtySold + amountCollected;
    }
}
