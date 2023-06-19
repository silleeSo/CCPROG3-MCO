import java.util.ArrayList;
import java.util.Scanner;

public class Driver{
     
    ArrayList<regularVM> regularVMs = new ArrayList<>(); 
    
    public static void main (String args[]){
        int input = 0;
        Scanner keypad = new Scanner(System.in);
        while (input != 3){
            System.out.println("---Vending Machine Factory Simulator---");
            System.out.println("\t1 - Create Vending Machine");
            System.out.println("\t2 - Test a Vending Machine");
            System.out.println("\t3 - Exit");
            input = keypad.nextInt();
            switch (input) {
                case 1:
                    createRegularVM();
                    break;
                case 2:
                    testVM();
                    break;
                default:
                    break;
            }
        }
        keypad.close();
    }
    //TO DO: IMPLEMENT createRegularVM()
    public static void createRegularVM(){
        
    }

     //TO DO: IMPLEMENT testVM()
    public static void testVM(){

    }
    
}