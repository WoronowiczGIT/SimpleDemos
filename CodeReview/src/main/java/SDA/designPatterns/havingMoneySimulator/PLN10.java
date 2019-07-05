package SDA.designPatterns.havingMoneySimulator;

public class PLN10 extends Banknot {

    public PLN10(int amount) {
        super.value = 10;
        super.amount = amount;
    }
    @Override
    boolean caseOutOfMoney(int request) {
        if(amount == 0){
            forward(request);
        }
        return amount == 0;
    }
    @Override
    void forward(int rest) {
        if (rest > 0) {
            System.out.println("not enough pylons - " + rest + "PLN returned to an account");
        } else System.out.println("thank you!");
    }

}
