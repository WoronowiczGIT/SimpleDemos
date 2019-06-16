package SDA.DesignPaterns.Mediator;

import SDA.DesignPaterns.Mediator.FireTruckDispatcher.ConcreteDispatcher;
import SDA.DesignPaterns.Mediator.FireTruckDispatcher.ConcreteFireTruck;
import SDA.DesignPaterns.Mediator.FireTruckDispatcher.Dispatcher;
import SDA.DesignPaterns.Mediator.FireTruckDispatcher.FireTruck;

public class Main {
    public static void main(String[] args) {

        Dispatcher dispatcher = new ConcreteDispatcher();
        FireTruck truck1 = new ConcreteFireTruck(false,dispatcher);
        FireTruck truck2 = new ConcreteFireTruck(true,dispatcher);
        FireTruck truck3 = new ConcreteFireTruck(false,dispatcher);
        FireTruck truck4 = new ConcreteFireTruck(false,dispatcher);

        dispatcher.addFireTruck(truck1);
        dispatcher.addFireTruck(truck2);
        dispatcher.addFireTruck(truck3);
        dispatcher.addFireTruck(truck4);

        truck1.readyForAction();

        dispatcher.dispatchAll("mountains");
    }

}
