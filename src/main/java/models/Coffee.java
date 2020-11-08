package models;

public class Coffee {
    private int id;

    private int qty;
    private double price;

    private int size; // in fl oz
    private String drinkType; //regular, latte, iced
    private String flavor; // none, vanilla, caramel, chocolate, pumpkin spice
    private boolean cream;
    private boolean sugar;

    public Coffee(int q, double p, int expSize, String dt, String f, Boolean c, Boolean s) {
        this.qty = q;
        this.price = p;
        this.size = expSize;
        this.drinkType = dt;
        this.flavor = f;
        this.cream = c;
        this.sugar = s;
    }

    public Coffee() {

    }

    public Coffee(int i, int q, double p, int expSize, String dt, String f, Boolean c, Boolean s) {
        this.id = i;
        this.qty = q;
        this.price = p;
        this.size = expSize;
        this.drinkType = dt;
        this.flavor = f;
        this.cream = c;
        this.sugar = s;
    }

    public void setQty(int i) {
        this.qty = i;
    }

    public int getQty() {
        return this.qty;
    }

    public void setPrice(double v) {
        this.price = v;
    }

    public double getPrice() {
        return this.price;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public int getSize() {
        return this.size;
    }

    public void setDrinkType(String drink) {
        this.drinkType = drink;
    }

    public String getDrinkType() {
        return this.drinkType;
    }

    public void setFlavor(String flav) {
        this.flavor = flav;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public void setCream(boolean b) {
        this.cream = b;
    }

    public Boolean getCream() {
        return this.cream;
    }

    public void setSugar(boolean b) {
        this.sugar = b;
    }

    public Boolean getSugar() {
        return this.sugar;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString(){

        return "Coffee: \n" + " | Quantity: " + qty + " | Price: " + price + " | Size: " + size + " | Drink type: " + drinkType
                + " | Flavor: " + flavor + " | Cream: " + cream + " | Sugar: " + sugar;

    }
}
