package SDA.SOLID.LiskovSubstitution.CustomerDiscount;

public class PlatiniumCustomer implements Customer, Discount {

    @Override
    public void addToDB() {

    }

    @Override
    public int getDiscount() {
        return 10;
    }
}
