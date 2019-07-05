package SDA.designPatterns.havingMoneySimulator;

public class PLN50 extends Banknot{


    public PLN50(int amount, Banknot next) {
        super.value = 50;
        super.amount = amount;
        super.next = next;
    }

}
