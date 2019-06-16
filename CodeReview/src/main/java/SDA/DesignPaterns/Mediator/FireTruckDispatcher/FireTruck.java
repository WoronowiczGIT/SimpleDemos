package SDA.DesignPaterns.Mediator.FireTruckDispatcher;

public interface FireTruck {
    void getOrder(String adress);
    Boolean isInAction();
    void readyForAction();
}
