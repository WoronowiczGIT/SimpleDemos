package SDA.designPatterns.havingMoneySimulator;

public class ATM {
    private static Banknot pln10 = new PLN10(10);
    private static Banknot pln20 = new PLN20(10, pln10);
    private static Banknot pln50 = new PLN50(10, pln20);
    private static Banknot pln100 = new PLN100(10, pln50);
    private static Banknot pln200 = new PLN200(5, pln100);

    public static void request(int value){
        pln200.processRequest(value);
    }

    public static void main(String[] args) {
        ATM.request(712324);
        ATM.request(124);
        ATM.request(324);


    }
}
