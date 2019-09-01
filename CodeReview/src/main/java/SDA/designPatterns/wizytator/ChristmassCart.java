package SDA.designPatterns.wizytator;

public class ChristmassCart implements CartVisitor {
    @Override
    public int visit(Laptop laptop) {
        int discount = (laptop.getPrice() / 500) * 50;
        return laptop.getPrice() - discount;
    }

    @Override
    public int visit(WashingMashine washingMashine) {
        if (washingMashine.getPrice() > 3000) {
            double discount = washingMashine.getPrice() * 0.1;
            return washingMashine.getPrice() - (int) discount;

        } else {
            return washingMashine.getPrice();
        }
    }

}
