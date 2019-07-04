package SDA.designPatterns.coffeDecorator;

public class ChocolateDecorator extends Decorator {
    private Product product;
    private final double price = 5.5;
    private final String desc = " plus chocolatte";

    public ChocolateDecorator(Product product) {
        this.product = product;
    }

    @Override
    public double getCost() {
        return product.getCost() + price;
    }

    @Override
    public String getDescription() {
        return product.getDescription()+ desc;
    }


}
