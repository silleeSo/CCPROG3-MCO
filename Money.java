public class Money {
    
    int quantity;
    final double VALUE;
    public Money(int quantity, double value){
        this.quantity = quantity;
        this.VALUE = value;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getValue(){
        return VALUE;
    }


}
