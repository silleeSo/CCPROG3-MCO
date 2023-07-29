/**
 * This class represents one piece or object of Money
 */
public class Money {
    private final double VALUE;
    /**
     * This method creates an instance of Money object
     * @param value the value or financial worth of this instance of Money
     */
    public Money(double value){
        this.VALUE = value;
    }
    /**
     * This method returns the value of this instance of Money
     * @return the value of this instance
     */
    public double getValue(){
        return VALUE;
    }
}
