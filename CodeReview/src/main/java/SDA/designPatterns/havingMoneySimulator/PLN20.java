package SDA.designPatterns.havingMoneySimulator;

public class PLN20 extends Banknot {

    public PLN20(int amount, Banknot next) {
        super.value = 20;
        super.amount = amount;
        super.next = next;
    }

}
