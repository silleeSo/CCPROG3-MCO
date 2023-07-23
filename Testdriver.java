public class Testdriver {
    public static void main (String[] args){
                          // 1,5,10,20,50,100,200,500,1000
        int[] moneyInserted = {0,0,0, 0, 0,  0,  0,  0,  1};
        int[] moneyStored = {5,5,5,5,5,5,5,5,1};
        RegularVM regVM = new RegularVM();
        regVM.refillMoney(moneyStored);
        regVM.initializeSlot(0, "Sushi", 50, 100, 10);
        System.out.println(regVM.processPurchase(moneyInserted, 0));
        
        regVM.initializeSlot(1, "Sushi2", 51, 100, 10);
        regVM.initializeSlot(2, "Sushi3", 52, 100, 10);
        regVM.initializeSlot(3, "Sushi4", 53, 100, 10);
        regVM.initializeSlot(4, "Sushi5", 54, 100, 10);
        regVM.initializeSlot(5, "Sushi6", 55, 100, 10);
        regVM.initializeSlot(6, "Sushi7", 56, 100, 10);
        regVM.initializeSlot(7, "Sushi8", 57, 100, 9);
        System.out.println(regVM.displayAllInvQtySold());
        System.out.println(regVM.processPurchase(moneyInserted, 7));
        System.out.println(regVM.displayAllInvQtySold());
        System.out.println("RESTOCKING...");
        regVM.restockSlot(7, 1);
        System.out.println(regVM.displayAllInvQtySold());
    }
}
/*
 * NOTES
 * - Fix restock (refresh for all slots)
 * - Incorporate predefined pool in regVM
 * - Incorporate freedom to define new products
 */
