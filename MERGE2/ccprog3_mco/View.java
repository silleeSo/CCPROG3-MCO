package ccprog3_mco;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;

public class View {
    Stage stage;

    // makeWelcomeUser()
    private Button btnTestVM = new Button();
    public Button getBtnTestVM() {
        return btnTestVM;
    }

    // makeCreateRegularVM()
    private TextField textRegVMNoOfSlots = new TextField();
    public TextField getTextRegVMNoOfSlots() {
        return textRegVMNoOfSlots;
    }
    private TextField textRegVMSlotCapacity = new TextField();
    public TextField getTextRegVMSlotCapacity() {
        return textRegVMSlotCapacity;
    }
    private Button btnConfirmCreateRegVM = new Button();
    public Button getBtnConfirmCreateRegVM() {
        return btnConfirmCreateRegVM;
    }

    // makeCreateZhajiangmianVM()
    private TextField textSpecialVMNoOfSlots = new TextField();
    public TextField getTextSpecialVMNoOfSlots() {
        return textSpecialVMNoOfSlots;
    }
    private TextField textSpecialVMSlotCapacity = new TextField();
    public TextField getTextSpecialVMSlotCapacity() {
        return textSpecialVMSlotCapacity;
    }
    private Button btnConfirmSpecialVM = new Button();
    public Button getBtnConfirmCreateSpecialVM() {
        return btnConfirmSpecialVM;
    }

    // makeMyVMMaintenance()
    private Button btnInventoryInfo = new Button();
    public Button getbtnInventoryInfo() {
        return btnInventoryInfo;
    }
    private Button btnReassignSlot = new Button();
    public Button getBtnReassignSlot() {
        return btnReassignSlot;
    }
    private Button btnRestockProductQty = new Button();
    public Button getBtnRestockProductQty() {
        return btnRestockProductQty;
    }
    private Button btnReplenishCashReg = new Button();
    public Button getBtnReplenishCashReg() {
        return btnReplenishCashReg; 
    }
    private Button btnRepriceItem = new Button();
    public Button getBtnRepriceItem() {
        return btnRepriceItem;
    }
    
    // makeMYVMInventory()
    private Text textInventoryInfo = new Text();
    public Text getTextInventoryInfo() {
        return textInventoryInfo;
    }

    // makeMyCreatedVM()
    private Button btnPurchaseItem = new Button();
    public Button getBtnPurchaseItem() {
        return btnPurchaseItem;
    }

    // makeMyVMReplenishCashReg()
    private TextField textEnterQuantity1 = new TextField();
    public TextField getTextEnterQuantity1() {
        return textEnterQuantity1;
    }
    private Button btnConfirmEnterQuantity1 = new Button();
    public Button getBtnConfirmEnterQuantity1() {
        return btnConfirmEnterQuantity1;
    }
    private TextField textEnterQuantity5 = new TextField();
    public TextField getTextEnterQuantity5() {
        return textEnterQuantity5;
    }
    private Button btnConfirmEnterQuantity5 = new Button();
    public Button getBtnConfirmEnterQuantity5() {
        return btnConfirmEnterQuantity5;
    }
    private TextField textEnterQuantity10 = new TextField();
    public TextField getTextEnterQuantity10() {
        return textEnterQuantity10;
    }
    private Button btnConfirmEnterQuantity10 = new Button();
    public Button getBtnConfirmEnterQuantity10() {
        return btnConfirmEnterQuantity10;
    }
    private TextField textEnterQuantity20 = new TextField();
    public TextField getTextEnterQuantity20() {
        return textEnterQuantity20;
    }
    private Button btnConfirmEnterQuantity20 = new Button();
    public Button getBtnConfirmEnterQuantity20() {
        return btnConfirmEnterQuantity20;
    }
    private TextField textEnterQuantity50 = new TextField();
    public TextField getTextEnterQuantity50() {
        return textEnterQuantity50;
    }
    private Button btnConfirmEnterQuantity50 = new Button();
    public Button getBtnConfirmEnterQuantity50() {
        return btnConfirmEnterQuantity50;
    }
    private TextField textEnterQuantity100 = new TextField();
    public TextField getTextEnterQuantity100() {
        return textEnterQuantity100;
    }
    private Button btnConfirmEnterQuantity100 = new Button();
    public Button getBtnConfirmEnterQuantity100() {
        return btnConfirmEnterQuantity100;
    }
    private TextField textEnterQuantity200 = new TextField();
    public TextField getTextEnterQuantity200() {
        return textEnterQuantity200;
    }
    private Button btnConfirmEnterQuantity200 = new Button();
    public Button getBtnConfirmEnterQuantity200() {
        return btnConfirmEnterQuantity200;
    }
    private TextField textEnterQuantity500 = new TextField();
    public TextField getTextEnterQuantity500() {
        return textEnterQuantity500;
    }
    private Button btnConfirmEnterQuantity500 = new Button();
    public Button getBtnConfirmEnterQuantity500() {
        return btnConfirmEnterQuantity500;
    }
    private TextField textEnterQuantity1000 = new TextField();
    public TextField getTextEnterQuantity1000() {
        return textEnterQuantity1000;
    }
    private Button btnConfirmEnterQuantity1000 = new Button();
    public Button getBtnConfirmEnterQuantity1000() {
        return btnConfirmEnterQuantity1000;
    }
    private Text textAmountStored = new Text();
    public Text getTextAmountStored() {
        return textAmountStored;
    }

    // makeMyVMReassignSlot()
    private ChoiceBox<Integer> choiceSlotNumber = new ChoiceBox<Integer>();
    public ChoiceBox<Integer> getChoiceSlotNumber() {
        return choiceSlotNumber;
    }
    private Button btnBackReassignSlot = new Button();
    public Button getBtnBackReassignSlot() {
        return btnBackReassignSlot;
    }
    private ChoiceBox<Item> choiceItem = new ChoiceBox<Item>();
    public ChoiceBox<Item> getChoiceItem() {
        return choiceItem;
    }
    private Button btnConfirmReassignSlot = new Button();
    public Button getBtnConfirmReassignSlot() {
        return btnConfirmReassignSlot;
    }
    private Button btnCreateNewItem = new Button();
    public Button getBtnCreateNewItem() {
        return btnCreateNewItem;
    }

    // makeMyVMRestockSlot()
    private TextField textQuantity = new TextField();
    public TextField getTextQuantity() {
        return textQuantity;
    }
    private Button btnConfirmRestockSlot = new Button();
    public Button getBtnConfirmRestockSlot() {
        return btnConfirmRestockSlot;
    }
    private Button btnBackRestockSlot = new Button();
    public Button getBtnBackRestockSlot() {
        return btnBackRestockSlot;
    } 

    // makeMyVMRepriceItem()
    private Button btnConfirmRepriceItem = new Button();
    public Button getBtnConfirmRepriceItem() {
        return btnConfirmRepriceItem;
    }
    private TextField textPrice = new TextField();
    public TextField getTextPrice() {
        return textPrice;
    }
    private Button btnBackRepriceItem = new Button();
    public Button getBtnBackRepriceItem() {
        return btnBackRepriceItem;
    }
    
    // makeMyRegVMPurchaseAnItem()
    private ArrayList<Button> regVMPurchaseButtons = new ArrayList<Button>();
    public ArrayList<Button> getRegVMPurchaseButtons() {
        return regVMPurchaseButtons;
    }

    
    // makeRegSlotCreateNewItem()
    private TextField textNameRegSlotCreateNewItem = new TextField();
    public TextField getTextNameRegCreateItem() {
        return textNameRegSlotCreateNewItem;
    }
    private TextField textPriceRegSlotCreateNewItem = new TextField();
    public TextField getTextPriceRegCreateItem() {
        return textPriceRegSlotCreateNewItem;
    }
    private TextField textCaloriesRegSlotCreateNewItem = new TextField();
    public TextField getTextCaloriesRegCreateItem() {
        return textCaloriesRegSlotCreateNewItem;
    }
    private Button btnRegSelectItemPicture = new Button();
    public Button getBtnRegSelectItemPicture() {
        return btnRegSelectItemPicture;
    }
    private Button btnConfirmRegCreateNewItem = new Button();
    public Button getBtnConfirmRegCreateNewItem() {
        return btnConfirmRegCreateNewItem;
    }
    private Button btnBackRegCreateNewItem = new Button();
    public Button getBtnBackRegCreateNewItem() {
        return btnBackRegCreateNewItem;
    }

    // makeMyVMCollectMoney() 
    private TextField textAmount = new TextField();
    public TextField getTextAmount() {
        return textAmount;
    }
    private Button btnCollectSpecified = new Button();
    public Button getBtnCollectSpecified() {
        return btnCollectSpecified;
    }
    Button btnCollectAll = new Button();
    public Button getBtnCollectAll() {
        return btnCollectAll;
    }

    // makePayItem()
    private Text textPayItemInfo = new Text();
    public Text getTextPayItemInfo() {
        return textPayItemInfo;
    }    
    private TextField textAmount1 = new TextField("0");
    public TextField getTextAmount1() {
        return textAmount1;
    }
    private TextField textAmount5 = new TextField("0");
    public TextField getTextAmount5() {
        return textAmount5;
    }
    private TextField textAmount10 = new TextField("0");
    public TextField getTextAmount10() {
        return textAmount10;
    }
    private TextField textAmount20 = new TextField("0");
    public TextField getTextAmount20() {
        return textAmount20;
    }
    private TextField textAmount50 = new TextField("0");
    public TextField getTextAmount50() {
        return textAmount50;
    }
    private TextField textAmount100 = new TextField("0");
    public TextField getTextAmount100() {
        return textAmount100;
    }
    private TextField textAmount200 = new TextField("0");
    public TextField getTextAmount200() {
        return textAmount200;
    }
    private TextField textAmount500 = new TextField("0");
    public TextField getTextAmount500() {
        return textAmount500;
    }
    private TextField textAmount1000 = new TextField("0");
    public TextField getTextAmount1000() {
        return textAmount1000;
    }
    
    private Button btnConfirmPayItem = new Button();
    public Button getBtnConfirmPayItem() {
        return btnConfirmPayItem;
    }

    public ImageView makeButtonImg(String name, double size) {
        Image image = new Image("file:" + name + ".png");
        ImageView view = new ImageView(image);
        view.setFitWidth(size);
        view.setPreserveRatio(true);

        return view;
    }

    public Scene makeWelcomeUser() {
        GridPane paneWelcomeUser = new GridPane();

        Image imgWelcomeUser = new Image("file:WelcomeUser.png");
        ImageView viewWelcomeUser = new ImageView(imgWelcomeUser);
        viewWelcomeUser.setFitWidth(500);
        viewWelcomeUser.setPreserveRatio(true);

        Button btnCreateVM = new Button();
        btnCreateVM.setPrefSize(300, 213); //0.71
        btnCreateVM.setGraphic(makeButtonImg("CreateVM", 300));
        btnCreateVM.setOnAction(e -> stage.setScene(makeCreateMachine()));

        btnTestVM.setPrefSize(300, 213);
        btnTestVM.setGraphic(makeButtonImg("TestVM", 300));
        
        paneWelcomeUser.add(viewWelcomeUser, 0, 0, 2, 1);
        paneWelcomeUser.add(btnCreateVM, 0, 1);
        paneWelcomeUser.add(btnTestVM, 1, 1);
        paneWelcomeUser.setVgap(50);
        paneWelcomeUser.setHgap(30);
        paneWelcomeUser.setPadding(new Insets(20));
        GridPane.setHalignment(viewWelcomeUser, HPos.CENTER);

        paneWelcomeUser.setStyle("-fx-background-color: #FFFFFF");
        Scene sceneWelcomeUser = new Scene(paneWelcomeUser);
        return sceneWelcomeUser;
    }

    public Scene makeCreateMachine() {
        GridPane paneCreateMachine = new GridPane();

        Image imgCreateMachine = new Image("file:CreateMachine.png");
        ImageView viewCreateMachine = new ImageView(imgCreateMachine);
        viewCreateMachine.setFitWidth(500);
        viewCreateMachine.setPreserveRatio(true);

        Button btnRegVM = new Button();
        btnRegVM.setPrefSize(300, 213); //0.71
        btnRegVM.setGraphic(makeButtonImg("RegularVM", 300));
        btnRegVM.setOnAction(e -> stage.setScene(makeCreateRegularVM()));

        Button btnSpecialVM = new Button();
        btnSpecialVM.setPrefSize(300, 213);
        btnSpecialVM.setGraphic(makeButtonImg("SpecialVM", 300));
        btnSpecialVM.setOnAction(e -> stage.setScene(makeCreateZhajiangmianVM()));

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeWelcomeUser()));
    
        paneCreateMachine.add(viewCreateMachine, 0, 0, 2, 1);
        paneCreateMachine.add(btnRegVM, 0, 1);
        paneCreateMachine.add(btnSpecialVM, 1, 1);
        paneCreateMachine.add(btnBack, 2, 2);
        paneCreateMachine.setVgap(50);
        paneCreateMachine.setHgap(30);
        paneCreateMachine.setPadding(new Insets(20));
        GridPane.setHalignment(viewCreateMachine, HPos.CENTER);
        paneCreateMachine.setStyle("-fx-background-color: #FFFFFF");

        Scene scenePurchaseMachine = new Scene(paneCreateMachine);
        return scenePurchaseMachine;
    }
    
    public Scene makeMyCreatedVM() {
        GridPane paneMyCreatedVM = new GridPane();

        Image imgMyCreatedVM = new Image("file:MyCreatedVM.png");
        ImageView viewMyCreatedVM = new ImageView(imgMyCreatedVM);
        viewMyCreatedVM.setFitWidth(500);
        viewMyCreatedVM.setPreserveRatio(true);

        btnPurchaseItem.setPrefSize(300, 213); //0.71
        btnPurchaseItem.setGraphic(makeButtonImg("PurchaseItem", 300));
        
        Button btnMaintenanceVM = new Button();
        btnMaintenanceVM.setPrefSize(300, 213);
        btnMaintenanceVM.setGraphic(makeButtonImg("MaintenanceVM", 300));
        btnMaintenanceVM.setOnAction(e -> stage.setScene(makeMyVMMaintenance()));

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeWelcomeUser()));

        paneMyCreatedVM.add(viewMyCreatedVM, 0, 0, 3, 1);
        paneMyCreatedVM.add(btnPurchaseItem, 0, 1);
        paneMyCreatedVM.add(btnMaintenanceVM, 1, 1);
        paneMyCreatedVM.add(btnBack, 2, 2);
        paneMyCreatedVM.setVgap(50);
        paneMyCreatedVM.setHgap(30);
        paneMyCreatedVM.setPadding(new Insets(20));
        GridPane.setHalignment(btnBack, HPos.RIGHT);
        GridPane.setHalignment(viewMyCreatedVM, HPos.CENTER);
        paneMyCreatedVM.setStyle("-fx-background-color: #FFFFFF");

        Scene sceneMyCreatedVM = new Scene(paneMyCreatedVM);
        return sceneMyCreatedVM;
    }

    public Scene makeMyVMInfo() {
        GridPane paneMyVMInfo = new GridPane();

        Image imgMyVMInfo = new Image("file:MyVMInfo.png");
        ImageView viewMyVMInfo = new ImageView(imgMyVMInfo);
        viewMyVMInfo.setFitWidth(500);
        viewMyVMInfo.setPreserveRatio(true);

        Image imgProductName = new Image("file:ProductName.png");
        ImageView viewProductName = new ImageView(imgProductName);
        viewProductName.setFitHeight(35);
        viewProductName.setPreserveRatio(true);

        Image imgStock = new Image("file:Stock.png");
        ImageView viewStock = new ImageView(imgStock);
        viewStock.setFitHeight(35);
        viewStock.setPreserveRatio(true);

        Image imgPrice = new Image("file:Price.png");
        ImageView viewPrice = new ImageView(imgPrice);
        viewPrice.setFitHeight(35);
        viewPrice.setPreserveRatio(true);

        Label divider = new Label("|");

        Image imgMoneyType = new Image("file:MoneyType.png");
        ImageView viewMoneyType = new ImageView(imgMoneyType);
        viewMoneyType.setFitHeight(35);
        viewMoneyType.setPreserveRatio(true);

        Image imgQuantity = new Image("file:Quantity.png");
        ImageView viewQuantity = new ImageView(imgQuantity);
        viewQuantity.setFitHeight(35);
        viewQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyCreatedVM()));

        paneMyVMInfo.add(viewMyVMInfo, 0, 0, 6, 1);
        paneMyVMInfo.add(viewProductName, 0, 1);
        paneMyVMInfo.add(viewStock, 1, 1);
        paneMyVMInfo.add(viewPrice, 2, 1);
        paneMyVMInfo.add(divider, 3, 1);
        paneMyVMInfo.add(viewMoneyType, 4, 1);
        paneMyVMInfo.add(viewQuantity, 5, 1);
        paneMyVMInfo.add(btnBack, 5, 2);
        paneMyVMInfo.setVgap(50);
        paneMyVMInfo.setHgap(30);
        paneMyVMInfo.setPadding(new Insets(20));
        GridPane.setHalignment(btnBack, HPos.RIGHT);
        GridPane.setHalignment(viewMyVMInfo, HPos.CENTER);
        paneMyVMInfo.setStyle("-fx-background-color: #FFFFFF");

        Scene sceneMyVMInfo = new Scene(paneMyVMInfo);
        return sceneMyVMInfo;
    }

    public Scene makeMyVMMaintenance() {
        GridPane paneMyVMMaintenance = new GridPane();

        Image imgMyVMMaintenance = new Image("file:MyVMMaintenance.png");
        ImageView viewMyVMMaintenance = new ImageView(imgMyVMMaintenance);
        viewMyVMMaintenance.setFitWidth(500);
        viewMyVMMaintenance.setPreserveRatio(true);

        btnRestockProductQty.setPrefSize(300, 213); //0.71
        btnRestockProductQty.setGraphic(makeButtonImg("RestockProductQty", 300));

        btnReplenishCashReg.setPrefSize(300, 213);
        btnReplenishCashReg.setGraphic(makeButtonImg("ReplenishCashReg", 300));
        
        btnInventoryInfo.setPrefSize(300, 213);
        btnInventoryInfo.setGraphic(makeButtonImg("InventoryInfo", 300));

        btnReassignSlot.setPrefSize(300, 213);
        btnReassignSlot.setGraphic(makeButtonImg("ReassignSlot", 300));

        btnRepriceItem.setPrefSize(300, 213);
        btnRepriceItem.setGraphic(makeButtonImg("RepriceItem", 300));

        Button btnCollectMoney = new Button();
        btnCollectMoney.setPrefSize(300, 213);
        btnCollectMoney.setGraphic(makeButtonImg("CollectMoney", 300));
        btnCollectMoney.setOnAction(e -> stage.setScene(makeMyVMCollectMoney()));

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyCreatedVM()));
        
        paneMyVMMaintenance.add(viewMyVMMaintenance, 0, 0, 2, 1);
        paneMyVMMaintenance.add(btnRestockProductQty, 0, 1);
        paneMyVMMaintenance.add(btnReplenishCashReg, 1, 1);
        paneMyVMMaintenance.add(btnInventoryInfo, 0, 2);
        paneMyVMMaintenance.add(btnReassignSlot, 1, 2);
        paneMyVMMaintenance.add(btnRepriceItem, 2, 1);
        paneMyVMMaintenance.add(btnCollectMoney, 2, 2);
        paneMyVMMaintenance.add(btnBack, 2, 3);
        paneMyVMMaintenance.setVgap(50);
        paneMyVMMaintenance.setHgap(30);
        paneMyVMMaintenance.setPadding(new Insets(20));
        GridPane.setHalignment(viewMyVMMaintenance, HPos.CENTER);
        GridPane.setHalignment(btnBack, HPos.RIGHT);
        paneMyVMMaintenance.setStyle("-fx-background-color: #FFFFFF");

        Scene sceneMyVMMaintenance = new Scene(paneMyVMMaintenance);
        return sceneMyVMMaintenance;
    }

    public Scene makeMyVMRestockSlot() {
        GridPane paneMyRestockSlot = new GridPane();

        Image imgMyVMRestockSlot = new Image("file:MyVMRestockSlot.png");
        ImageView viewMyVMRestockSlot = new ImageView(imgMyVMRestockSlot);
        viewMyVMRestockSlot.setFitWidth(500);
        viewMyVMRestockSlot.setPreserveRatio(true);

        Image imgSlotNumber = new Image("file:SlotNumber.png");
        ImageView viewSlotNumber = new ImageView(imgSlotNumber);
        viewSlotNumber.setFitHeight(50);
        viewSlotNumber.setPreserveRatio(true);

        Image imgQuantityBig = new Image("file:QuantityBig.png");
        ImageView viewQuantityBig = new ImageView(imgQuantityBig);
        viewQuantityBig.setFitHeight(50);
        viewQuantityBig.setPreserveRatio(true);

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
    
        btnConfirmRestockSlot.setPrefSize(125, 50);
        btnConfirmRestockSlot.setGraphic(viewConfirm);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);

        btnBackRestockSlot.setPrefSize(50, 36);
        btnBackRestockSlot.setGraphic(viewBack);

        paneMyRestockSlot.add(viewMyVMRestockSlot, 0, 0, 3, 1);
        paneMyRestockSlot.add(viewSlotNumber, 0, 1);
        paneMyRestockSlot.add(choiceSlotNumber, 1, 1);
        paneMyRestockSlot.add(viewQuantityBig, 0, 2);
        paneMyRestockSlot.add(textQuantity, 1, 2);
        paneMyRestockSlot.add(btnConfirmRestockSlot, 0, 3, 3, 1);
        paneMyRestockSlot.add(btnBackRestockSlot, 2, 4);
        paneMyRestockSlot.setVgap(50);
        paneMyRestockSlot.setHgap(30);
        paneMyRestockSlot.setPadding(new Insets(20));
        GridPane.setHalignment(viewMyVMRestockSlot, HPos.CENTER);
        GridPane.setHalignment(btnConfirmRestockSlot, HPos.CENTER);
        paneMyRestockSlot.setStyle("-fx-background-color: #FFFFFF");

        Scene sceneMyVMRestockSlot = new Scene(paneMyRestockSlot);
        return sceneMyVMRestockSlot;
    }

    public Scene makeMyVMRepriceItem() {
        GridPane paneMyVMRepriceItem = new GridPane();

        Image imgMyVMRepriceItem = new Image("file:MyVMRepriceItem.png");
        ImageView viewMyVMRepriceItem = new ImageView(imgMyVMRepriceItem);
        viewMyVMRepriceItem.setFitWidth(500);
        viewMyVMRepriceItem.setPreserveRatio(true);

        Image imgSlotNumber = new Image("file:SlotNumber.png");
        ImageView viewSlotNumber = new ImageView(imgSlotNumber);
        viewSlotNumber.setFitHeight(50);
        viewSlotNumber.setPreserveRatio(true);

        Image imgPriceBig = new Image("file:PriceBig.png");
        ImageView viewPriceBig = new ImageView(imgPriceBig);
        viewPriceBig.setFitHeight(50);
        viewPriceBig.setPreserveRatio(true);

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmRepriceItem.setPrefSize(125, 50);
        btnConfirmRepriceItem.setGraphic(viewConfirm);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        btnBackRepriceItem.setPrefSize(50, 36);
        btnBackRepriceItem.setGraphic(viewBack);
        btnBackRepriceItem.setOnAction(e -> stage.setScene(makeMyVMMaintenance()));

        paneMyVMRepriceItem.add(viewMyVMRepriceItem, 0, 0, 3, 1);
        paneMyVMRepriceItem.add(viewSlotNumber, 0, 1);
        paneMyVMRepriceItem.add(choiceSlotNumber, 1, 1);
        paneMyVMRepriceItem.add(viewPriceBig, 0, 2);
        paneMyVMRepriceItem.add(textPrice, 1, 2);
        paneMyVMRepriceItem.add(btnConfirmRepriceItem, 0, 3, 3, 1);
        paneMyVMRepriceItem.add(btnBackRepriceItem, 2, 4);
        paneMyVMRepriceItem.setVgap(50);
        paneMyVMRepriceItem.setHgap(30);
        paneMyVMRepriceItem.setPadding(new Insets(20));
        GridPane.setHalignment(viewMyVMRepriceItem, HPos.CENTER);
        GridPane.setHalignment(btnConfirmRepriceItem, HPos.CENTER);
        paneMyVMRepriceItem.setStyle("-fx-background-color: #FFFFFF");

        Scene sceneMyVMRepriceItem = new Scene(paneMyVMRepriceItem);
        return sceneMyVMRepriceItem;
    }

    public Scene makeMyVMReassignSlot() {
        GridPane paneMyVMReassignSlot = new GridPane();

        Image imgMyVMReassignSlot = new Image("file:MyVMReassignSlot.png");
        ImageView viewMyVMReassignSlot = new ImageView(imgMyVMReassignSlot);
        viewMyVMReassignSlot.setFitWidth(500);
        viewMyVMReassignSlot.setPreserveRatio(true);

        Image imgSlotNumber = new Image("file:SlotNumber.png");
        ImageView viewSlotNumber = new ImageView(imgSlotNumber);
        viewSlotNumber.setFitHeight(50);
        viewSlotNumber.setPreserveRatio(true);

        Image imgItem = new Image("file:Item.png");
        ImageView viewItem = new ImageView(imgItem);
        viewItem.setFitHeight(50);
        viewItem.setPreserveRatio(true);

        Image imgCreateNewItem = new Image("file:CreateNewItem.png");
        ImageView viewCreateNewItem = new ImageView(imgCreateNewItem);
        viewCreateNewItem.setFitHeight(50);
        viewCreateNewItem.setPreserveRatio(true);
        btnCreateNewItem.setPrefSize(214, 50);
        btnCreateNewItem.setGraphic(viewCreateNewItem);

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmReassignSlot.setPrefSize(125, 50);
        btnConfirmReassignSlot.setGraphic(viewConfirm);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        
        btnBackReassignSlot.setPrefSize(50, 36);
        btnBackReassignSlot.setGraphic(viewBack);
        
        paneMyVMReassignSlot.add(viewMyVMReassignSlot, 0, 0, 3, 1);
        paneMyVMReassignSlot.add(viewSlotNumber, 0, 1);
        paneMyVMReassignSlot.add(choiceSlotNumber, 1, 1);
        paneMyVMReassignSlot.add(viewItem, 0, 2);
        paneMyVMReassignSlot.add(choiceItem, 1, 2);
        paneMyVMReassignSlot.add(btnCreateNewItem, 0, 3, 3, 1);
        paneMyVMReassignSlot.add(btnConfirmReassignSlot, 1, 4);
        paneMyVMReassignSlot.add(btnBackReassignSlot, 2, 4);
        paneMyVMReassignSlot.setVgap(50);
        paneMyVMReassignSlot.setHgap(30);
        paneMyVMReassignSlot.setPadding(new Insets(20));
        paneMyVMReassignSlot.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReassignSlot, HPos.CENTER);
        GridPane.setHalignment(btnCreateNewItem, HPos.CENTER);

        Scene sceneMyVMReassignSlot = new Scene(paneMyVMReassignSlot);
        return sceneMyVMReassignSlot;
    }

    public Scene makeRegSlotCreateNewItem() {
        GridPane paneRegSlotCreateNewItem = new GridPane();

        Image imgRegSlotCreateNewItem = new Image("file:SlotCreateNewItem.png");
        ImageView viewRegSlotCreateNewItem = new ImageView(imgRegSlotCreateNewItem);
        viewRegSlotCreateNewItem.setFitWidth(500);
        viewRegSlotCreateNewItem.setPreserveRatio(true);

        Image imgItemName = new Image("file:ItemName.png");
        ImageView viewItemName = new ImageView(imgItemName);
        viewItemName.setFitHeight(50);
        viewItemName.setPreserveRatio(true);

        Image imgPrice = new Image("file:PriceBig.png");
        ImageView viewPrice = new ImageView(imgPrice);
        viewPrice.setFitHeight(50);
        viewPrice.setPreserveRatio(true);

        Image imgItemCalories = new Image("file:ItemCalories.png");
        ImageView viewItemCalories = new ImageView(imgItemCalories);
        viewItemCalories.setFitHeight(50);
        viewItemCalories.setPreserveRatio(true);

        Image imgRegSelectItemPicture = new Image("file:SelectItemPicture.png");
        ImageView viewRegSelectItemPicture = new ImageView(imgRegSelectItemPicture);
        viewRegSelectItemPicture.setFitHeight(50);
        viewRegSelectItemPicture.setPreserveRatio(true);
        btnRegSelectItemPicture.setPrefSize(370, 50);
        btnRegSelectItemPicture.setGraphic(viewRegSelectItemPicture);

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmRegCreateNewItem.setPrefSize(125, 50);
        btnConfirmRegCreateNewItem.setGraphic(viewConfirm);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        btnBackRegCreateNewItem.setPrefSize(50, 36);
        btnBackRegCreateNewItem.setGraphic(viewBack);

        paneRegSlotCreateNewItem.add(viewRegSlotCreateNewItem, 0, 0, 3, 1);
        paneRegSlotCreateNewItem.add(viewItemName, 0, 1);
        paneRegSlotCreateNewItem.add(textNameRegSlotCreateNewItem, 1, 1);
        paneRegSlotCreateNewItem.add(viewPrice, 0, 2);
        paneRegSlotCreateNewItem.add(textPriceRegSlotCreateNewItem, 1, 2);
        paneRegSlotCreateNewItem.add(viewItemCalories, 0, 3);
        paneRegSlotCreateNewItem.add(textCaloriesRegSlotCreateNewItem, 1, 3);
        paneRegSlotCreateNewItem.add(btnRegSelectItemPicture, 0, 4, 3, 1);
        paneRegSlotCreateNewItem.add(btnConfirmRegCreateNewItem, 0, 5, 3, 1);
        paneRegSlotCreateNewItem.add(btnBackRegCreateNewItem, 2, 6);
        paneRegSlotCreateNewItem.setVgap(50);
        paneRegSlotCreateNewItem.setHgap(30);
        paneRegSlotCreateNewItem.setPadding(new Insets(20));
        paneRegSlotCreateNewItem.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewRegSlotCreateNewItem, HPos.CENTER);
        GridPane.setHalignment(btnRegSelectItemPicture, HPos.CENTER);
        GridPane.setHalignment(btnConfirmRegCreateNewItem, HPos.CENTER);

        Scene sceneRegSlotCreateNewItem = new Scene(paneRegSlotCreateNewItem);
        return sceneRegSlotCreateNewItem;
    }

    public Scene makeMyVMReplenishCashReg() {
        GridPane paneMyVMReplenishCashReg = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgSelectMoneyType = new Image("file:SelectMoneyType.png");
        ImageView viewSelectMoneyType = new ImageView(imgSelectMoneyType);
        viewSelectMoneyType.setFitHeight(50);
        viewSelectMoneyType.setPreserveRatio(true);

        Image img1 = new Image("file:1.png");
        ImageView view1 = new ImageView(img1);
        view1.setFitWidth(70);
        view1.setPreserveRatio(true);
        Button btn1 = new Button();
        btn1.setPrefSize(70, 70);
        btn1.setGraphic(view1);
        btn1.setOnAction(e -> stage.setScene(makeEnterQuantity1()));

        Image img5 = new Image("file:5.png");
        ImageView view5 = new ImageView(img5);
        view5.setFitWidth(70);
        view5.setPreserveRatio(true);
        Button btn5 = new Button();
        btn5.setPrefSize(70, 70);
        btn5.setGraphic(view5);
        btn5.setOnAction(e -> stage.setScene(makeEnterQuantity5()));

        Image img10 = new Image("file:10.png");
        ImageView view10 = new ImageView(img10);
        view10.setFitWidth(70);
        view10.setPreserveRatio(true);
        Button btn10 = new Button();
        btn10.setPrefSize(70, 70);
        btn10.setGraphic(view10);
        btn10.setOnAction(e -> stage.setScene(makeEnterQuantity10()));

        Image img20 = new Image("file:20.png");
        ImageView view20 = new ImageView(img20);
        view20.setFitWidth(70);
        view20.setPreserveRatio(true);
        Button btn20 = new Button();
        btn20.setPrefSize(70, 70);
        btn20.setGraphic(view20);
        btn20.setOnAction(e -> stage.setScene(makeEnterQuantity20()));

        Image img50 = new Image("file:50.png");
        ImageView view50 = new ImageView(img50);
        view50.setFitHeight(70);
        view50.setPreserveRatio(true);
        Button btn50 = new Button();
        btn50.setPrefSize(104, 70);
        btn50.setGraphic(view50);
        btn50.setOnAction(e -> stage.setScene(makeEnterQuantity50()));

        Image img100 = new Image("file:100.png");
        ImageView view100 = new ImageView(img100);
        view100.setFitHeight(70);
        view100.setPreserveRatio(true);
        Button btn100 = new Button();
        btn100.setPrefSize(104, 70);
        btn100.setGraphic(view100);
        btn100.setOnAction(e -> stage.setScene(makeEnterQuantity100()));

        Image img200 = new Image("file:200.png");
        ImageView view200 = new ImageView(img200);
        view200.setFitHeight(70);
        view200.setPreserveRatio(true);
        Button btn200 = new Button();
        btn200.setPrefSize(104, 70);
        btn200.setGraphic(view200);
        btn200.setOnAction(e -> stage.setScene(makeEnterQuantity200()));

        Image img500 = new Image("file:500.png");
        ImageView view500 = new ImageView(img500);
        view500.setFitHeight(70);
        view500.setPreserveRatio(true);
        Button btn500 = new Button();
        btn500.setPrefSize(104, 70);
        btn500.setGraphic(view500);
        btn500.setOnAction(e -> stage.setScene(makeEnterQuantity500()));

        Image img1000 = new Image("file:1000.png");
        ImageView view1000 = new ImageView(img1000);
        view1000.setFitHeight(70);
        view1000.setPreserveRatio(true);
        Button btn1000 = new Button();
        btn1000.setPrefSize(104, 70);
        btn1000.setGraphic(view1000);
        btn1000.setOnAction(e -> stage.setScene(makeEnterQuantity1000()));

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMMaintenance()));

        paneMyVMReplenishCashReg.add(viewMyVMReplenishCashReg, 0, 0, 5, 1);
        paneMyVMReplenishCashReg.add(viewSelectMoneyType, 0, 1, 5, 1);
        paneMyVMReplenishCashReg.add(textAmountStored, 0, 2, 5, 1);
        paneMyVMReplenishCashReg.add(btn1, 0, 3);
        paneMyVMReplenishCashReg.add(btn5, 1, 3);
        paneMyVMReplenishCashReg.add(btn10, 2, 3);
        paneMyVMReplenishCashReg.add(btn20, 3, 3);
        paneMyVMReplenishCashReg.add(btn50, 4, 3);
        paneMyVMReplenishCashReg.add(btn100, 0, 4);
        paneMyVMReplenishCashReg.add(btn200, 1, 4);
        paneMyVMReplenishCashReg.add(btn500, 2, 4);
        paneMyVMReplenishCashReg.add(btn1000, 3, 4);
        paneMyVMReplenishCashReg.add(btnBack, 5, 5);
        paneMyVMReplenishCashReg.setVgap(50);
        paneMyVMReplenishCashReg.setHgap(30);
        paneMyVMReplenishCashReg.setPadding(new Insets(20));
        paneMyVMReplenishCashReg.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(viewSelectMoneyType, HPos.CENTER);
        GridPane.setHalignment(textAmountStored, HPos.CENTER);

        Scene sceneMyVMReplenishCashReg = new Scene(paneMyVMReplenishCashReg);
        return sceneMyVMReplenishCashReg;
    }

    public Scene makeEnterQuantity1() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);

        btnConfirmEnterQuantity1.setPrefSize(125, 50);
        btnConfirmEnterQuantity1.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity1, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity1, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity1, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity5() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity5.setPrefSize(125, 50);
        btnConfirmEnterQuantity5.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity5, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity5, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity5, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity10() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity10.setPrefSize(125, 50);
        btnConfirmEnterQuantity10.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity10, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity10, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity10, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity20() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity20.setPrefSize(125, 50);
        btnConfirmEnterQuantity20.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity20, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity20, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity20, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity50() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity50.setPrefSize(125, 50);
        btnConfirmEnterQuantity50.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity50, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity50, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity50, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity100() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity100.setPrefSize(125, 50);
        btnConfirmEnterQuantity100.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity100, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity100, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity100, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity200() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity200.setPrefSize(125, 50);
        btnConfirmEnterQuantity200.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity200, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity200, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity200, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity500() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity500.setPrefSize(125, 50);
        btnConfirmEnterQuantity500.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity500, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity500, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity500, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeEnterQuantity1000() {
        GridPane paneEnterQuantity = new GridPane();

        Image imgMyVMReplenishCashReg = new Image("file:MvVMReplenishCashReg.png");
        ImageView viewMyVMReplenishCashReg = new ImageView(imgMyVMReplenishCashReg);
        viewMyVMReplenishCashReg.setFitWidth(500);
        viewMyVMReplenishCashReg.setPreserveRatio(true);

        Image imgEnterQuantity = new Image("file:EnterQuantity.png");
        ImageView viewEnterQuantity = new ImageView(imgEnterQuantity);
        viewEnterQuantity.setFitHeight(50);
        viewEnterQuantity.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMReplenishCashReg()));

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmEnterQuantity1000.setPrefSize(125, 50);
        btnConfirmEnterQuantity1000.setGraphic(viewConfirm);

        paneEnterQuantity.add(viewMyVMReplenishCashReg, 0, 0, 2, 1);
        paneEnterQuantity.add(viewEnterQuantity, 0, 1);
        paneEnterQuantity.add(textEnterQuantity1000, 1, 1);
        paneEnterQuantity.add(btnConfirmEnterQuantity1000, 0, 2, 2, 1);
        paneEnterQuantity.add(btnBack, 2, 3);
        paneEnterQuantity.setVgap(50);
        paneEnterQuantity.setHgap(30);
        paneEnterQuantity.setPadding(new Insets(20));
        paneEnterQuantity.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMReplenishCashReg, HPos.CENTER);
        GridPane.setHalignment(btnConfirmEnterQuantity1000, HPos.CENTER);

        Scene sceneEnterQuantity = new Scene(paneEnterQuantity);
        return sceneEnterQuantity;
    }

    public Scene makeMyVMInventory() {
        GridPane paneMyVMInventory = new GridPane();

        Image imgMyVMInventory = new Image("file:MyVMInventory.png");
        ImageView viewMyVMInventory = new ImageView(imgMyVMInventory);
        viewMyVMInventory.setFitWidth(500);
        viewMyVMInventory.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMMaintenance()));

        paneMyVMInventory.add(viewMyVMInventory, 0, 0, 1, 1);
        paneMyVMInventory.add(textInventoryInfo, 0, 1);
        paneMyVMInventory.add(btnBack, 1, 2);
        paneMyVMInventory.setVgap(50);
        paneMyVMInventory.setHgap(30);
        paneMyVMInventory.setPadding(new Insets(20));
        paneMyVMInventory.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMInventory, HPos.CENTER);

        Scene sceneMyVMInventory = new Scene(paneMyVMInventory);
        return sceneMyVMInventory;
    }

    public Scene makeCreateRegularVM() {
        GridPane paneCreateRegularVM = new GridPane();

        Image imgCreateRegularVM = new Image("file:CreateRegularVM.png");
        ImageView viewCreateRegularVM = new ImageView(imgCreateRegularVM);
        viewCreateRegularVM.setFitWidth(500);
        viewCreateRegularVM.setPreserveRatio(true);

        Image imgNumberOfSlots = new Image("file:NumberOfSlots.png");
        ImageView viewNumberOfSlots = new ImageView(imgNumberOfSlots);
        viewNumberOfSlots.setFitHeight(50);
        viewNumberOfSlots.setPreserveRatio(true);

        Image imgSlotCapacity = new Image("file:SlotCapacity.png");
        ImageView viewSlotCapacity = new ImageView(imgSlotCapacity);
        viewSlotCapacity.setFitHeight(50);
        viewSlotCapacity.setPreserveRatio(true);

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmCreateRegVM.setPrefSize(125, 50);
        btnConfirmCreateRegVM.setGraphic(viewConfirm);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeCreateMachine()));

        paneCreateRegularVM.add(viewCreateRegularVM, 0, 0, 3, 1);
        paneCreateRegularVM.add(viewNumberOfSlots, 0, 1);
        paneCreateRegularVM.add(textRegVMNoOfSlots, 1, 1);
        paneCreateRegularVM.add(viewSlotCapacity, 0, 2);
        paneCreateRegularVM.add(textRegVMSlotCapacity, 1, 2);
        paneCreateRegularVM.add(btnConfirmCreateRegVM, 0, 3, 3, 1);
        paneCreateRegularVM.add(btnBack, 2, 4);
        paneCreateRegularVM.setVgap(50);
        paneCreateRegularVM.setHgap(30);
        paneCreateRegularVM.setPadding(new Insets(20));
        paneCreateRegularVM.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewCreateRegularVM, HPos.CENTER);
        GridPane.setHalignment(btnConfirmCreateRegVM, HPos.CENTER);

        Scene sceneCreateRegularVM = new Scene(paneCreateRegularVM);
        return sceneCreateRegularVM;
    }

    public Scene makeCreateZhajiangmianVM() {
        GridPane paneCreateZhajiangmianVM = new GridPane();

        Image imgCreateZhajiangmianVM = new Image("file:CreateZhajiangmianVM.png");
        ImageView viewCreateZhajiangmianVM = new ImageView(imgCreateZhajiangmianVM);
        viewCreateZhajiangmianVM.setFitWidth(500);
        viewCreateZhajiangmianVM.setPreserveRatio(true);

        Image imgNumberOfSlots = new Image("file:NumberOfSlots.png");
        ImageView viewNumberOfSlots = new ImageView(imgNumberOfSlots);
        viewNumberOfSlots.setFitHeight(50);
        viewNumberOfSlots.setPreserveRatio(true);

        Image imgSlotCapacity = new Image("file:SlotCapacity.png");
        ImageView viewSlotCapacity = new ImageView(imgSlotCapacity);
        viewSlotCapacity.setFitHeight(50);
        viewSlotCapacity.setPreserveRatio(true);

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmSpecialVM.setPrefSize(125, 50);
        btnConfirmSpecialVM.setGraphic(viewConfirm);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeCreateMachine()));

        paneCreateZhajiangmianVM.add(viewCreateZhajiangmianVM, 0, 0, 3, 1);
        paneCreateZhajiangmianVM.add(viewNumberOfSlots, 0, 1);
        paneCreateZhajiangmianVM.add(textSpecialVMNoOfSlots, 1, 1);
        paneCreateZhajiangmianVM.add(viewSlotCapacity, 0, 2);
        paneCreateZhajiangmianVM.add(textSpecialVMSlotCapacity, 1, 2);
        paneCreateZhajiangmianVM.add(btnConfirmSpecialVM, 0, 3, 3, 1);
        paneCreateZhajiangmianVM.add(btnBack, 2, 4);
        paneCreateZhajiangmianVM.setVgap(50);
        paneCreateZhajiangmianVM.setHgap(30);
        paneCreateZhajiangmianVM.setPadding(new Insets(20));
        paneCreateZhajiangmianVM.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewCreateZhajiangmianVM, HPos.CENTER);
        GridPane.setHalignment(btnConfirmSpecialVM, HPos.CENTER);

        Scene sceneCreateZhajiangmianVM = new Scene(paneCreateZhajiangmianVM);
        return sceneCreateZhajiangmianVM;
    }

    public Scene makeMyVMCollectMoney() {
        GridPane paneMyVMCollectMoney = new GridPane();

        Image imgMyVMCollectMoney = new Image("file:MyVMCollectMoney.png");
        ImageView viewMyVMCollectMoney = new ImageView(imgMyVMCollectMoney);
        viewMyVMCollectMoney.setFitWidth(500);
        viewMyVMCollectMoney.setPreserveRatio(true);

        Image imgAmount = new Image("file:Amount.png");
        ImageView viewAmount = new ImageView(imgAmount);
        viewAmount.setFitHeight(50);
        viewAmount.setPreserveRatio(true);

        Image imgCollectSpecified = new Image("file:CollectSpecified.png");
        ImageView viewCollectSpecified = new ImageView(imgCollectSpecified);
        viewAmount.setFitHeight(50);
        viewAmount.setPreserveRatio(true);
        btnCollectSpecified.setPrefSize(330, 50);
        btnCollectSpecified.setGraphic(viewCollectSpecified);

        Image imgCollectAll = new Image("file:CollectAll.png");
        ImageView viewCollectAll = new ImageView(imgCollectAll);
        viewCollectAll.setFitHeight(50);
        viewCollectAll.setPreserveRatio(true);
        btnCollectAll.setPrefSize(201, 50);
        btnCollectAll.setGraphic(viewCollectAll);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyVMMaintenance()));

        paneMyVMCollectMoney.add(viewMyVMCollectMoney, 0, 0, 2, 1);
        paneMyVMCollectMoney.add(viewAmount, 0, 1);
        paneMyVMCollectMoney.add(textAmount, 1, 1);
        paneMyVMCollectMoney.add(btnCollectSpecified, 0, 2, 2, 1);
        paneMyVMCollectMoney.add(btnCollectAll, 0, 3, 2, 1);
        paneMyVMCollectMoney.add(btnBack, 4, 3);
        paneMyVMCollectMoney.setVgap(50);
        paneMyVMCollectMoney.setHgap(30);
        paneMyVMCollectMoney.setPadding(new Insets(20));
        paneMyVMCollectMoney.setStyle("-fx-background-color: #FFFFFF");
        GridPane.setHalignment(viewMyVMCollectMoney, HPos.CENTER);
        GridPane.setHalignment(btnCollectSpecified, HPos.CENTER);
        GridPane.setHalignment(btnCollectAll, HPos.CENTER);

        Scene sceneMyVMCollectMoney = new Scene(paneMyVMCollectMoney);
        return sceneMyVMCollectMoney;
    }

    public Scene makeMyRegVMPurchaseAnItem() {
        GridPane paneMyRegVMPurchaseAnItem = new GridPane();

        Image imgMyRegVMPurchaseAnItem = new Image("file:MyVMPurchaseAnItem.png");
        ImageView viewMyRegVMPurchaseAnItem = new ImageView(imgMyRegVMPurchaseAnItem);
        viewMyRegVMPurchaseAnItem.setFitWidth(500);
        viewMyRegVMPurchaseAnItem.setPreserveRatio(true);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyCreatedVM()));
        
        for(int i = 0; i <= 14; i++) {
            regVMPurchaseButtons.get(i).setPrefSize(70, 70);
            regVMPurchaseButtons.get(i).setVisible(false);
        }
        
        paneMyRegVMPurchaseAnItem.add(viewMyRegVMPurchaseAnItem, 0, 0, 5, 1);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(0), 0, 1);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(1), 1, 1);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(2), 2, 1);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(3), 3, 1);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(4), 4, 1);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(5), 0, 2);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(6), 1, 2);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(7), 2, 2);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(8), 3, 2);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(9), 4, 2);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(10), 0, 3);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(11), 1, 3);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(12), 2, 3);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(13), 3, 3);
        paneMyRegVMPurchaseAnItem.add(regVMPurchaseButtons.get(14), 4, 3);

        paneMyRegVMPurchaseAnItem.setVgap(50);
        paneMyRegVMPurchaseAnItem.setHgap(30);
        paneMyRegVMPurchaseAnItem.setPadding(new Insets(20));
        paneMyRegVMPurchaseAnItem.setStyle("-fx-background-color: #FFFFFF");
        int noOfSlots = Integer.parseInt(textRegVMNoOfSlots.getText());
        for(int i = 0; i <= noOfSlots - 1; i++) {
            regVMPurchaseButtons.get(i).setVisible(true);
        }

        paneMyRegVMPurchaseAnItem.add(btnBack, 5, noOfSlots / 5 + 1);
        
        Scene sceneMyRegVMPurchaseAnItem = new Scene(paneMyRegVMPurchaseAnItem);
        return sceneMyRegVMPurchaseAnItem;
    }

    public Scene makePayItem() {
        GridPane panePayItem = new GridPane();

        Text textPayItemLabel = new Text("Item information: ");
        Text textLabel1 = new Text("Enter amount of 1 peso coins: ");
        Text textLabel5 = new Text("Enter amount of 5 peso coins: ");
        Text textLabel10 = new Text("Enter amount of 10 peso coins: ");
        Text textLabel20 = new Text("Enter amount of 20 peso coins: ");
        Text textLabel50 = new Text("Enter amount of 50 peso bills: ");
        Text textLabel100 = new Text("Enter amount of 100 peso bills: ");
        Text textLabel200 = new Text("Enter amount of 200 peso bills: ");
        Text textLabel500 = new Text("Enter amount of 500 peso bills: ");
        Text textLabel1000 = new Text("Enter amount of 1000 peso bills: ");

        Image imgConfirm = new Image("file:Confirm.png");
        ImageView viewConfirm = new ImageView(imgConfirm);
        viewConfirm.setFitHeight(50);
        viewConfirm.setPreserveRatio(true);
        btnConfirmPayItem.setPrefSize(125, 50);
        btnConfirmPayItem.setGraphic(viewConfirm);

        Image imgBack = new Image("file:Back.png");
        ImageView viewBack = new ImageView(imgBack);
        viewBack.setFitWidth(50);
        viewBack.setPreserveRatio(true);
        Button btnBack = new Button();
        btnBack.setPrefSize(50, 36);
        btnBack.setGraphic(viewBack);
        btnBack.setOnAction(e -> stage.setScene(makeMyRegVMPurchaseAnItem()));

        panePayItem.add(textPayItemLabel, 0, 0);
        panePayItem.add(textPayItemInfo, 1, 0);
        panePayItem.add(textLabel1, 0, 1);
        panePayItem.add(textAmount1, 1, 1);
        panePayItem.add(textLabel5, 0, 2);
        panePayItem.add(textAmount5, 1, 2);
        panePayItem.add(textLabel10, 0, 3);
        panePayItem.add(textAmount10, 1, 3);
        panePayItem.add(textLabel20, 0, 4);
        panePayItem.add(textAmount20, 1, 4);
        panePayItem.add(textLabel50, 0, 5);
        panePayItem.add(textAmount50, 1, 5);
        panePayItem.add(textLabel100, 0, 6);
        panePayItem.add(textAmount100, 1, 6);
        panePayItem.add(textLabel200, 0, 7);
        panePayItem.add(textAmount200, 1, 7);
        panePayItem.add(textLabel500, 0, 8);
        panePayItem.add(textAmount500, 1, 8);
        panePayItem.add(textLabel1000, 0, 9);
        panePayItem.add(textAmount1000, 1, 9);
        panePayItem.add(btnConfirmPayItem, 0, 10);
        panePayItem.add(btnBack, 1, 10);

        panePayItem.setVgap(50);
        panePayItem.setHgap(30);
        panePayItem.setPadding(new Insets(20));
        panePayItem.setStyle("-fx-background-color: #FFFFFF");

        Scene scenePayItem = new Scene(panePayItem);
        return scenePayItem;
    }

    public Stage getStage() {
        return stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}