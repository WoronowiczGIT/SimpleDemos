package SDA.SOLID.InterfaceSegregation.RestaurantInterfaces;

public interface MobileOrder extends PayByBLIK, RemotePayment {
    void orderByPhone();
}
