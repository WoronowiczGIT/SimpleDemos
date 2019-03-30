package SDA.PurchaseRequest;

public class Main {
    public static void main(String[] args) {
        LocalShop ls = new LocalShop();
        GlobalShop gs = new GlobalShop();
        InternetShop is = new InternetShop();

        ls.addShopItems("samsung",10);
        ls.setNextShop(gs);

        gs.addShopItems("nokia",5);
        gs.setNextShop(is);

        is.addShopItems("LG",8);


        PurchaseRequest request = new PurchaseRequest("LG",2);




        ls.processRequest(request);


    }
}
