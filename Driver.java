import java.util.ArrayList;
import java.util.Scanner;
/* 
Notes
- transactions, inventory
- create simulation for features testing (?)
- items pool, ask for num of coins/bills
//      UNFINISHED!!*/
public class Driver {
     
    private ArrayList<RegularVM> regularVMs; 
    private RegularVM regularVM;
    private Item[] itemPool;
    public static Scanner keypad = new Scanner(System.in);
    private int regularVMCount;

    public Driver(){
        regularVMs = new ArrayList<RegularVM>(); 
        itemPool = new Item[10];
        regularVMCount = 0;
        
    }
    public static void main (String args[]){

        int input = 0;
        Driver factory = new Driver();

        //Scanner keypad = new Scanner(System.in);
        while (input != 3){
            factory.initializeItemPool();
            System.out.println("---Vending Machine Factory Simulator---");
            System.out.println("\t1 - Create Vending Machine");
            System.out.println("\t2 - Test a Vending Machine");
            System.out.println("\t3 - Exit");
            input = keypad.nextInt();
            System.out.println("\033c");    //CLEAR
            switch (input) {
                case 1:
                    factory.createRegularVM();
                    break;
                case 2:
                    factory.testVM();
                    break;
                default:
                    break;
            }
        }
        keypad.close();
    }

    //TO DO: IMPLEMENT createRegularVM()
    public void createRegularVM() {
        regularVM = null;
        regularVM = new RegularVM();
        int slotNum, prodNum, itemQty, input = 1; 
        int[] moneyQty = new int[9];    
       
        for (int i = 0; i < 8 && input == 1; i++){    //repeat 8 times, 8 slots
            System.out.println("\033c"); //clear
            System.out.println("---Create Vending Machine---"); // print header
            slotNum = askForEmptySlot(regularVM); // get slot number
            System.out.println("\033c");   //clear
            printItemPool();
            prodNum = askForProductInd(regularVM); // get product index        
            System.out.print("Enter quantity for this item (1-10): "); 
            itemQty = keypad.nextInt();//accept input       
            regularVM.initializeSlot(slotNum-1, itemPool[prodNum], itemQty); // create a slot given the specifications
            System.out.println("Continue?"); 
            input = askYesOrNo();
        }       
        if (input == 1 ){
            moneyQty = askForMoneyQty(regularVM.getCashRegister());     //Ask for money
            regularVM.refillMoney(moneyQty); //send integer array moneyQty to vending machine

            //display
            System.out.println("\033c");   //clear
            regularVM.displaySlots();
            regularVM.displayMoneyQty();
            System.out.println("Enter any number to continue...");
            slotNum = keypad.nextInt();   
        }
    }
  
     //TO DO: IMPLEMENT testVM()
    public void testVM(){
        int input = 0, VMInd = 0;
        
        regularVM.displaySlots();
        regularVM.displayMoneyQty();
        System.out.println("Test this vending machine?");
        input = askYesOrNo();
         while (input == 1 || input == 2) {
            System.out.println("---Test Vending Machine---");
            System.out.println("1 - Features Test");
            System.out.println("2 - Maintenance Test");
            System.out.println("3 - Exit");
            input = keypad.nextInt();
            switch(input){
                case 1:
                        featuresTest(VMInd);
                        break;
                case 2:
                        break;
                case 3: break;
            }
        }

    }
    public void featuresTest(int index ){
        int input = 0;
        while(input!=-1){
            int[] moneyQty = new int[9];
            CashRegister cashReg = regularVM.getCashRegister();
            regularVM.displaySlots();
            do{
                System.out.println("Enter slot number to purchase from (1-8), enter -1 to cancel: ");
                input = keypad.nextInt();  //ask for slot num 1-8    
            }while (!regularVM.isSlotNumValid(input) && !regularVM.isSlotEmpty(input-1));
            moneyQty = askForMoneyQty(cashReg);

            regularVM.processPurchase(moneyQty, input-1);

            regularVMs.add(index, regularVM);
        }
    }
     /*
 * restocking specific items, replace an item
 * setting the price for the item type
 * collecting payment
 * replenishing money to provide change
 * print summary of transactions qty x price
 * display inv
 */

    public void maintenanceTest() {
    
        int menuChoice = 0;
        while(menuChoice != 7) {
            System.out.println("Select a maintenance feature: ");
            System.out.println("1: Restocking an item");
            System.out.println("2: Replacing an item");
            System.out.println("3: Collecting payment");
            System.out.println("4: Replenishing money");
            System.out.println("5: Print summary of transactions");
            System.out.println("6: Display inventory");

            menuChoice = keypad.nextInt();
            switch(menuChoice) {
                case 1:
                    int slotIndex = keypad.nextInt();
                    keypad.nextLine();
                    int itemQty = keypad.nextInt();
                    regularVM.restockSlot(slotIndex, itemQty);
                    break;
                case 2:
                    String name = keypad.nextLine();
                    double price = keypad.nextDouble();
                    keypad.nextLine();
                    double calorieCount = keypad.nextDouble();
                    keypad.nextLine();
                    slotIndex = keypad.nextInt();
                    keypad.nextLine();
                    Item item = new Item(name, price, calorieCount);
                    regularVM.replaceItemInSlot(slotIndex, item);
                    break;
                case 3:
                    regularVM.getCashRegister().clearCashRegister();
                    break;
                case 4:
                    int[] moneyQty = new int[9];
                    moneyQty[0] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[1] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[2] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[3] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[4] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[5] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[6] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[7] = keypad.nextInt();
                    keypad.nextLine();
                    moneyQty[8] = keypad.nextInt();
                    keypad.nextLine();
                    regularVM.getCashRegister().addMoney(moneyQty);
                    break;
                case 5:
                    regularVM.displayAllInvInfo();
                    break;
                case 6:
                    regularVM.displayAllInvQtySold();
                    break;
                case 7:
                    break;
            }
        }
    }
    public int askYesOrNo(){
        int input = 0;
        do{
            System.out.println("0-no 1-yes"); 
            input = keypad.nextInt();
        }while(input != 0 && input != 1);
        return input;
    }
   
    public  void initializeItemPool(){
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
    
    public int promptValidMoneyQty(int qty, CashRegister cashReg){
         while (!cashReg.isMoneyQtyValid(qty)){
            System.out.print("Enter a valid number: ");
            qty = keypad.nextInt();
         }
        return qty;
    }
    public int askForEmptySlot(RegularVM newRegVM){
        int slotNum;
         System.out.print("Enter slot number (1-8): ");
            slotNum = keypad.nextInt();//accept input
            while(  !newRegVM.isSlotNumValid(slotNum) || !newRegVM.isSlotEmpty(slotNum-1)){
                System.out.print("Error, try again (choose an empty slot 1-8): ");
                slotNum = keypad.nextInt();//accept input
            }
            return slotNum;
    }
    public void printItemPool(){
         System.out.println("\t--Item Pool--");
            System.out.println("Number\tItem\t\tCalories\tPrice");

            for (int j = 0; j < 10; j++){
                System.out.print(j+"\t"+itemPool[j].getName()+"\t\t");
                System.out.print(itemPool[j].getCalories()+"\t\t");
                System.out.println(itemPool[j].getPrice()+"\t");
            }

    }
    public int askForProductInd(RegularVM newRegVM){
        
        int prodNum;
        System.out.print("Enter item for this slot (0-9): ");  
        prodNum = keypad.nextInt();//accept input
        //INPUT VALIDATION
        while( prodNum < 0 || prodNum > 9 || newRegVM.isItemDuplicate(itemPool[prodNum])){
            System.out.print("Error, try again (no duplicates, choose a valid item 0-9): ");
            prodNum = keypad.nextInt();
        }
        return prodNum;
    }
    public int[] askForMoneyQty(CashRegister cashReg){
        int[] moneyQty = new int[9];
        System.out.println("Enter number of the ff. coins/bills:");
        System.out.print("1 Peso coins: ");
        moneyQty[0] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[0], cashReg);

        System.out.print("5 Peso coins: ");
        moneyQty[1] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[1], cashReg);

        System.out.print("10 Peso coins: ");
        moneyQty[2] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[2], cashReg);

        System.out.print("20 Peso coins: ");
        moneyQty[3] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[3], cashReg);

        System.out.print("50 Peso coins: ");
        moneyQty[4] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[4], cashReg);

        System.out.print("100 Peso coins: ");
        moneyQty[5] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[5], cashReg);

        System.out.print("200 Peso coins: ");
        moneyQty[6] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[6], cashReg);

        System.out.print("500 Peso coins: ");
        moneyQty[7] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[7], cashReg);

        System.out.print("1000 Peso coins: ");
        moneyQty[8] = keypad.nextInt();
        promptValidMoneyQty(moneyQty[8], cashReg);

        return moneyQty;
    }
}