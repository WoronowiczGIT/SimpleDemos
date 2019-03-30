package SDA.ATM;

public class Main {

    public static void main(String[] args) {
        Nominal10 dycha = new Nominal10();
        Nominal20 dwiedychy = new Nominal20();
        Nominal100 stowa = new Nominal100();
        stowa.setSuccessor(dwiedychy);
        dwiedychy.setSuccessor(dycha);
        Request req = new Request(530);

        stowa.processRequest(req);
        stowa.processRequest(req);
    }
}
