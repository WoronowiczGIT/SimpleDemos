package SDA.designPatterns.coffeDecorator;

public abstract class Decorator extends Product{

    @Override
    public abstract double getCost();
    public abstract String getDescription();
}
