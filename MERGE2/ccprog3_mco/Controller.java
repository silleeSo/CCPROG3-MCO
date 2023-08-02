package ccprog3_mco;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.io.*;
import java.util.*;
import javafx.event.*;

public class Controller extends Application {
    private View view = new View();
    private RegularVM regularVM = null;
    private SpecialVM specialVM = null;
    private HashMap<String, String> regVMPictures = new HashMap<String, String>();

    @Override
    public void start(Stage stage) {
        setActions(view);
        view.setStage(stage);
        view.getStage().setOnCloseRequest(e -> {
            e.consume();
            clickClose(view.getStage());
        });
        stage.setTitle("Vending Machine Factory Simulator");
        stage.setScene(view.makeWelcomeUser());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void clickClose(Stage stage) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?",
            ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> confirm = a.showAndWait();
        if(confirm.isPresent() && confirm.get() == ButtonType.YES)
            stage.close();
    }

    public void setActions(View view) {
        view.getBtnTestVM().setOnAction(e -> clickTestVM());
        view.getBtnConfirmCreateRegVM().setOnAction(e -> clickConfirmCreateRegVM());
        view.getBtnConfirmCreateSpecialVM().setOnAction(e -> clickConfirmCreateSpecialVM());
        view.getbtnInventoryInfo().setOnAction(e -> clickInventoryInfo());
        view.getBtnPurchaseItem().setOnAction(e -> clickPurchaseItem());
        view.getBtnReplenishCashReg().setOnAction(e -> clickBtnReplenishCashReg());

        view.getBtnConfirmEnterQuantity1().setOnAction(e -> clickConfirmEnterQuantity1());
        view.getBtnConfirmEnterQuantity5().setOnAction(e -> clickConfirmEnterQuantity5());
        view.getBtnConfirmEnterQuantity10().setOnAction(e -> clickConfirmEnterQuantity10());
        view.getBtnConfirmEnterQuantity20().setOnAction(e -> clickConfirmEnterQuantity20());
        view.getBtnConfirmEnterQuantity50().setOnAction(e -> clickConfirmEnterQuantity50());
        view.getBtnConfirmEnterQuantity100().setOnAction(e -> clickConfirmEnterQuantity100());
        view.getBtnConfirmEnterQuantity200().setOnAction(e -> clickConfirmEnterQuantity200());
        view.getBtnConfirmEnterQuantity500().setOnAction(e -> clickConfirmEnterQuantity500());
        view.getBtnConfirmEnterQuantity1000().setOnAction(e -> clickConfirmEnterQuantity1000());

        view.getBtnReassignSlot().setOnAction(e -> clickReassignSlot());
        view.getBtnConfirmReassignSlot().setOnAction(e -> clickConfirmReassignSlot());
        view.getBtnBackReassignSlot().setOnAction(e -> clickBackReassignSlot());

        view.getBtnRestockProductQty().setOnAction(e -> clickRestockProductQty());
        view.getBtnConfirmRestockSlot().setOnAction(e -> clickConfirmRestockSlot());
        view.getBtnBackRestockSlot().setOnAction(e -> clickBackRestockSlot());

        view.getBtnBackRepriceItem().setOnAction(e -> clickBackRepriceItem());        
        view.getBtnConfirmRepriceItem().setOnAction(e -> clickConfirmRepriceItem()); 
        view.getBtnRepriceItem().setOnAction(e -> clickRepriceItem());
        view.getBtnCreateNewItem().setOnAction(e -> clickCreateNewItem());
        view.getBtnConfirmRegCreateNewItem().setOnAction(e -> clickConfirmRegCreateNewItem()); 
        view.getBtnRegSelectItemPicture().setOnAction(e -> clickRegSelectItemPic());
        view.getBtnBackRegCreateNewItem().setOnAction(e -> clickBackRegNewItem());

        for(int i = 0; i <= 14; i++)
            view.getRegVMPurchaseButtons().add(i, new Button());
        view.getRegVMPurchaseButtons().get(0).setOnAction(e -> clickRegVMItem1());
        view.getRegVMPurchaseButtons().get(1).setOnAction(e -> clickRegVMItem2());
        view.getRegVMPurchaseButtons().get(2).setOnAction(e -> clickRegVMItem3());
        view.getRegVMPurchaseButtons().get(3).setOnAction(e -> clickRegVMItem4());
        view.getRegVMPurchaseButtons().get(4).setOnAction(e -> clickRegVMItem5());
        view.getRegVMPurchaseButtons().get(5).setOnAction(e -> clickRegVMItem6());
        view.getRegVMPurchaseButtons().get(6).setOnAction(e -> clickRegVMItem7());
        view.getRegVMPurchaseButtons().get(7).setOnAction(e -> clickRegVMItem8());
        view.getRegVMPurchaseButtons().get(8).setOnAction(e -> clickRegVMItem9());
        view.getRegVMPurchaseButtons().get(9).setOnAction(e -> clickRegVMItem10());
        view.getRegVMPurchaseButtons().get(10).setOnAction(e -> clickRegVMItem11());
        view.getRegVMPurchaseButtons().get(11).setOnAction(e -> clickRegVMItem12());
        view.getRegVMPurchaseButtons().get(12).setOnAction(e -> clickRegVMItem13());
        view.getRegVMPurchaseButtons().get(13).setOnAction(e -> clickRegVMItem14());
        view.getRegVMPurchaseButtons().get(14).setOnAction(e -> clickRegVMItem15());

        view.getBtnCollectSpecified().setOnAction(e -> clickCollectSpecified());
        view.getBtnCollectAll().setOnAction(e -> clickCollectAll());
    }

    public void clickTestVM() {
        if(regularVM == null && specialVM == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, 
                "You must create a vending machine first!", ButtonType.OK);
            a.showAndWait();
        } else 
            view.getStage().setScene(view.makeMyCreatedVM());
    }

    public void clickConfirmCreateRegVM() {
        if(regularVM != null || specialVM != null) {
            Alert a = new Alert(Alert.AlertType.WARNING, 
                    "You have already made a vending machine! Will you make a new one?", 
                    ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> confirm = a.showAndWait();
            if(confirm.isPresent() && confirm.get() == ButtonType.YES){
                regularVM = null;
                specialVM = null;
                createRegVM();
            }
        } else
            createRegVM();
    }

    public void clickConfirmCreateSpecialVM() {
        if(regularVM != null || specialVM != null) {
            Alert a = new Alert(Alert.AlertType.WARNING, 
                    "You have already made a vending machine! Will you make a new one?", 
                    ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> confirm = a.showAndWait();
            if(confirm.isPresent() && confirm.get() == ButtonType.YES) {
                regularVM = null;
                specialVM = null;
                createSpecialVM();
            }
        } else
            createSpecialVM();
    }

    public void createRegVM() {
        try {
            int noOfSlots = Integer.parseInt(view.getTextRegVMNoOfSlots().getText());
            int slotCapacity = Integer.parseInt(view.getTextRegVMSlotCapacity().getText());
            
            if(noOfSlots < 8 || noOfSlots > 15) {
                Alert b = new Alert(Alert.AlertType.WARNING, 
                    "There should only be 8-15 slots!", ButtonType.OK);
                b.showAndWait();
            } else if(slotCapacity < 10 || slotCapacity > 25) {
                Alert b = new Alert(Alert.AlertType.WARNING, 
                    "The slot capacity should be between 10-25 inclusive!", ButtonType.OK);
                b.showAndWait();
            } else {
                regularVM = new RegularVM(noOfSlots, slotCapacity);
                regularVM.initializeItemPool();
                specialVM = null;
                Alert b = new Alert(Alert.AlertType.INFORMATION,
                    "You have successfully created a regular vending machine!");
                b.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void createSpecialVM() {
        try {
            int noOfSlots = Integer.parseInt(view.getTextSpecialVMNoOfSlots().getText());
            int slotCapacity = Integer.parseInt(view.getTextSpecialVMSlotCapacity().getText());
            
            if(noOfSlots < 8 || noOfSlots > 15) {
                Alert b = new Alert(Alert.AlertType.WARNING, 
                    "There should only be 8-15 slots!", ButtonType.OK);
                b.showAndWait();
            } else if(slotCapacity < 10 || slotCapacity > 25) {
                Alert b = new Alert(Alert.AlertType.WARNING, 
                    "The slot capacity should be between 10-25 inclusive!", ButtonType.OK);
                b.showAndWait();
            } else {
                specialVM = new SpecialVM(noOfSlots, slotCapacity);
                specialVM.initializeItemPool();
                regularVM = null;
                Alert b = new Alert(Alert.AlertType.INFORMATION,
                    "You have successfully created a special vending machine!");
                b.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickInventoryInfo() {
        view.getStage().setScene(view.makeMyVMInventory());
        if(regularVM != null)
            view.getTextInventoryInfo().setText(regularVM.displayAllInvInfo());
        else if(specialVM != null)
            view.getTextInventoryInfo().setText(specialVM.displayAllInvInfo());
    }

    public void clickConfirmEnterQuantity1() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity1().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(1, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(1, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity5() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity5().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(5, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(5, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 5 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity10() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity10().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(10, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(10, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 10 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity20() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity20().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(20, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(20, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 20 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity50() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity50().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(50, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(50, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 50 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity100() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity100().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(100, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(100, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 100 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity200() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity200().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(200, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(200, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 200 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity500() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity500().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(500, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(500, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 500 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickConfirmEnterQuantity1000() {
        try {
            int quantity = Integer.parseInt(view.getTextEnterQuantity1000().getText());
            if(quantity < 0) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a valid integer!", ButtonType.OK);
                c.showAndWait();
            } else {
                if(regularVM != null)
                    regularVM.refillMoney(1000, quantity);
                else if(specialVM != null)
                    specialVM.refillMoney(1000, quantity);
                Alert c = new Alert(Alert.AlertType.INFORMATION,
                    "You have refilled " + 1000 * quantity + " pesos!", ButtonType.OK);
                c.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickReassignSlot() {
        view.getStage().setScene(view.makeMyVMReassignSlot());

        if(regularVM != null) {
            for(int i = 0; i <= regularVM.getSlots().length - 1; i++)
                view.getChoiceSlotNumber().getItems().add(i + 1);
            
            for(Item item : regularVM.getItemPool())
                view.getChoiceItem().getItems().add(item);
        }
            
        if(specialVM != null) {
            for(int i = 0; i <= specialVM.getSlots().length - 1; i++)
                view.getChoiceSlotNumber().getItems().add(i + 1);
            
            for(Item item : specialVM.getItemPool())
                view.getChoiceItem().getItems().add(item);
        }
    }

    public void clickConfirmReassignSlot() {
        if(regularVM != null) {
            try {
                int slotIndex = view.getChoiceSlotNumber().getValue() - 1;
                int slotNumber = view.getChoiceSlotNumber().getValue();
                Item item = view.getChoiceItem().getValue();

                boolean isDuplicate = regularVM.isItemDuplicate(item);
                if(!isDuplicate) {
                    boolean check = regularVM.replaceItemInSlot(slotIndex, item);
                    if(check) {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, 
                            "Successfully placed " + item.toString() + 
                            " in slot number " + slotNumber, ButtonType.OK);
                        a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.WARNING, 
                            "Slot must be empty before reassigning!", ButtonType.OK);
                        a.showAndWait();
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING, 
                        "Item already exists in a slot!", ButtonType.OK);
                    a.showAndWait();
                }
            } catch(NullPointerException e) {
                Alert a = new Alert(Alert.AlertType.WARNING, 
                    "Please select a choice!", ButtonType.OK);
                a.showAndWait();
            }
        }
        
        if(specialVM != null) {
            try {
                int slotIndex = view.getChoiceSlotNumber().getValue() - 1;
                int slotNumber = view.getChoiceSlotNumber().getValue();
                Item item = view.getChoiceItem().getValue();

                boolean isDuplicate = specialVM.isItemDuplicate(item);
                if(!isDuplicate) {
                    boolean check = specialVM.replaceItemInSlot(slotIndex, item);
                    if(check) {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, 
                            "Successfully placed " + item.toString() + 
                            " in slot number " + slotNumber, ButtonType.OK);
                        a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.WARNING, 
                            "Slot must be empty before reassigning!", ButtonType.OK);
                        a.showAndWait();
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING, 
                        "Item already exists in a slot!", ButtonType.OK);
                    a.showAndWait();
                }
            } catch(NullPointerException e) {
                Alert a = new Alert(Alert.AlertType.WARNING, 
                    "Please select a choice!", ButtonType.OK);
                a.showAndWait();
            }
        }
    }

    public void clickBackReassignSlot() {
        view.getStage().setScene(view.makeMyVMMaintenance());
        view.getChoiceItem().getItems().clear();
        view.getChoiceSlotNumber().getItems().clear();
    }

    public void clickRestockProductQty() {
        view.getStage().setScene(view.makeMyVMRestockSlot());

        if(regularVM != null) 
            for(int i = 0; i <= regularVM.getSlots().length - 1; i++)
                view.getChoiceSlotNumber().getItems().add(i + 1);
            
        if(specialVM != null) 
            for(int i = 0; i <= specialVM.getSlots().length - 1; i++)
                view.getChoiceSlotNumber().getItems().add(i + 1);
    }

    public void clickConfirmRestockSlot() {
        if(regularVM != null) {
            try {
                int quantity = Integer.parseInt(view.getTextQuantity().getText());
                int slotNumber = view.getChoiceSlotNumber().getValue();

                if(regularVM.isSlotAssigned(slotNumber - 1)) {
                    if(!regularVM.restockSlot(slotNumber - 1, quantity)) {
                        Alert a = new Alert(Alert.AlertType.WARNING, 
                            "Slot restock unsuccessful!", ButtonType.OK);
                        a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, 
                            "Successfully restocked " + regularVM.getSlotItem(slotNumber - 1).toString(), ButtonType.OK);
                        a.showAndWait();
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING, 
                        "The slot does not have any item assigned to it!", ButtonType.OK);
                    a.showAndWait();
                }
            } catch(NumberFormatException e) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input an integer!", ButtonType.OK);
                c.showAndWait();
            } catch(NullPointerException e) {
                Alert a = new Alert(Alert.AlertType.WARNING, 
                    "Please select a choice!", ButtonType.OK);
                a.showAndWait();
            }
        }

        if(specialVM != null) {
            try {
                int quantity = Integer.parseInt(view.getTextQuantity().getText());
                int slotNumber = view.getChoiceSlotNumber().getValue();

                if(specialVM.isSlotAssigned(slotNumber - 1)){
                    if(!specialVM.restockSlot(slotNumber - 1, quantity)) {
                        Alert a = new Alert(Alert.AlertType.WARNING, 
                            "Slot restock unsuccessful!", ButtonType.OK);
                        a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, 
                            "Successfully restocked " + specialVM.getSlotItem(slotNumber - 1).toString(), ButtonType.OK);
                        a.showAndWait();
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING, 
                        "The slot does not have any item assigned to it!", ButtonType.OK);
                    a.showAndWait();
                }
            } catch(NumberFormatException e) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input an integer!", ButtonType.OK);
                c.showAndWait();
            } catch(NullPointerException e) {
                Alert a = new Alert(Alert.AlertType.WARNING, 
                    "Please select a choice!", ButtonType.OK);
                a.showAndWait();
            }
        }
    }

    public void clickBackRestockSlot() {
        view.getStage().setScene(view.makeMyVMMaintenance());
        view.getChoiceSlotNumber().getItems().clear();
    }

    public void clickBtnReplenishCashReg() {
        view.getTextAmountStored().setText(regularVM.displayMoneyQty());
        view.getStage().setScene(view.makeMyVMReplenishCashReg());
    }

    public void clickConfirmRepriceItem() {
        if(regularVM != null) {
            try {
                int slotNumber = view.getChoiceSlotNumber().getValue();
                int price = Integer.parseInt(view.getTextPrice().getText());

                if(regularVM.isSlotAssigned(slotNumber - 1)) {
                    if(!regularVM.repriceItem((double)price, slotNumber - 1)) {
                        Alert a = new Alert(Alert.AlertType.WARNING, 
                            "Reprice unsuccessful!", ButtonType.OK);
                        a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, 
                            "Successfully repriced " + regularVM.getSlotItem(slotNumber - 1).toString(), ButtonType.OK);
                        a.showAndWait();
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING, 
                        "The slot does not have any item assigned to it!", ButtonType.OK);
                    a.showAndWait();
                }
            } catch(NumberFormatException e) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input an integer!", ButtonType.OK);
                c.showAndWait();
            } catch(NullPointerException e) {
                Alert a = new Alert(Alert.AlertType.WARNING, 
                    "Please select a choice!", ButtonType.OK);
                a.showAndWait();
            }
        }

        if(specialVM != null) {
            try {
                int quantity = Integer.parseInt(view.getTextQuantity().getText());
                int slotNumber = view.getChoiceSlotNumber().getValue();

                if(specialVM.isSlotAssigned(slotNumber - 1)){
                    if(!specialVM.restockSlot(slotNumber - 1, quantity)) {
                        Alert a = new Alert(Alert.AlertType.WARNING, 
                            "Slot restock unsuccessful!", ButtonType.OK);
                        a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, 
                            "Successfully restocked " + specialVM.getSlotItem(slotNumber - 1).toString(), ButtonType.OK);
                        a.showAndWait();
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING, 
                        "The slot does not have any item assigned to it!", ButtonType.OK);
                    a.showAndWait();
                }
            } catch(NumberFormatException e) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input an integer!", ButtonType.OK);
                c.showAndWait();
            } catch(NullPointerException e) {
                Alert a = new Alert(Alert.AlertType.WARNING, 
                    "Please select a choice!", ButtonType.OK);
                a.showAndWait();
            }
        }
    }

    public void clickBackRepriceItem() {
        view.getStage().setScene(view.makeMyVMMaintenance());
        view.getChoiceSlotNumber().getItems().clear();
    }

    public void clickRepriceItem() {
        if(regularVM != null) 
            for(int i = 0; i <= regularVM.getSlots().length - 1; i++)
                view.getChoiceSlotNumber().getItems().add(i + 1);
            
        if(specialVM != null) 
            for(int i = 0; i <= specialVM.getSlots().length - 1; i++)
                view.getChoiceSlotNumber().getItems().add(i + 1);

        view.getStage().setScene(view.makeMyVMRepriceItem());
    }

    public void clickPurchaseItem() {
        if(regularVM != null) {
            regVMPictures.put("Sausage", "file:Sausage.png");
            regVMPictures.put("Fried Egg", "file:Fried Egg.png");
            regVMPictures.put("Asado Pork", "file:Asado Pork.png");
            regVMPictures.put("Beef Brisket", "file:Beef Brisket.png");
            regVMPictures.put("Chicken Leg", "file:Chicken Leg.png");
            regVMPictures.put("Duck Leg", "file:Duck Leg.png");
            regVMPictures.put("Vegetables", "file:Vegetables.png");
            regVMPictures.put("Noodle Base", "file:Noodle Base.png");

            view.getStage().setScene(view.makeMyRegVMPurchaseAnItem());
            int noOfSlots = Integer.parseInt(view.getTextRegVMNoOfSlots().getText());

            for(int i = 0; i <= noOfSlots - 1; i++) {
                if(!regularVM.isSlotAssigned(i))
                    view.getRegVMPurchaseButtons().get(i).setText("NULL");
                else if(regularVM.isSlotAssigned(i)) {
                    if(regVMPictures.containsKey(regularVM.getSlotItem(i).getName())) {
                        ImageView buttonIcon = new ImageView(new Image(regVMPictures.get(regularVM.getSlotItem(i).getName())));
                        buttonIcon.setFitWidth(70);
                        buttonIcon.setPreserveRatio(true);
                        view.getRegVMPurchaseButtons().get(i).setGraphic(buttonIcon);
                    } else if(!regVMPictures.containsKey(regularVM.getSlotItem(i).getName()))
                        view.getRegVMPurchaseButtons().get(i).setText(regularVM.getSlotItem(i).getName());
                }
            }
        }
    }

    public void clickCreateNewItem() {
        if(regularVM != null)
            view.getStage().setScene(view.makeRegSlotCreateNewItem());
    }

    public void clickConfirmRegCreateNewItem() {
        if(regularVM != null) {
            try {
                String itemName = view.getTextNameRegCreateItem().getText();
                double itemPrice = (double)Integer.parseInt(view.getTextPriceRegCreateItem().getText());
                double itemCalories = (double)Integer.parseInt(view.getTextCaloriesRegCreateItem().getText());

                if(!regularVM.isItemDuplicate(new Item(itemName, itemPrice, itemCalories))) {
                    regularVM.createNewItem(itemName, itemPrice, itemCalories, true, "preparing");
                    Alert a = new Alert(Alert.AlertType.INFORMATION, 
                        "New item created: " + itemName + " (Price: " + itemPrice + ", Calories: " + itemCalories + ")",
                        ButtonType.OK);
                    a.showAndWait();
                }
            } catch(NumberFormatException e) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input an integer!", ButtonType.OK);
                c.showAndWait();
            } catch(NullPointerException e) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "You must input a value!", ButtonType.OK);
                c.showAndWait();
            }
        }
    }

    public void clickRegSelectItemPic() {
        try {
            String itemName = view.getTextNameRegCreateItem().getText();
            double itemPrice = (double)Integer.parseInt(view.getTextPriceRegCreateItem().getText());
            double itemCalories = (double)Integer.parseInt(view.getTextCaloriesRegCreateItem().getText());
            Item item = new Item(itemName, itemPrice, itemCalories);

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Item Photo");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                regVMPictures.put(item.getName(), file.toString());
                Alert a = new Alert(Alert.AlertType.INFORMATION, 
                    "Successfully set photo for " + item.toString(), ButtonType.OK);
                a.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        } catch(NullPointerException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input a value!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickBackRegNewItem() {
        view.getChoiceSlotNumber().getItems().clear();
        view.getChoiceItem().getItems().clear();

        for(int i = 0; i <= regularVM.getSlots().length - 1; i++)
            view.getChoiceSlotNumber().getItems().add(i + 1);
        
        for(Item item : regularVM.getItemPool())
                view.getChoiceItem().getItems().add(item);

        view.getStage().setScene(view.makeMyVMReassignSlot());
    }

    public void clickRegVMItem1() {
        if(!regularVM.isSlotAssigned(0) || regularVM.isSlotEmpty(0)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(0) && !regularVM.isSlotEmpty(0)) {
            Item item = regularVM.getSlotItem(0);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem1(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem1(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 0), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem2() {
        if(!regularVM.isSlotAssigned(1) || regularVM.isSlotEmpty(1)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(1) && !regularVM.isSlotEmpty(1)) {
            Item item = regularVM.getSlotItem(1);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem2(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem2(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 1), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem3() {
        if(!regularVM.isSlotAssigned(2) || regularVM.isSlotEmpty(2)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(2) && !regularVM.isSlotEmpty(2)) {
            Item item = regularVM.getSlotItem(2);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem3(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem3(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 2), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem4() {
        if(!regularVM.isSlotAssigned(3) || regularVM.isSlotEmpty(3)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(3) && !regularVM.isSlotEmpty(3)) {
            Item item = regularVM.getSlotItem(3);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem4(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem4(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 3), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem5() {
        if(!regularVM.isSlotAssigned(4) || regularVM.isSlotEmpty(4)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(4) && !regularVM.isSlotEmpty(4)) {
            Item item = regularVM.getSlotItem(4);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem5(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem5(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 4), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem6() {
        if(!regularVM.isSlotAssigned(5) || regularVM.isSlotEmpty(5)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(5) && !regularVM.isSlotEmpty(5)) {
            Item item = regularVM.getSlotItem(5);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem6(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem6(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 5), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem7() {
        if(!regularVM.isSlotAssigned(6) || regularVM.isSlotEmpty(6)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(6) && !regularVM.isSlotEmpty(6)) {
            Item item = regularVM.getSlotItem(6);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem7(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem7(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 6), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem8() {
        if(!regularVM.isSlotAssigned(7) || regularVM.isSlotEmpty(7)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(7) && !regularVM.isSlotEmpty(7)) {
            Item item = regularVM.getSlotItem(7);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem8(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem8(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 7), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem9() {
        if(!regularVM.isSlotAssigned(8) || regularVM.isSlotEmpty(8)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(8) && !regularVM.isSlotEmpty(8)) {
            Item item = regularVM.getSlotItem(8);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem9(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem9(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 8), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem10() {
        if(!regularVM.isSlotAssigned(9) || regularVM.isSlotEmpty(9)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(9) && !regularVM.isSlotEmpty(9)) {
            Item item = regularVM.getSlotItem(9);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem10(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem10(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 9), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem11() {
        if(!regularVM.isSlotAssigned(10) || regularVM.isSlotEmpty(10)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(10) && !regularVM.isSlotEmpty(10)) {
            Item item = regularVM.getSlotItem(10);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem11(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem11(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 10), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }
    
    public void clickRegVMItem12() {
        if(!regularVM.isSlotAssigned(11) || regularVM.isSlotEmpty(11)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(11) && !regularVM.isSlotEmpty(11)) {
            Item item = regularVM.getSlotItem(11);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem12(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem12(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 11), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem13() {
        if(!regularVM.isSlotAssigned(12) || regularVM.isSlotEmpty(12)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(12) && !regularVM.isSlotEmpty(12)) {
            Item item = regularVM.getSlotItem(12);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem13(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem13(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 12), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem14() {
        if(!regularVM.isSlotAssigned(13) || regularVM.isSlotEmpty(13)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(13) && !regularVM.isSlotEmpty(13)) {
            Item item = regularVM.getSlotItem(13);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem14(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem14(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 13), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickRegVMItem15() {
        if(!regularVM.isSlotAssigned(14) || regularVM.isSlotEmpty(14)) {
            Alert a = new Alert(Alert.AlertType.WARNING,
                "The slot is empty!", ButtonType.OK);
            a.showAndWait();
        } else if(regularVM.isSlotAssigned(14) && !regularVM.isSlotEmpty(14)) {
            Item item = regularVM.getSlotItem(14);
            view.getTextPayItemInfo().setText(item.toString());
            view.getBtnConfirmPayItem().setOnAction(e -> clickConfirmRegVMItem15(item));
            view.getStage().setScene(view.makePayItem());
        }
    }

    public void clickConfirmRegVMItem15(Item item) {
        try {
            int[] money = new int[9];
            int totalAmount;
            boolean amountCheck = true;

            money[0] = Integer.parseInt(view.getTextAmount1().getText());
            money[1] = Integer.parseInt(view.getTextAmount5().getText());
            money[2] = Integer.parseInt(view.getTextAmount10().getText());
            money[3] = Integer.parseInt(view.getTextAmount20().getText());
            money[4] = Integer.parseInt(view.getTextAmount50().getText());
            money[5] = Integer.parseInt(view.getTextAmount100().getText());
            money[6] = Integer.parseInt(view.getTextAmount200().getText());
            money[7] = Integer.parseInt(view.getTextAmount500().getText());
            money[8] = Integer.parseInt(view.getTextAmount1000().getText());

            totalAmount = money[0] + 5 * money[1] + 10 * money[2] + 20 * money[3] + 50 * money[4] + 
            100 * money[5] + 200 * money[6] + 500 * money[7] + 1000 * money[8];
            
            for(int i = 0; i <= 8; i++)
                if(money[i] < 0)
                    amountCheck = false;

            if(totalAmount < item.getPrice() || !amountCheck) {
                Alert c = new Alert(Alert.AlertType.WARNING, 
                    "Check your input!", ButtonType.OK);
                c.showAndWait();
            } else {
                Alert c = new Alert(Alert.AlertType.INFORMATION, 
                    regularVM.processPurchase(money, 14), ButtonType.OK);
                c.showAndWait();
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }
    }

    public void clickCollectSpecified() {
        try {
            int amount = Integer.parseInt(view.getTextAmount().getText());
            if(regularVM != null) {
                if(regularVM.isNumberValid(amount)) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION,
                        regularVM.collectMoney(amount), ButtonType.OK);
                    a.showAndWait();
                } else if(!regularVM.isNumberValid(amount)) {
                    Alert a = new Alert(Alert.AlertType.WARNING,
                        "You have to input a valid number!", ButtonType.OK);
                    a.showAndWait();
                }
            }

            if(specialVM != null) {
                if(specialVM.isNumberValid(amount)) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION,
                        specialVM.collectMoney(amount), ButtonType.OK);
                    a.showAndWait();
                } else if(!specialVM.isNumberValid(amount)) {
                    Alert a = new Alert(Alert.AlertType.WARNING,
                        "You have to input a valid number!", ButtonType.OK);
                    a.showAndWait();
                }
            }
        } catch(NumberFormatException e) {
            Alert c = new Alert(Alert.AlertType.WARNING, 
                "You must input an integer!", ButtonType.OK);
            c.showAndWait();
        }     
    }

    public void clickCollectAll() {
        if(regularVM != null) {
            Alert c = new Alert(Alert.AlertType.INFORMATION, 
                regularVM.collectAllMoney(), ButtonType.OK);
            c.showAndWait();
        }

        if(specialVM != null) {
            Alert c = new Alert(Alert.AlertType.INFORMATION, 
                specialVM.collectAllMoney(), ButtonType.OK);
            c.showAndWait();
        }
    }
}