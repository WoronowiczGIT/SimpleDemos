package SDA.SOLID.LiskovSubstitution.CustomerDiscount;

public class ChristmasDiscount implements Discount {
    @Override
    public int getDiscount() {
        return 2;
    }
}
