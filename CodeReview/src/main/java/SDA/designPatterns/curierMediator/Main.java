package SDA.designPatterns.curierMediator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dyspozytor DHL = new Dyspozytor();

        DHL.addRunner(new Runner(DHL,"adam"));
        DHL.addRunner(new Runner(DHL,"maciek"));
        DHL.addRunner(new Runner(DHL,"tomek"));
        DHL.addRunner(new Runner(DHL,"robert"));

        for (int i = 0; i < 40; i++) {
            Thread.sleep(1000);
            DHL.processOrder("zamowienie nr "+i);
        }
    }
}
