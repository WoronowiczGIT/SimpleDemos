package SDA.SOLID.InterfaceSegregation.RestaurantInterfaces;

public interface OnlineOrder extends PayByBLIK, RemotePayment {
    void orderBySite();
}
