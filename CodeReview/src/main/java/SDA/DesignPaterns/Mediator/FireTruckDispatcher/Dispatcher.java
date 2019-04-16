package SDA.DesignPaterns.Mediator.FireTruckDispatcher;

public interface Dispatcher {

    void dispatchAllAvailable(String adress);
    void dispatchFirstFree(String adress);
    void dispatchAll(String adress);
    void addFireTruck(FireTruck truck);
    void reportIdle(FireTruck truck);

}
