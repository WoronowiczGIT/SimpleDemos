package SDA.designPatterns.havingMoneySimulator;

public class PLN100 extends Banknot{

    public PLN100(int amount, Banknot next) {
        super.value = 100;
        super.amount = amount;
        super.next = next;
    }
}
