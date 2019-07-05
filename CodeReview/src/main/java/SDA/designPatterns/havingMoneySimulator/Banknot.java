package SDA.designPatterns.havingMoneySimulator;

public abstract class Banknot {
    protected int value;
    protected int amount;
    protected Banknot next;

    void processRequest(int request) {
        if(caseOutOfMoney(request))return;

        int amountRequested = request / value;
        int rest = request % value;
        if (amountRequested > amount) {
            System.out.println("sending: " + amount + " x " + value);
            rest += (amountRequested - amount) * value;
            amount = 0;
        } else {
            if(amountRequested != 0){
                System.out.println("sending: " + amountRequested + " x " + value);
                amount -= amountRequested;
            }else {
                next.processRequest(rest);
                return;
            }
        }
        forward(rest);
    }
    boolean caseOutOfMoney(int request) {
        if(amount == 0){
            next.processRequest(request);
        }
        return amount == 0;
    }

    void forward(int rest){
        if (rest > 0) {
            next.processRequest(rest);
        } else System.out.println("thank you!");
    }
}
