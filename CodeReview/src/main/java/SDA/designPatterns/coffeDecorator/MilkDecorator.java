package SDA.designPatterns.coffeDecorator;

public class MilkDecorator extends Decorator{
    private Product product;
    private final double price = 2.5;
    private final String desc = " plus milk";

    public MilkDecorator(Product product) {
        this.product = product;
    }

    @Override
    public double getCost() {
        return product.getCost() + price;
    }

    @Override
    public String getDescription() {
        return product.getDescription()+desc;
    }


}
