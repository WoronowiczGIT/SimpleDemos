package SDA.designPatterns.wizytator;

public class Laptop implements ItemElement {

    private String name;

    private Integer price;

    public Laptop(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int accept(CartVisitor cartVisitor) {
        return cartVisitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
