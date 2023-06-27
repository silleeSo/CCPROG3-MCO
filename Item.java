public class Item {
    private String name;
    private double price;
    private double calorieCount;

    public Item(String name, double price, double calorieCount){
        this.name = name;
        this.price = price;
        this.calorieCount = calorieCount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getCalories() {
        return calorieCount;
    }

    @Override
    public String toString() {
        return name + " - PHP" + price + " - " + calorieCount + " calories";
    }

    public boolean equals(Item item) {
        return item.name == name && item.price == price && item.calorieCount == calorieCount;

    }
}