package SDA.designPatterns.wizytator;

public class WashingMashine implements ItemElement {

    private String brand;

    private int price;

    public WashingMashine(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public int accept(CartVisitor cartVisitor) {
        return cartVisitor.visit(this);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
