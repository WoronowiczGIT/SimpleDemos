package SDA.PurchaseRequest;

public class PurchaseRequest {
    private String model;
    private int ammount;

    PurchaseRequest(String model, int ammount) {
        this.model = model;
        this.ammount = ammount;
    }

    public int getAmmount(){
        return ammount;
    }
    public String getModel(){
        return model;
    }

}
