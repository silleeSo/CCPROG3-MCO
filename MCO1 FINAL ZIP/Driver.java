import java.util.Scanner;
 /**
*	The class Driver contains the main method that runs the vending machine simulator. It allows all classes in the package to be used in simulation.
*
* 	@author So, Chrysille
*	@author Chen, Abraham
*/
public class Driver {
    private RegularVM regularVM;
    private Item[] itemPool;
    /**
     * This is the scanner used for class Driver.
     */
    public static Scanner keypad = new Scanner(System.in);

    /**
     * This method creates an instance of class Driver. It instatiates the item pool of 10 items.
     */
    public Driver(){

        itemPool = new Item[10];
    }
    /**
     * this is the main method that drives the vending machine factory simulation. It opens a main menu with options for redirection.
     * @param args standard parameter for main method
     */
    public static void main (String args[]) {

        int input = 0;
        Driver factory = new Driver();

        //Scanner keypad = new Scanner(System.in);
        while (input != 3){
            factory.initializeItemPool();
            System.out.println("---Vending Machine Factory Simulator---");
            System.out.println("\t1 - Create Vending Machine");
            System.out.println("\t2 - Test a Vending Machine");
            System.out.println("\t3 - Exit");
            do{
                System.out.println("Enter a number: ");
                input = keypad.nextInt();
                keypad.nextLine();
            }while(input < 1 || input > 3);
            System.out.println("\033c");    //CLEAR
            switch (input) {
                case 1:
                    factory.createRegularVM();
                    break;
                case 2:
                    if (factory.regularVM == null)
                        System.out.println("No vending machine to test..");
                    else
                        factory.testVM();
                    break;
                default:
                    break;
            }
        }
        keypad.close();
    }

    /**
     * This is a helper method in class Driver that opens the menu for creating a new regular vending machine.
     */
    private void createRegularVM() {
        regularVM = new RegularVM();
        int slotNum, prodNum, itemQty, input = 1; 
        int[] moneyQty = new int[9];    
       
        for (int i = 0; i < 8 && input == 1; i++){    //repeat 8 times, 8 slots
            System.out.println("\033c"); //clear
            System.out.println("---Create Vending Machine---"); // print header
            slotNum = askForEmptySlot(); // get slot number
            System.out.println("\033c");   //clear
            printItemPool();
            prodNum = askForProductInd(); // get product index        
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
        if (input == 0)
            regularVM = null;
    }
  
    /**
     * This is a private method in class Driver that opens the menu for testing a vending machine.
     */
    private void testVM(){
        int input = 0;
        regularVM.displaySlots();
        regularVM.displayMoneyQty();
        System.out.println("Test this vending machine?");
        input = askYesOrNo();
         while (input == 1 || input == 2) {
            System.out.println("---Test Vending Machine---");
            System.out.println("1 - Features Test");
            System.out.println("2 - Maintenance Test");
            System.out.println("3 - Exit");
            do{
                System.out.println("Enter a valid number: ");
                input = keypad.nextInt();
                keypad.nextLine();
            }while(input < 1 || input > 3);
            
            switch(input){
                case 1:
                    featuresTest();
                    break;
                case 2:
                    maintenanceTest();
                    break;
                case 3: break;
            }
        }
    }
    /**
     * This is a private method in class Driver that opens the menu for features testing. It allows user to try out features such as buying an item and inserting money.
     */
    private void featuresTest(){
        int input = 1;
        while(input!=0){
            int[] moneyQty = new int[9];
            CashRegister cashReg = regularVM.getCashRegister();
            regularVM.displaySlots();
            do{
                System.out.println("Enter slot number to purchase from (1-8), enter 0 to cancel: ");
                input = keypad.nextInt();  //ask for slot num 1-8    
                if (input == 0)
                    break;
            } while (!regularVM.isSlotNumValid(input) || regularVM.isSlotEmpty(input-1));
            if (input!=0){
                moneyQty = askForMoneyQty(cashReg);
                regularVM.processPurchase(moneyQty, input-1);
                System.out.println("Enter any number to continue, enter zero to go back to menu: ");
                input = keypad.nextInt();   
            }
        }
    }
    /**
     * This is a private method in class Driver that opens the menu for maintenance features for a defined regular vending machine.
     */
    private void maintenanceTest() {
    
        int menuChoice = 0;
        while(menuChoice != 7) {
            System.out.println("Select a maintenance feature: ");
            System.out.println("1: Restocking an item");
            System.out.println("2: Replacing an item");
            System.out.println("3: Collecting payment");
            System.out.println("4: Replenishing money");
            System.out.println("5: Print summary of transactions");
            System.out.println("6: Display inventory");
            System.out.println("7: Exit");
            do{
                System.out.println("Enter a valid number: ");
                menuChoice = keypad.nextInt();
            }while(menuChoice < 1 || menuChoice > 7);
            switch(menuChoice) {
                case 1:
                    int slotIndex = askForValidSlot() - 1;
                    keypad.nextLine();
                    System.out.println("Enter item quantity: ");
                    int itemQty = keypad.nextInt();
                    keypad.nextLine();
                    regularVM.restockSlot(slotIndex, itemQty);
                    break;
                case 2:
                    printItemPool();
                    int prodNum = askForProductInd();
                    int slotNum = askForValidSlot();
                    Item item = itemPool[prodNum];
                    if (regularVM.replaceItemInSlot(slotNum-1, item))
                        System.out.println("Item replaced successfully.");
                    else
                        System.out.println("Item can not be replaced, slot is not empty.");
                    break;
                case 3:
                    regularVM.collectMoney();
                    break;
                case 4:
                    int[] moneyQty = askForMoneyQty(regularVM.getCashRegister());
                    regularVM.getCashRegister().addMoney(moneyQty);
                    break;
                case 5:
                    regularVM.displayAllInvQtySold();
                    break;
                case 6:
                    regularVM.displayAllInvInfo();
                    break;
                case 7:
                    break;
            }
        }
    }
    /**
     * this is a helper method in class Driver that asks the user yes or no. Yes and no are represented by 1 and 0 respectively. This method will continually ask for input until either 1 or 0 is entered. 
     * @return the last user input, either 0 or 1
     */
    private int askYesOrNo(){
        int input = 0;
        do{
            System.out.println("0-no 1-yes"); 
            input = keypad.nextInt();
        }while(input != 0 && input != 1);
        return input;
    }
    /**
     * This private method initializes the pre-defined item pool for the user to choose from.
     */
    private void initializeItemPool(){
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
    /**
     * This helper method in class Driver checks if the last user input is a valid quantity for money. Valid values include non-negative numbers. This method repeatedly asks for input until condition is satisfied.
     * @param qty - the quantity given by the user
     * @param cashReg - the CashRegister of the defined regular vending machine
     * @return the last user input considered a valid quantity
     */
    private int promptValidMoneyQty(int qty, CashRegister cashReg){
         while (!cashReg.isMoneyQtyValid(qty)){
            System.out.print("Enter a valid number: ");
            qty = keypad.nextInt();
         }
        return qty;
    }
    /**
     * This helper method in class Dirver repeatedly asks the user for a slot number until the user enters a slot number that is both valid and empty. Valid numbers include numbers 1 to 8.
     *
     * @return the last user input that is a valid slot number and an empty slot number 
     */
    private int askForEmptySlot(){
        int slotNum;
         System.out.print("Enter slot number (1-8): ");
            slotNum = keypad.nextInt();//accept input
            while(!regularVM.isSlotNumValid(slotNum) || !regularVM.isSlotEmpty(slotNum-1)){
                System.out.print("Error, try again (choose an empty slot 1-8): ");
                slotNum = keypad.nextInt();//accept input
            }
            return slotNum;
    }
    /**
     * This helper method in class Dirver repeatedly asks the user for a slot number until the user enters a slot number that is valid. Valid numbers include numbers 1 to 8.
     *
     * @return the last user input considered a valid slot number
     */
    private int askForValidSlot(){
        int slotNum;
         System.out.print("Enter slot number (1-8): ");
            slotNum = keypad.nextInt();//accept input
            while(!regularVM.isSlotNumValid(slotNum)){
                System.out.print("Error, try again (1-8): ");
                slotNum = keypad.nextInt();//accept input
            }
            return slotNum;
    }
    /**
     * This private method in class Driver prints the pre-defined item pool information on the screem.
     */
    private void printItemPool(){
        System.out.println("\t--Item Pool--");
        System.out.println("Number\tItem\t\tCalories\tPrice");
        for (int j = 0; j < 10; j++){
            System.out.print(j+"\t"+itemPool[j].getName()+"\t\t");
            System.out.print(itemPool[j].getCalories()+"\t\t");
            System.out.println(itemPool[j].getPrice()+"\t");
        }
    }
    /**
     * This helper method in class Driver repeatedly asks the user for a valid index for the item pool array. Valid indexes include numbers 0 to 9. The item in the specified index must also not exist already in the defined vending machine.
     * @return the last user input considered a valid index for the item pool array
     */
    private int askForProductInd(){
        int prodNum;
        System.out.print("Enter item for this slot (0-9): ");  
        prodNum = keypad.nextInt();//accept input
        while( prodNum < 0 || prodNum > 9 || regularVM.isItemDuplicate(itemPool[prodNum])){
            System.out.print("Error, try again (no duplicates 0-9): ");
            prodNum = keypad.nextInt();
        }
        return prodNum;
    }
    /**
     * This helper method in class Driver prompts the user the enter the quantity of each kind of bill and coin.
     * @param cashReg -  the CashRegister of the defined vending machine
     * @return an integer array of quantities for each type of bill and coin
     */
    private int[] askForMoneyQty(CashRegister cashReg){
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

