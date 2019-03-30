package SDA.PurchaseRequest;

import java.util.HashMap;
import java.util.Map;

public class LocalShop extends Shop{

    @Override
    public void addShopItems(String model, Integer amount) {
        shopItems.put(model,amount);
    }
}
