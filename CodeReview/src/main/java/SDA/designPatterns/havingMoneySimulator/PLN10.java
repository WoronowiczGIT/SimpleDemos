package SDA.designPatterns.havingMoneySimulator;

public class PLN10 extends Banknot {

    public PLN10(int amount) {
        super.value = 10;
        super.amount = amount;
    }

    @Override
    void processRequest(int request) {
        if(caseOutOfMoney(request)) return;

        int weNeed = request / value;
        int rest = request % value;
        if (weNeed > amount) {
            System.out.println("sending: " + amount + " x " + value);
            rest += (weNeed - amount) * value;
            amount = 0;
        } else {
            if (weNeed != 0) {
                System.out.println("sending: " + weNeed + " x " + value);
                amount -= weNeed;
            }
        }

        forward(rest);
    }

    boolean caseOutOfMoney(int request) {
        if(amount == 0){
            forward(request);
        }
        return amount == 0;
    }

    void forward(int rest) {
        if (rest > 0) {
            System.out.println("not enough pylons - " + rest + "PLN returned to an account");
        } else System.out.println("thank you!");
    }

}
