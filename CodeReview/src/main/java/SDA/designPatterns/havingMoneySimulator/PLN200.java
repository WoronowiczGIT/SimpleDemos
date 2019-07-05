package SDA.designPatterns.havingMoneySimulator;

public class PLN200 extends Banknot{
    public PLN200(int amount, Banknot next) {
        super.value = 200;
        super.amount = amount;
        super.next = next;
    }
}
