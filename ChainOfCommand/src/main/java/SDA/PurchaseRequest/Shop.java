package SDA.PurchaseRequest;

import java.util.HashMap;
import java.util.Map;

public abstract class Shop {
    protected Map<String, Integer> shopItems = new HashMap<>();
    protected Shop nextShop;
    protected Boolean modelAvailable = false;
    protected Boolean amountAvailable = false;

    public abstract void addShopItems(String model, Integer amount);

    public void setNextShop(Shop nextShop){
        this.nextShop = nextShop;
    }

    public void processRequest(PurchaseRequest request) {
        String requestedModel = request.getModel();
        Integer requestedAmount = request.getAmmount();

        if (shopItems.containsKey(requestedModel)) {
            modelAvailable = true;
            if (shopItems.get(requestedModel) >= requestedAmount) {
                amountAvailable = true;
            }
        }

        if (modelAvailable && amountAvailable) {
            System.out.println(getClass().getSimpleName() + " sold " + requestedAmount + " " + requestedModel);
        } else if (nextShop != null) {
            System.out.println("request sent to succesor");
            nextShop.processRequest(request);
        }

    }
}
