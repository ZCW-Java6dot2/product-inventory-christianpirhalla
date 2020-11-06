package models;

public class Guitar {

    private int qty;
    private double price;

    private String brand; //fender, gibson, ibanez, peavey
    private int numStrings; //6-8
    private String color; //black, white, red, pink, sunburst
    private boolean hasActivePickups;

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

    public void setBrand(String brnd) {
        this.brand = brnd;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setNumStrings(int i) {
        this.numStrings = i;
    }

    public int getNumStrings() {
        return this.numStrings;
    }

    public void setColor(String col) {
        this.color = col;
    }

    public String getColor() {
        return this.color;
    }

    public void setHasActivePickups(boolean b) {
        this.hasActivePickups = b;
    }

    public Boolean getHasActivePickups() {
        return hasActivePickups;
    }
}
