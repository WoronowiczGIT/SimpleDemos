package SDA.designPatterns.havingMoneySimulator;

public abstract class Banknot {
    protected int value;
    protected int amount;
    protected Banknot next;

    private int change;
    private int amountRequested;

    void processRequest(int request) {
        if (validateRequest(request)) return;
        if (caseOutOfMoney(request)) return;

        amountRequested = request / value;
        change = request % value;

        if (checkAmount()) {
            caseEnoughResources();
        } else
            caseNotEnoughResources();

        forward(change);
    }

    boolean checkAmount() {
        return amountRequested <= 0;
    }

    void caseNotEnoughResources() {
        System.out.println("sending: " + amount + " x " + value + " PLN");
        change += (amountRequested - amount) * value;
        amount = 0;
    }

    void caseEnoughResources() {
        if (amountRequested != 0) {
            System.out.println("sending: " + amountRequested + " x " + value + " PLN");
            amount -= amountRequested;
        }
    }

    boolean validateRequest(int request) {
        return request < 0;
    }

    boolean caseOutOfMoney(int request) {
        if (amount == 0) {
            next.processRequest(request);
        }
        return amount == 0;
    }

    void forward(int rest) {
        if (rest > 0) {
            next.processRequest(rest);
        } else System.out.println("thank you!");
    }
}
