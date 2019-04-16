package SDA.DesignPaterns.Mediator.FireTruckDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConcreteDispatcher implements Dispatcher{

    private List<FireTruck> fireTrucksList = new ArrayList<>();
    private Queue<FireTruck> idleFireTrucksQueue = new PriorityQueue<>();

    @Override
    public void dispatchAll(String adress) {
        for (FireTruck truck: fireTrucksList) {
            System.out.println("Go to "+adress);
            truck.getOrder(adress);
        }
    }
    @Override
    public void dispatchAllAvailable(String adress) {
        for (FireTruck truck: fireTrucksList) {
            if(!truck.isInAction()) {
                System.out.println("If you are available - go to "+adress);
                truck.getOrder(adress);}
        }
    }

    @Override
    public void reportIdle(FireTruck truck) {
        System.out.println(" new truck ready for action!");
        idleFireTrucksQueue.add(truck);
    }
    @Override
    public void dispatchFirstFree(String adress) {
       idleFireTrucksQueue.poll().getOrder(adress);
    }

    @Override
    public void addFireTruck(FireTruck truck) {
        fireTrucksList.add(truck);
    }


}
