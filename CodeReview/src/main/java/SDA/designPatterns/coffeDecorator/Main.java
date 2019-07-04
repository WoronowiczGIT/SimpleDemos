package SDA.designPatterns.coffeDecorator;

public class Main {
    public static void main(String[] args) {
        Coffe espresso = new Coffe();

        Decorator addMilk = new MilkDecorator(espresso);
        Decorator addChocolate = new ChocolateDecorator(addMilk);

        System.out.println(espresso.getCost()+ espresso.getDescription());
        System.out.println(addMilk.getCost()+ addMilk.getDescription());
        System.out.println(addChocolate.getCost()+ addChocolate.getDescription());

    }
}
