public class Factory {
    //action lsiteners
    // function calls segregated by actionListeners
    //note that this class should handle user validation (Ex: user enters invalid slots/ user enters character kahit num dapat)
    //This class is responsible for sedning the correct information to the model methods and constructors

    /*RegularVM regularVendingMachine = null
    SpecialVM specialVendingMachine = null
     * ACTION LISTENERS TO TAKE NOTE OF
     * 1. When confirm button in create vending machine is clicked
     *      - send the information entered by user(num of slots and slot capacity) to RegularVM or Special VM to
     *          create a new VM
     *          if (the user previously selected Regular VM button before creation){
     *              create instance of RegularVM and save it sa variable
     *          }
     *          else if (the user previously selected Special VM button before creation){
     *              create instance of SpecialVM and save it sa variable
     *          }
     * 2. when test vending machine button has been clicked
     *      - if no instance yet at all, dont allow testing
     *      - if meron..
     *      sa purchasing of item:
     *      - gui should be able to display all slots (this will vary kasi slot number isnt fixed anymore)
     *      - upon clicking the buy an item button,
     *        this class should call displaySlots() from vm class and send this list to gui to display
     *      - when user confirms purchase, first check if slot is not empty and is assigned to an item by calling
     *        isSlotAssigned(slotIndex)
     *      - if not assigned, just inform user through gui
     *      - if it is assigned naman, call proccessPurchase() and send correct information (this method
     *        will return a string, so take that and display it sa gui)
     *          Ex: the class asks for slotIndex, dapat ang ipapass is slotNum-1
     *      - when user selects inventory, call displayAllInvInfo() and display the resulting String
     *      - when user selects reprice and confirms price, first check if slot is assigned to item by isSlotAssigned(index) 
     *        if yes, send the new Price to repriceItem(double newPrice, int slotIndex), if not inform user through gui.
     *        repriceItem method will return false if may centavoes, so from then dapat may madisplay sa gui na notif if false
     *      - when user selects restock and confirms qty and slot, first check by isSlotAssigned ulit, then if true,
     *        call restockSlot(int index, int qty)
     *        restockSlot method will return true if qty is valid and restock was successful, it will return false if qty is too much or slot is full
     *      - when user wants to replace or add item, first check if slot is assigned (isSlotAssigned). If it is, call replace 
     *        check if slot is empty[isSlotEmpty(slotIndex)]. If the slot is empty, call getItemPool() and display in gui the info contained in this arrayList.
     *        Let user choose which item will replace the current one in slot (button or drop down). Once the user selects, call
     *        replaceItemInSlot(int slotIndex, int itemPoolIndex), send the correct info
     *      - if the slot was actually empty and the user just wanted to assign an item to the selected slot, call updateSlot(int index, String name, double price, double calories, int qty)
     *     
     *      CASH REGISTER:
     *      - Replenish
     *          after selecting money type and typing qty, validate qty by calling isNumberValid(num). If valid , proceed
     *          to calling refillMoney(moneyType, qty). After refilling, user should be notified in gui and should be redirected to money selection
     *      - Collect
     *          give user choice to collect a certain amount or collect all PERO 1 SCREEN NALANG KASI #PAGOD
     *          AFTER USER FILLS OUT KEME AND CLICKS COLLECT SPECIFIED, validate amount by calling isNumberValid(num).
     *          If valid, call collectMoney(amount). This method will return a string, display the string somewhere.
     *      
     *          If user clicks collect all money, display warning and ask for confirmation. If user proceeds, call collectAllMoney() and display the 
     *          resulting String*/

     /*NEW SLIDES IN CANVA
      * - Purchasing an item
        - collect money and replenish money
        - replenishing and collecting money screens
  
      */
     
}
