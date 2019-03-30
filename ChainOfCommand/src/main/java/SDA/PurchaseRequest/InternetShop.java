package SDA.PurchaseRequest;

public class InternetShop extends Shop {
    @Override
    public void addShopItems(String model, Integer amount) {
        shopItems.put(model,amount);
    }
}
