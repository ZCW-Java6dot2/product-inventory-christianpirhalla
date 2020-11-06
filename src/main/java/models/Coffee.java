package models;

public class Coffee {

    private int qty;
    private double price;

    private int size; // in fl oz
    private String drinkType; //regular, latte, iced
    private String flavor; // none, vanilla, caramel, chocolate, pumpkin spice
    private boolean cream;
    private boolean sugar;

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
}
