package SDA.designPatterns.coffeDecorator;

public class Coffe extends Product{
    private double price = 10;
    private String description = " coffe";

    @Override
    public double getCost(){
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
