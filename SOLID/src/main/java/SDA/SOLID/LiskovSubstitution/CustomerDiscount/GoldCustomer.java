package SDA.SOLID.LiskovSubstitution.CustomerDiscount;

public class GoldCustomer implements Discount,Customer {

    @Override
    public int getDiscount() {
        return 5;
    }

    @Override
    public void addToDB() {

    }
}
