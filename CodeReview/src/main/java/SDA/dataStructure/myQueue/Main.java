package SDA.dataStructure.myQueue;

public class Main {
    public static void main(String[] args) {
        Shop biedronka = new Shop();

        biedronka.addClient(new Client("pomidory"));
        biedronka.addClient(new Client("banany"));
        biedronka.addClient(new Client("becon"));
        biedronka.addClient(new Client("pajaki"));
        biedronka.addClient(new Client("pajaki"));
        biedronka.addClient(new Client("pajaki"));
        biedronka.addClient(new Client("pajaki"));
        biedronka.addClient(new Client("pajaki"));
        biedronka.addClient(new Client("pajaki"));
        biedronka.addClient(new Client("pajaki"));
        biedronka.addClient(new Client("pajaki23"));

        while (!biedronka.isEmpty()){
            System.out.println(biedronka.pool().getShoppingList());
        }

    }
}
