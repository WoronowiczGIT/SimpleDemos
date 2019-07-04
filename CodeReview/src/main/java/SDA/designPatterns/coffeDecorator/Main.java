package SDA.designPatterns.coffeDecorator;

public class Main {
    public static void main(String[] args) {
        Coffe espresso = new Coffe();

        Decorator additiveOne = new MilkDecorator(espresso);
        Decorator additiveTwo = new ChocolateDecorator(additiveOne);
        Decorator additiveThree = new ChocolateDecorator(additiveTwo);

        System.out.println(espresso.getCost()+ espresso.getDescription());
        System.out.println(additiveOne.getCost()+ additiveOne.getDescription());
        System.out.println(additiveTwo.getCost()+ additiveTwo.getDescription());
        System.out.println(additiveThree.getCost()+ additiveThree.getDescription());

    }
}
