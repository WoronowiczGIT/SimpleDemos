package SDA.designPatterns.wizytator;

public class Test {

    public static void main(String[] args) {
        CartVisitor visitor = new ChristmassCart();
        ItemElement wm = new WashingMashine("Bosh", 3100);
        ItemElement laptop = new Laptop("Lenovo", 4000);

        ItemElement[] cart = {wm,laptop};

        int price = calculatePrice(cart,visitor);

        System.out.println(price);

    }

    public static int calculatePrice(ItemElement[] products, CartVisitor visitor) {
        int sum = 0;
        for (ItemElement product : products) {
            sum += product.accept(visitor);

        }
        return sum;
    }
}
