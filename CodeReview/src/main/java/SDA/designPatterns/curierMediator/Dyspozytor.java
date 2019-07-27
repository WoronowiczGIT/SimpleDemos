package SDA.designPatterns.curierMediator;

import java.util.ArrayDeque;
import java.util.Queue;

public class Dyspozytor {
    private Queue<Runner> runners = new ArrayDeque<>();

    public void addRunner(Runner runner) {
        runners.add(runner);
    }

    public void processOrder(String order) throws InterruptedException {
        isRunnerFree();
        System.out.println(order + " recieved");
        Runner current = runners.poll();
        current.recievePackage(order);
        System.out.println(order + " passed to " + current.getRunner());
        Thread thread = new Thread(current);
        thread.start();
        System.out.println("-----------------");

    }

    private void isRunnerFree() throws InterruptedException {
        if(runners.isEmpty()){
            System.out.println("Sorry all runners are occupied");
        }
        while (runners.isEmpty()){

            Thread.sleep(1000);
        }
    }
}
