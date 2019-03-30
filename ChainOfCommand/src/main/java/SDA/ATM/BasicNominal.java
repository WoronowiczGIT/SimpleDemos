package SDA.ATM;

public abstract class BasicNominal {
    protected Integer basic;
    protected BasicNominal successor;
    protected Integer amount = 0;

    public void setSuccessor(BasicNominal successor) {
        this.successor = successor;
    }


    public void processRequest(Request request) {
        while (request.getMoney() / basic >= 1) {
            int substract = request.getMoney() - basic;
            request.setMoney(substract);
            amount++;
        }
        System.out.println(basic + " x " + amount);
        if (request.getMoney() < basic && successor != null) {
            successor.processRequest(request);
        }
    }

    //
}
