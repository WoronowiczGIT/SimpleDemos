package SDA.DesignPaterns.Mediator.FireTruckDispatcher;

public class ConcreteFireTruck implements FireTruck {
    private Boolean isInAction;
    private Dispatcher myDispatcher;

    public ConcreteFireTruck(Boolean isInAction, Dispatcher myDispatcher) {
        this.isInAction = isInAction;
        this.myDispatcher = myDispatcher;
    }

    @Override
    public void getOrder(String adress) {
        System.out.println("Heading to " + adress);
        isInAction = true;
    }

    @Override
    public Boolean isInAction() {
        return isInAction;
    }

    @Override
    public void readyForAction() {
        isInAction = false;
        myDispatcher.reportIdle(this);
    }
}
