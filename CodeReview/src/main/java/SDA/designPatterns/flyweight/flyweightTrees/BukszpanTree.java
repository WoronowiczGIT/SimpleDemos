package SDA.designPatterns.flyweight.flyweightTrees;

public class BukszpanTree implements Tree {

    public BukszpanTree() throws InterruptedException {
        System.out.println("rendering " + this.getClass().getName());
        Thread.sleep(3000);
        System.out.println("rendering finished");
    }

    @Override
    public void showTree() {
        System.out.println("i dont know what i havve :-{");
    }
}
