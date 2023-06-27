import java.util.ArrayList;
import java.util.Scanner;
/* 
Notes
- transactions, inventory
- create simulation for features testing (?)
- items pool, ask for num of coins/bills
//      UNFINISHED!!*/
public class Driver {
     
    private static ArrayList<RegularVM> regularVMs = new ArrayList<RegularVM>(); 
    private static Item itemPool[] = new Item[10];
    public static Scanner keypad = new Scanner(System.in);
    private static int regularVMCount;

    public static void main (String args[]){
        int input = 0;
        regularVMCount = 0;
        //Scanner keypad = new Scanner(System.in);
        while (input != 3){
            initializeItemPool();
            System.out.println("---Vending Machine Factory Simulator---");
            System.out.println("\t1 - Create Vending Machine");
            System.out.println("\t2 - Test a Vending Machine");
            System.out.println("\t3 - Exit");
            input = keypad.nextInt();
            System.out.println("\033c");    //CLEAR
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
    public static void createRegularVM() {
        /*
         * Upon creation
         * 1. ask for items and qty
                - display slots, allow selection
                - upon selectiing, display item pool
                - display slots (with item na )
            2. ask for input sa money qty
                - display list elements one by one (1,5,10,20...)
                - ask for input
         */
        RegularVM newRegVM = new RegularVM();
        int slotNum, prodNum, itemQty;
        int[] moneyQty = new int[9];
        //wala pang input validation
        for (int i = 0; i < 8; i++){
            //clear
            System.out.println("\033c");
            System.out.println("---Create Vending Machine---");
            //need to add validation so that hindi maselect ung same slot twice
            System.out.print("Enter slot number to customize (1-8): ");
            slotNum = keypad.nextInt();//accept input
            
            System.out.println("\033c");   //clear
            System.out.println("\t--Item Pool--");
            System.out.println("Number\tItem\t\tCalories\tPrice");

            for (int j = 0; j < 10; j++){
                System.out.print(j+"\t"+itemPool[j].getName()+"\t\t");
                System.out.print(itemPool[j].getCalories()+"\t\t");
                System.out.println(itemPool[j].getPrice()+"\t");
            }

            //need to add validation so that no duplicates sa machine
            System.out.print("Enter item for this slot (0-9): ");  
            prodNum = keypad.nextInt();//accept input
            System.out.print("Enter quantity for this item(1-10): "); 
            itemQty = keypad.nextInt();//accept input
            newRegVM.initializeSlot(slotNum-1, itemPool[prodNum], itemQty);
        }       
        //Ask for money
        System.out.println("Enter number of the ff. coins/bills:");
        System.out.print("1 Peso coins: ");
        moneyQty[0] = keypad.nextInt();
        System.out.print("5 Peso coins: ");
        moneyQty[1] = keypad.nextInt();
        System.out.print("10 Peso coins: ");
        moneyQty[2] = keypad.nextInt();
        System.out.print("20 Peso coins: ");
        moneyQty[3] = keypad.nextInt();
        System.out.print("50 Peso coins: ");
        moneyQty[4] = keypad.nextInt();
        System.out.print("100 Peso coins: ");
        moneyQty[5] = keypad.nextInt();
        System.out.print("200 Peso coins: ");
        moneyQty[6] = keypad.nextInt();
        System.out.print("500 Peso coins: ");
        moneyQty[7] = keypad.nextInt();
        System.out.print("1000 Peso coins: ");
        moneyQty[8] = keypad.nextInt();
        //send integer array moneyQty to vending machine
        newRegVM.refillMoney(moneyQty);

        //add the vending machine created to arraylist of vending machines
        regularVMs.add(newRegVM);
        regularVMCount++;

        System.out.println("\033c");   //clear
        
        //display
        newRegVM.displaySlots();
        newRegVM.displayMoneyQty();
        System.out.println("Enter any number to continue...");
        slotNum = keypad.nextInt();
       
    }
  
     //TO DO: IMPLEMENT testVM()
    public static void testVM(){

    }
   
    public static void initializeItemPool(){
        itemPool[0] = new Item("Tamago", 100, 53);
        itemPool[1] = new Item("Seaweed", 35, 45);
        itemPool[2] = new Item("Gyoza", 65, 57);
        itemPool[3] = new Item("Chasu", 120, 72);
        itemPool[4] = new Item("Ramen", 165, 436);
        itemPool[5] = new Item("Sushi", 125, 255);
        itemPool[6] = new Item("Mochi", 99, 100);
        itemPool[7] = new Item("Karage", 128, 230);
        itemPool[8] = new Item("Crab", 75, 95);
        itemPool[9] = new Item("Katsu", 135, 142);

    }
}