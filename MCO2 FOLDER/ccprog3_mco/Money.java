package ccprog3_mco;
/**
 * This class represents one piece of money
 * @author So, Chrysille
 * @author Chen, Abraham
 */
public class Money {
    /**
     * This attribute contains the financial value of this instance of Money
     */
    private final double VALUE;
    /**
     * This constructor creates an instance of Money and sets its value to a specified number
     * @param value new value of this Money
     */
    public Money(double value){
        this.VALUE = value;
    }
    /**
     * This method returns the value of this Money instance
     * @return the VALUE attribute of this instance
     */
    public double getValue(){
        return VALUE;
    }
}
