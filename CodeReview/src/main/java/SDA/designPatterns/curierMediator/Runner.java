package SDA.designPatterns.curierMediator;

public class Runner implements Runnable {
    private Dyspozytor dyspozytor;
    private String order;
    private String name;

    public Runner(Dyspozytor dyspozytor, String name){
        this.dyspozytor = dyspozytor;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(7000);
            System.out.println("\t\t\t"+order + " delivered by " + name);
            Thread.sleep(1000);

            order = "empty";
            dyspozytor.addRunner(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void recievePackage(String order){
        this.order = order;
    }

    public String getRunner(){
        return name;
    }


}
